package com.example.jettriva.repository

import android.util.Log
import com.example.jettriva.data.DataOrException
import com.example.jettriva.model.GetTriviaResponseItem
import com.example.jettriva.network.QuestionApi
import javax.inject.Inject

private const val TAG = "QuestionRepository"

class QuestionRepository @Inject constructor(private val api: QuestionApi) {
    private val dataOrException =
        //Wrapping the ArrayList into a Check resource so that
        // the user can know if the data is loaded or not
        DataOrException<ArrayList<GetTriviaResponseItem>, Boolean, Exception>()

    suspend fun getAllQuestions(): DataOrException<ArrayList<GetTriviaResponseItem>, Boolean, Exception>{
        try {
            dataOrException.loading = true
            dataOrException.data = api.getAllQuestions()
            if (dataOrException.data.toString().isNotEmpty()) dataOrException.loading = false

        }catch (exception: Exception){
            dataOrException.e = exception
            Log.d(TAG, "getAllQuestions: ${dataOrException.e!!.localizedMessage}")

        }
        return dataOrException
    }
}