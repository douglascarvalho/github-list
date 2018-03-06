package com.doug.githublist.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.doug.githublist.R
import com.doug.githublist.data.Repository
import com.doug.githublist.ui.adapter.RepositoryAdapter
import kotlinx.android.synthetic.main.activity_repository.*

class RepositoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repository)

        var repositoryAdater = RepositoryAdapter();

        repositoryAdater.repositories = listOf(
                Repository(1, "um", "um"),
                Repository(2, "dois", "um"),
                Repository(3, "tres", "um"))

        repository_list.layoutManager = LinearLayoutManager(this)
        repository_list.adapter = repositoryAdater;
    }
}
