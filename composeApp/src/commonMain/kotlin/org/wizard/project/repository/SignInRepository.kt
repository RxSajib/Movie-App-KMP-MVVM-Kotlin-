package org.wizard.project.repository

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.URLProtocol
import io.ktor.http.buildUrl
import io.ktor.http.path
import org.wizard.project.data.model.MostPopularResponse
import org.wizard.project.utils.logMessage

class SignInRepository constructor(
    private val httpClient: HttpClient
) {
    suspend fun loginAccount(page: String): MostPopularResponse {

        logMessage("my page $page")

        try {
            val url = buildString {
                append("https://www.episodate.com/api/most-popular?page=$page")
            }
           /* val response = httpClient.get {
                buildUrl {
                    protocol = URLProtocol.HTTPS
                    host = "www.episodate.com"
                    path("api/most-popular")
                    parameters.append("page", page)
                }
            }*/
            val response = httpClient.get(url)

            val body : MostPopularResponse = response.body()
            return body
        }catch (e : Exception){
            logMessage(message = e.message.toString())
            throw e
        }

    }
}