package com.example.jettriva

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jettriva.screens.QuestionsViewModel
import com.example.jettriva.ui.theme.JetTrivaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetTrivaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TriviaHome()
                }
            }
        }
    }
}


@Composable
fun TriviaHome( viewModel: QuestionsViewModel = hiltViewModel()){
    Questions(viewModel)
}

@Composable
fun Questions( viewModel: QuestionsViewModel) {
    val questions = viewModel.data.value.data?.toMutableList()
    if (viewModel.data.value.loading == true){
        Log.d("LOADING", "Questions: ...Loading...")
    }else {
        Log.d("Loading", "Questions: Loading STOPPED...")
        questions?.forEach{ questionItem ->
            Log.d("Result", "Questions: ${questionItem.question}")
        }
    }

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetTrivaTheme {

    }
}