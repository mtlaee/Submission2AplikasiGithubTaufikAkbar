package com.example.submission2aplikasigithubtaufikakbar.Api

import com.example.submission2aplikasigithubtaufikakbar.Response.DataUser
import com.example.submission2aplikasigithubtaufikakbar.Response.DetailUserResponse
import com.example.submission2aplikasigithubtaufikakbar.Response.ResponseUser
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @Headers("Authorization:token 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")
    @GET("search/users")
    fun searchuser(
        @Query("q") query: String
    ): Call<ResponseUser>


    @Headers("Authorization:token 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")
    @GET("users/{username}")
    fun detailuser(
        @Path("username") username: String
    ): Call<DetailUserResponse>


    @Headers("Authorization:token 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")
    @GET("users/{username}/followers")
    fun getfollowers(
        @Path("username") username: String
    ): Call<ArrayList<DataUser>>

    @Headers("Authorization:token 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")
    @GET("users/{username}/following")
    fun getfollowing(
        @Path("username") username: String
    ): Call<ArrayList<DataUser>>
}