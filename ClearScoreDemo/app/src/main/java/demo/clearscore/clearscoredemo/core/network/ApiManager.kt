package demo.clearscore.clearscoredemo.core.network

import demo.clearscore.clearscoredemo.core.utils.BASE_URL
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by Horatiu on 5/16/2018.
 *
 * Used to initialize the retrofit service
 */
object ApiManager {
    var apiRequest: ApiService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create())
            .build().create(ApiService::class.java)
}