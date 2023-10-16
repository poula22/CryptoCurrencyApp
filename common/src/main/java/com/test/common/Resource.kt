package com.test.common

sealed class Resource<T>(val data:T?=null,val message:String?=null){

    class Success<T> (val response: T):Resource<T>(data = response)
    class Error<T>(errorMessage:String,data: T?=null):Resource<T>(message = errorMessage, data = data)
    class Loading<T>(data: T?=null) :Resource<T>(data = data)
}