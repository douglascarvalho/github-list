package com.doug.githublist.data.datasource

import com.doug.githublist.data.api.GithubService
import com.doug.githublist.data.model.Repository

class GithubDataSource {

    private val githubService by lazy {
        GithubService.create()
    }

    fun getRepositoryList(): List<Repository>? {
        var response = githubService.repositoryList(1).execute()

        if (response.isSuccessful) {
            return response.body()?.repositories
        }

        return null
    }
}