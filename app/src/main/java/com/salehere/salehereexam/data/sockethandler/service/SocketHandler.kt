package com.salehere.salehereexam.data.sockethandler.service

import io.socket.client.Socket

interface SocketHandler {

    fun setSocket()

    fun getSocket(): Socket

    fun getSocketEmit(): Socket

    fun establishConnection()

    fun closeConnection()

}