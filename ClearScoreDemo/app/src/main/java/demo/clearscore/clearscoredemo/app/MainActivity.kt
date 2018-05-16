package demo.clearscore.clearscoredemo.app

import android.app.ActionBar
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import demo.clearscore.clearscoredemo.R
import demo.clearscore.clearscoredemo.app.utils.DialogUtil
import demo.clearscore.clearscoredemo.app.utils.hide
import demo.clearscore.clearscoredemo.app.utils.show
import demo.clearscore.clearscoredemo.core.network.ApiManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {
    private lateinit var presenter: MainPresenter

    /**
     * The onCreate method sets action bar custom layout, initializes and calls the presenter behavior
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        supportActionBar?.setCustomView(R.layout.action_bar)

        presenter = MainPresenterImpl(this, ApiManager)
        presenter.onViewCreated()

        swipe_refresh.setOnRefreshListener {
            presenter.onViewCreated()
        }
    }

    override fun onDestroy() {
        presenter.onViewDestroyed()
        super.onDestroy()
    }

    /**
     * Hides the score views and shows the loading progressbar
     */
    override fun showProgress() {
        progressBar.show()
        score_bar.hide()
        score.hide()
        score_label.hide()
        score_max.hide()
    }

    /**
     * Shows the score views and hides the loading progressbar
     */
    override fun hideProgress() {
        progressBar.hide()
        score_bar.show()
        score.show()
        score_label.show()
        score_max.show()
    }

    /**
     * Let displayed only the score bar background
     */
    override fun errorHide() {
        progressBar.hide()
        score.hide()
        score_label.hide()
        score_max.hide()
        score_bar.show()

        swipe_refresh.isRefreshing = false
        score_bar.max = 0
        score_bar.progress = 0
    }

    /**
     * Sets the score information
     * @param score The score value
     * @param max The max score value
     */
    override fun setData(score: Int, max: Int) {
        this.score.text = score.toString()
        score_max.text = String.format(getString(R.string.score_max), max)
        score_bar.max = max
        score_bar.progress = score
        swipe_refresh.isRefreshing = false
    }

    /**
     * Shows an error dialog and calls the errorHide layout behavior
     */
    override fun showError(error: String?) {
        DialogUtil(this).showDialog(error ?: getString(R.string.unknown_error))
        errorHide()
    }
}
