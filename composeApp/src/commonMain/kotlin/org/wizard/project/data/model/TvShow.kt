package org.wizard.project.data.model

import kotlinx.serialization.Serializable

@Serializable
data class TvShow(
    val country: String? = null,
    val end_date: String ?  = null,
    val id: Int ,
    val image_thumbnail_path: String ? = null,
    val name: String ?= null,
    val network: String ? = null,
    val permalink: String? = null,
    val start_date: String ? = null,
    val status: String? = null
)