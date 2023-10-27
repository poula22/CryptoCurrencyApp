package com.test.domain.repo

enum class CoinRemoteException(val message: String) {
    _404("not found"),
    _408("request timeout "),
    IO("Couldn't reach server"),
    OTHER("Http Exception occurred")
}