package br.com.hbestore.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import br.com.hbestore.Produto
import br.com.hbestore.ProdutoService
import br.com.hbestore.R
import kotlinx.android.synthetic.main.activity_produto.*

class ProdutoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produto)

        supportActionBar?.title = "Produto"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        configuraMenuLateral()

        //Aqui traz as informações do produto da tela inicial
        val produto = intent.getSerializableExtra("produto") as Produto
        nomeRoupa.text = produto.nome
        valorRoupa.text = produto.valor

        btnAddProduto?.setOnClickListener(){
            Thread{
                Log.d("Botao", "Clicou")
                runOnUiThread{
                    Toast.makeText(this,"Clicou no botão de adicionar carrinho", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, CarrinhoActivity::class.java)
                    val infoProdutos = produto
                    intent.putExtra("informacoes",infoProdutos)

                    startActivity(intent)
                }
            }.start()
        }
        //Toast.makeText(this, "${produto.nome}", Toast.LENGTH_LONG).show()
    }


}