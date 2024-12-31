package org.wizard.project.repository.movie_list

import androidx.paging.PagingSource
import androidx.paging.PagingState
import org.wizard.project.data.model.TvShow
import org.wizard.project.utils.logMessage

const val KEY_FIRST_INDEX = 1
class MoviePagingSource constructor(
    val signInRepository: SignInRepository
) : PagingSource<Int, TvShow>() {
    override fun getRefreshKey(state: PagingState<Int, TvShow>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TvShow> {
        return try {
            val key = params.key ?: KEY_FIRST_INDEX
            logMessage("page $key")
            val response = signInRepository.loginAccount(page = key.toString())
            LoadResult.Page(
                data = response.tv_shows,
                prevKey = if(key == KEY_FIRST_INDEX) null else key - 1,
                nextKey = if(response.tv_shows.isEmpty()) null else key + 1
            )
        }catch (e : Exception){
            logMessage("error paging ${e.message.toString()}")
            LoadResult.Error(e)
        }
    }
}