package org.wizard.project.repository.movie_list

import androidx.paging.Pager
import androidx.paging.PagingConfig
import io.ktor.client.HttpClient

class MoviePager constructor(
    private val httpClient: HttpClient
) {

    val movie = Pager(PagingConfig(pageSize = 20, enablePlaceholders = false), pagingSourceFactory = {
        MoviePagingSource( SignInRepository(
            httpClient = httpClient
        )
        )
    })

    .flow
}