package com.salehere.salehereexam.data.sockethandler.service

import io.socket.client.IO
import io.socket.client.Socket
import java.net.URISyntaxException

class SocketHandlerImpl : SocketHandler {

    private lateinit var mSocket: Socket
    private lateinit var mSocketEmitter: Socket

    init {
        try {
            mSocket = IO.socket("https://px-socket-emitter.saleherethailand.com")
            mSocketEmitter = IO.socket("https://px-socket-emitter.saleherethailand.com/update")
        } catch (e: URISyntaxException) {
            e.printStackTrace()
        }
    }

    override fun setSocket() {
        mSocket.connect()
        mSocketEmitter.connect()
        println("test socket after connect ${mSocket.isActive}")
        println("test socketEmitter after connect ${mSocketEmitter.isActive}")
    }

    override fun getSocket(): Socket {
        return mSocket
    }

    override fun getSocketEmit(): Socket {
        return mSocketEmitter
    }

    override fun establishConnection() {
        mSocket.connect()
        mSocketEmitter.connect()
    }

    override fun closeConnection() {
        mSocket.disconnect()
        mSocketEmitter.disconnect()
    }
}