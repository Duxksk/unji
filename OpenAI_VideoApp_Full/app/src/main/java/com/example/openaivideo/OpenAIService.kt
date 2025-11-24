package com.example.openaivideo

import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

data class VideoRequest(val model:String="gpt-4o-video", val prompt:String)
data class VideoResponse(val video_url:String)

interface OpenAIService {
    @Headers("Content-Type: application/json")
    @POST("videos")
    suspend fun generate(@Body req:VideoRequest): VideoResponse
}
