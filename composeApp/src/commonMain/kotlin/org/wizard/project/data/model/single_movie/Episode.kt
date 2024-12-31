package org.wizard.project.data.model.single_movie

import kotlinx.serialization.Serializable

@Serializable
data class Episode(
    val air_date: String?,
    val episode: Int?,
    val name: String?,
    val season: Int?
)