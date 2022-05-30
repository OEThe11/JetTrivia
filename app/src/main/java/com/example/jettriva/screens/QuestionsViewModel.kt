package com.example.jettriva.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jettriva.data.DataOrException
import com.example.jettriva.model.GetTriviaResponseItem
import com.example.jettriva.repository.QuestionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestionsViewModel @Inject constructor(private val repository: QuestionRepository): ViewModel() {
    val data: MutableState<DataOrException<ArrayList<GetTriviaResponseItem>,
            Boolean, Exception>> = mutableStateOf(
        DataOrException(null, true, Exception("")))

    init {
        getAllQuestions()
    }


    private fun getAllQuestions(){
        viewModelScope.launch {
            data.value.loading = true
            data.value= repository.getAllQuestions()
            if (data.value.data.toString().isNotEmpty()){
                data.value.loading = false
            }
        }
    }
    fun getTotalQuestionCount(): Int{
        return data.value.data!!.toMutableList().size
    }

}