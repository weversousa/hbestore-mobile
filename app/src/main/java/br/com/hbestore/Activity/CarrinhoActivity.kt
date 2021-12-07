package br.com.hbestore.Activity

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import br.com.hbestore.Produto
import br.com.hbestore.R
import kotlinx.android.synthetic.main.activity_carrinho.*
import kotlinx.android.synthetic.main.layout_carrinho_produtos.*
import kotlinx.android.synthetic.main.toolbar.*

class CarrinhoActivity() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carrinho)

        val produto = intent.getSerializableExtra("informacoes") as Produto
        if (arrayOf(produto).size != 0){
            tvNomeProduto.text = produto.nome;
            tvPrecoProduto.text = produto.valor
            tvQteProduto.text = "1"
            tvValorTotalItens.text = produto.valor
        }

        setSupportActionBar(toolbar)
        nav_menuLateral.setCheckedItem(R.id.nav_carrinho)
        supportActionBar?.title = "Carrinho"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        configuraMenuLateral()


    }
}