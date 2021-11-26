package br.com.hbestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_produto.*

class ProdutoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produto)

        //Aqui traz as informações do produto da tela inicial
        val produto = intent.getSerializableExtra("produto") as Produto
        nomeRoupa.text = produto.nome
        valorRoupa.text = produto.valor

        botaoRemove.setOnClickListener(){
            Thread{
                ProdutoService.removeProduto(produto)
                runOnUiThread{
                    finish()
                }
            }.start()
        }
        //Toast.makeText(this, "${produto.nome}", Toast.LENGTH_LONG).show()
    }


}