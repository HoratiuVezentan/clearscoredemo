package demo.clearscore.clearscoredemo.app

/**
 * Created by Horatiu on 5/16/2018.
 */
interface MainView{

    fun showProgress()

    fun hideProgress()

    fun errorHide()

    fun setData(score: Int, max: Int)

    fun showError(error: String?)
}