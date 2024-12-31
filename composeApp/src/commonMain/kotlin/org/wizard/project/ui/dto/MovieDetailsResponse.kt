package org.wizard.project.ui.dto

import kotlinx.serialization.Serializable
import org.wizard.project.data.model.single_movie.TvShow

@Serializable
data class MovieDetailsResponse(
    val tvShow: TvShow?
)