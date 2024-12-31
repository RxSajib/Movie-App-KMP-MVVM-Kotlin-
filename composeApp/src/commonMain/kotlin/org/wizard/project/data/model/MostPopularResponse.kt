package org.wizard.project.data.model

import kotlinx.serialization.Serializable

@Serializable
data class MostPopularResponse(
    val page: Int,
    val pages: Int,
    val total: Int,
    val tv_shows: List<TvShow>
)