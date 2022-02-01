package com.example.api

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response


class Nt {
    private val okHttpClient = OkHttpClient.Builder().build()
    fun fts(url:String): Response {
        return okHttpClient.newCall(Request.Builder().url(url).build()).execute()
    }
}
