package br.com.hbestore

import okhttp3.*

object HttpHelper {
    var client = OkHttpClient()
    val JSON = MediaType.parse("aplication/json; charset=utf-8")

    fun get(url: String): String{
        val request = Request.Builder().url(url).get().build()
        return getJson(request)
    }

    fun post(url: String, json: String): String{
        val body = RequestBody.create(JSON, json)
        val request = Request.Builder().url(url).post(body).build()
        return getJson(request)
    }

    private fun getJson(request: Request): String{
        val response = client.newCall(request).execute()
        val body = response.body()
        val json = body?.string()
        return json!!
    }
}