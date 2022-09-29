package com.example.sampleapp.data.network.interceptor

import com.example.sampleapp.utils.ApiConstant
import okhttp3.Interceptor
import okhttp3.Response

class AuthTokenInterceptor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val originalRequest = chain.request()
        val requestBuilder = originalRequest.newBuilder()
            .header("key", ApiConstant.APP_ID)
            .header("aqi", "no")
        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}