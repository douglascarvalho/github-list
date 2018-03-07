package com.doug.githublist.data.repository

import android.arch.lifecycle.MutableLiveData
import com.doug.githublist.data.model.Repository
import com.doug.githublist.data.datasource.GithubDataSource
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch

class RepoRepository {

    fun doSearch() : MutableLiveData<List<Repository>> {
        val repositories = MutableLiveData<List<Repository>>()
        var githubDataSource = GithubDataSource()

        launch {
            val result = async {
                githubDataSource.getRepositoryList()
            }.await()

            repositories.postValue(result)
        }

        return repositories
    }

}