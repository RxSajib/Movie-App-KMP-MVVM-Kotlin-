package org.wizard.project.repository.movie_details

import coil3.network.HttpException
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.HttpStatusCode
import io.ktor.http.URLProtocol
import io.ktor.http.buildUrl
import io.ktor.http.path
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.io.IOException
import org.wizard.project.data.datamanager.DataManager.ERROR_OCCURRED
import org.wizard.project.data.datamanager.DataManager.NO_INTERNET
import org.wizard.project.data.datamanager.DataManager.SERVER_ERROR
import org.wizard.project.ui.dto.MovieDetailsResponse
import org.wizard.project.utils.NetworkResult
import org.wizard.project.utils.logMessage

class SingleMovieDetails constructor(
    private val httpClient: HttpClient
) {

    private val mutableStateFlow = MutableStateFlow<NetworkResult<MovieDetailsResponse>>(NetworkResult.Empty())
    val stateFlow = mutableStateFlow.asStateFlow()


    suspend fun getSingleMovie(movieId : String){
        try {
            mutableStateFlow.emit(NetworkResult.Loading())
            val response = httpClient.get(
                buildUrl {
                    protocol = URLProtocol.HTTPS
                    host = "episodate.com/"
                    path("api/show-details")
                    parameters.append("q", movieId)
                }
            )

            if(response.status == HttpStatusCode.OK){
                val body : MovieDetailsResponse= response.body()
                mutableStateFlow.emit(NetworkResult.Success(data = body))
            }else {
                mutableStateFlow.emit(NetworkResult.Error(message = ERROR_OCCURRED))
            }

        }catch (e: HttpException) {
            mutableStateFlow.emit(NetworkResult.Error(SERVER_ERROR))
            logMessage(message = SERVER_ERROR)
        } catch (e: IOException) {
            mutableStateFlow.emit(NetworkResult.Error(NO_INTERNET))
            logMessage(message = NO_INTERNET)
        }
    }
}