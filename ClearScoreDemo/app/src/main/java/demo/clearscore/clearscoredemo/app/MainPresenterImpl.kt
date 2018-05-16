package demo.clearscore.clearscoredemo.app

import demo.clearscore.clearscoredemo.core.models.ScoreResponse
import demo.clearscore.clearscoredemo.core.network.ApiManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by Horatiu on 5/16/2018.
 *
 * The presenter implementation uses the view and the manager to process and send data to the activity
 */
class MainPresenterImpl(val view: MainView, private val apiManager: ApiManager): MainPresenter {
    private var subscription: Disposable? = null

    /**
     * Called in the activity onCreate() method, shows the progress bar and starts the api request
     */
    override fun onViewCreated() {
        view.showProgress()
        getCreditScore()
    }

    /**
     * Called when the activity is destroyed to dispose the existing disposable
     */
    override fun onViewDestroyed() {
        if(subscription != null)
            subscription?.dispose()
    }

    /**
     * Calls the request methods using RxJava behavior
     */
    private fun getCreditScore() {
        apiManager.apiRequest
                .getScore()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::onSuccess,this::onError)
    }

    /**
     * Hides the progress bar and sends the score and the maxScoreValue through view
     * @param score The received score
     */
    private fun onSuccess(score: ScoreResponse){
        view.hideProgress()
        view.setData(score.creditReportInfo.score, score.creditReportInfo.maxScoreValue)
    }

    /**
     * Shows the received error message
     * @param error Received error
     */
    private fun onError(error: Throwable){
        view.showError(error.localizedMessage)
    }
}