package com.example.jettriva.network

import com.example.jettriva.model.GetTriviaResponse
import retrofit2.http.GET
import javax.inject.Singleton


@Singleton
interface QuestionApi {
    @GET(Endpoints.QUESTION_EP)
    suspend fun getAllQuestions(): GetTriviaResponse
}