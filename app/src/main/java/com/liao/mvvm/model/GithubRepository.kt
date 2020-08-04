package com.liao.mvvm.model

import com.google.gson.annotations.SerializedName

data class GithubRepository(
    val author: String?,
    val name: String?,
    val url: String?,
    val avatar: String?,
    @SerializedName("description")
    val description: String?
) {
}