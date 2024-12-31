package org.wizard.project.ui.dto

import kotlinx.serialization.Serializable
import org.wizard.project.data.model.TvShow

@Serializable
data class MostPopularResponse(
    val page: Int,
    val pages: Int,
    val total: Int,
    val tv_shows: List<TvShow>
)