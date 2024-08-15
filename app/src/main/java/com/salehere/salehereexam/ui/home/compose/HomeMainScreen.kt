package com.salehere.salehereexam.ui.home.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.salehere.salehereexam.ui.home.model.HomeUiState

@Composable
fun HomeMainScreen(
    navHostController: NavHostController,
    //viewModel: HomeViewModel = koinViewModel(),
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Text(text = "Test Home", modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.Center))
    }
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    uiState: HomeUiState,
    onImageClicked: (String, String) -> Unit,
) {

}