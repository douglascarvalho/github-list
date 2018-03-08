package com.doug.githublist.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.doug.githublist.R
import com.doug.githublist.data.model.Repository
import kotlinx.android.synthetic.main.item_repository.view.*

class RepositoryAdapter : RecyclerView.Adapter<RepositoryAdapter.ViewHolder>() {

    var repositories: List<Repository>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_repository, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return repositories?.size ?: 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindRepository(repositories!![position])
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bindRepository(repository: Repository) {
            with(repository) {
                itemView.repositoryName.text = name
                itemView.repositoryDescription.text = description
                itemView.forksCount.text = forksCount.toString()
                itemView.starsCount.text = starsCount.toString()
                itemView.ownerLogin.text = owner.login

                Glide.with(itemView.context)
                        .load(owner.avatarURL)
                        .apply(options)
                        .into(itemView.ownerAvatar)
            }
        }

        companion object {
            val options = RequestOptions()
                    .placeholder(R.drawable.avatar_placeholder)
                    .transforms(RoundedCorners(70))
        }
    }
}