package com.doug.githublist.data.model

import com.google.gson.annotations.SerializedName

data class Repository(
        val id: Long,
        val name: String,
        val description: String,

        @SerializedName("forks")
        val forksCount: Int,

        @SerializedName("stargazers_count")
        val starsCount: Int,

        val owner: Owner
)
