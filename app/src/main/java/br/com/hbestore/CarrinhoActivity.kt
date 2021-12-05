package br.com.hbestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_carrinho.*
import kotlinx.android.synthetic.main.toolbar.*

class CarrinhoActivity : NavegationDrawerActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carrinho)

        setSupportActionBar(toolbar)
        nav_menuLateral.setCheckedItem(R.id.nav_carrinho)
        supportActionBar?.title = "Carrinho"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        configuraMenuLateral()
    }
}