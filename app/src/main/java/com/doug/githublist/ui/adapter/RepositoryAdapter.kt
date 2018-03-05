package com.doug.githublist.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.doug.githublist.R
import com.doug.githublist.data.Repository
import kotlinx.android.synthetic.main.item_repository.view.*

class RepositoryAdapter : RecyclerView.Adapter<RepositoryAdapter.ViewHolder>() {

    lateinit var repositories: List<Repository>;

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_repository, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return repositories.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindRepository(repositories[position])
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        fun bindRepository(repository: Repository) {
            itemView.name.text = repository.name
        }

    }
}