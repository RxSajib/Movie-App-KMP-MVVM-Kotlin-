package org.wizard.project.di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val ktorModule = module {
    single {
        HttpClient{
            install(ContentNegotiation){
                json(
                    json = Json {
                        ignoreUnknownKeys = true
                        coerceInputValues = true
                    },
                    contentType = ContentType.Any
                )
            }

            install(Logging){
                level = LogLevel.ALL
            }
        }
    }
}