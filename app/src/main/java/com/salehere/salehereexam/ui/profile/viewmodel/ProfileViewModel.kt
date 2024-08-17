package com.salehere.salehereexam.ui.profile.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.salehere.salehereexam.data.sockethandler.service.SocketHandler
import io.socket.client.Socket
import kotlinx.coroutines.launch


class ProfileViewModel(private val socketHandler: SocketHandler) : ViewModel() {

    init {
        setSocket()
    }

    private fun setSocket() {
        viewModelScope.launch {
            socketHandler.setSocket()
            socketHandler.establishConnection()
        }
    }

    fun getSocket(): Socket {
        return socketHandler.getSocket()
    }

    fun getSocketEmit(): Socket {
        return socketHandler.getSocketEmit()
    }

    private fun disconnectSocket() {
        socketHandler.closeConnection()
    }

    override fun onCleared() {
        super.onCleared()
        disconnectSocket()
    }

}