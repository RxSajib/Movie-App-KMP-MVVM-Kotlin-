package org.wizard.project.data.model.single_movie

import kotlinx.serialization.Serializable

@Serializable
data class TvShow(
    val country: String?,
    val description: String?,
    val description_source: String?,
    val episodes: List<Episode?>?,
    val genres: List<String?>?,
    val id: Int?,
    val image_path: String?,
    val image_thumbnail_path: String?,
    val name: String?,
    val network: String?,
    val permalink: String?,
    val pictures: List<String?>?,
    val rating: String?,
    val rating_count: Int?,
    val runtime: Int?,
    val start_date: String?,
    val status: String?,
    val url: String?,
)