package com.example.jettriva.screens

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jettriva.component.QuestionDisplay
import com.example.jettriva.component.Questions

@Composable
fun TriviaHome( viewModel: QuestionsViewModel = hiltViewModel()){
    Questions(viewModel)
}