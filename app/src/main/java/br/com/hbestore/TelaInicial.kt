package br.com.hbestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationBarItemView
import kotlinx.android.synthetic.main.activity_tela_inicial.*


class TelaInicial : AppCompatActivity() {
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)

        // Pegando parâmetros vindos de outra Activy
        val parametros_tela_login = intent.extras

        // ? = Se não vir parâmetro ele não busca a chave (evita erros de buscar chave inexistente)
        val parametro_usuario = parametros_tela_login?.getString("parametro_usuario")
        val parametro_senha = parametros_tela_login?.getString("parametro_senha")

        // mostrar.text = "$parametro_usuario $parametro_senha"


        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        adapter = RecyclerViewAdapter()
        recyclerView.adapter = adapter

    }


}