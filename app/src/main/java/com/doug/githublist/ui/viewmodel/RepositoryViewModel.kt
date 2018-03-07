package com.doug.githublist.ui.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.doug.githublist.data.model.Repository
import com.doug.githublist.data.repository.RepoRepository

class RepositoryViewModel : ViewModel() {

    lateinit var repositories: MutableLiveData<List<Repository>>

    fun init() {
        var repository = RepoRepository()
        repositories = repository.doSearch()
    }

}