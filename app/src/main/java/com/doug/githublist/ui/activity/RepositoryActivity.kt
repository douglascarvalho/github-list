package com.doug.githublist.ui.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.doug.githublist.R
import com.doug.githublist.ui.adapter.RepositoryAdapter
import com.doug.githublist.ui.viewmodel.RepositoryViewModel
import kotlinx.android.synthetic.main.activity_repository.*

class RepositoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repository)

        var repositoryAdater = RepositoryAdapter();

        var repositoryViewModel =
                ViewModelProviders.of(this).get(RepositoryViewModel::class.java)

        repositoryViewModel.init()
        repositoryViewModel.repositories.observe(this, Observer {
            repositoryAdater.repositories = it!!
            repositoryAdater.notifyDataSetChanged()
        })

        repository_list.adapter = repositoryAdater;
    }
}
