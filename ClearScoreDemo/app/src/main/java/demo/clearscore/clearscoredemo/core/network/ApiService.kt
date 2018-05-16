package demo.clearscore.clearscoredemo.core.network

import demo.clearscore.clearscoredemo.core.models.ScoreResponse
import io.reactivex.Single
import retrofit2.http.GET

/**
 * Created by Horatiu on 5/16/2018.
 */
interface ApiService{
    @GET("prod/mockcredit/values")
    fun getScore() : Single<ScoreResponse>
}