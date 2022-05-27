package com.example.jettriva.repository

import com.example.jettriva.data.DataOrException
import com.example.jettriva.model.GetTriviaResponseItem
import com.example.jettriva.network.QuestionApi
import javax.inject.Inject

class QuestionRepository @Inject constructor(private val api: QuestionApi) {
    private val listOfQuestions =
        //Wrapping the ArrayList into a Check resource so that
        // the user can know if the data is loaded or not
        DataOrException<ArrayList<GetTriviaResponseItem>, Boolean, Exception>()
}