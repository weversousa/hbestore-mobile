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


        try {
            var produto = mutableListOf<Produto>()
//            var to_remove = Prefs.getString("to_remove") as MutableSet<String>
//            for (r in to_remove){
//                HttpHelper.delete("$host/ope/${r}")
//            }
            val url = "$host/ope"
            val json = HttpHelper.get(url)

            Log.d(TAG, json)
            produto = parseJson<MutableList<Produto>>(json)

            salvaDB(produto)
            return produto
        } catch (e: Exception) {
            return DatabaseManager.getProdutoDAO().findAll()
        }
    }

    private fun salvaDB(produto: List<Produto>){
        for (d in produto){
            val existe = DatabaseManager.getProdutoDAO().getById(d.id!!)
            if(existe == null){
                DatabaseManager.getProdutoDAO().insert(d)
            }
        }
    }

    fun salvaProduto(produto: Produto){
        val url = "$host/ope"
        var json = HttpHelper.post(url, GsonBuilder().create().toJson(produto))
    }

    fun removeProduto(produto: Produto){
        try {
            HttpHelper.delete("$host/ope/${produto.id}")
        }catch (e: java.lang.Exception){
            var to_remove = Prefs.getStringSet("to_remove") as MutableSet<String>
            to_remove.add(produto.id!!.toString())
            Prefs.setStringSet("to_remove", to_remove)
        }finally {
            DatabaseManager.getProdutoDAO().delete(produto)
        }
    }

    inline fun <reified T> parseJson(json: String): T{
        val type = object : TypeToken<T>(){}.type
        return Gson().fromJson(json, type)
    }
}