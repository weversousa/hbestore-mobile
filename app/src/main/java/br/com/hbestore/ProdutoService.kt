package br.com.hbestore

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken

object ProdutoService {
    val host = "https://bielanski.pythonanywhere.com"
    val TAG = "WS_LMSApp"

    fun getProduto(context: Context): List<Produto>{
        var produto = mutableListOf<Produto>()

        //Tem que colocar a chamada da API
        val url = "$host/ope"
        val json = HttpHelper.get(url)

        Log.d(TAG, json)
        produto = parseJson<MutableList<Produto>>(json)

        return produto
    }

    fun salvaProduto(produto: Produto){
        val url = "$host/ope"
        var json = HttpHelper.post(url, GsonBuilder().create().toJson(produto))
    }

    inline fun <reified T> parseJson(json: String): T{
        val type = object : TypeToken<T>(){}.type
        return Gson().fromJson(json, type)
    }
}