package com.salehere.salehereexam.ui.profile.compose

import android.app.Activity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.salehere.salehereexam.core.theme.AppTheme
import com.salehere.salehereexam.core.theme.black
import com.salehere.salehereexam.ui.profile.viewmodel.ProfileViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ProfileMainScreen(viewModel: ProfileViewModel = koinViewModel()) {
    val context = LocalContext.current
    val activity = context as Activity

    val socket = viewModel.getSocket()
    val socketEmitter = viewModel.getSocketEmit()

    socketEmitter.emit("new-notification", 1)

    socket.on("new-notification") { args ->
        val message = args[0] as String
        println("message from socket: $message")
    }

    ProfileScreen()
}

@Composable
fun ProfileScreen() {
    Box(modifier = Modifier.fillMaxSize()) {}
}

@Preview
@Composable
fun DefaultProfileMainScreenPreview() {
    AppTheme {
        ProfileScreen()
    }
}