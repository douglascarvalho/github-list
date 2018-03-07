package com.doug.githublist.data.api

import com.doug.githublist.data.model.Repository
import com.doug.githublist.data.model.RepositoryResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubService {

    @GET("search/repositories?q=language:Java&sort=stars")
    fun repositoryList(@Query("page") page: Int) : Call<RepositoryResponse>

    companion object {
        fun create(): GithubService {

            val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://api.github.com/")
                    .build();

            return retrofit.create(GithubService::class.java)
        }
    }


}