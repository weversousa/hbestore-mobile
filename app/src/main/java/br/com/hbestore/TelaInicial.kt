package br.com.hbestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_tela_inicial.*

class TelaInicial : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)

        // Pegando parâmetros vindos de outra Activy
        val parametros_tela_login = intent.extras

        // ? = Se não vir parâmetro ele não busca a chave (evita erros de buscar chave inexistente)
        val parametro_usuario = parametros_tela_login?.getString("parametro_usuario")
        val parametro_senha = parametros_tela_login?.getString("parametro_senha")

        mostrar.text = "$parametro_usuario $parametro_senha"
    }
}