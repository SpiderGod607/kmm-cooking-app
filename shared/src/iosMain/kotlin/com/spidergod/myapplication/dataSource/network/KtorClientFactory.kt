package com.spidergod.myapplication.dataSource.network

import io.ktor.client.*
import io.ktor.client.engine.darwin.*
import io.ktor.client.engine.ios.*


actual class KtorClientFactory {
    actual fun build(): HttpClient {
        return HttpClient(Darwin) {
           /* install(JsonFeature) {
                serializer = KotlinxSerializer(
                    kotlinx.serialization.json.Json {
                        ignoreUnknownKeys = true
                    }
                )
            }*/
        }
    }
}