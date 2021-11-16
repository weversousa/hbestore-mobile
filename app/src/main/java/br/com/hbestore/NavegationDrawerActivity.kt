package br.com.hbestore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_tela_inicial.*
import kotlinx.android.synthetic.main.toolbar.*

open class NavegationDrawerActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

     protected fun configuraMenuLateral(){
        var toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.abrir,
            R.string.fechar
        )

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        nav_menuLateral.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_home -> {
                val intent = Intent(this, TelaInicial::class.java)
                startActivity(intent)
            }
            R.id.nav_carrinho ->{
                val intent = Intent(this, CarrinhoActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_mapa -> Toast.makeText(applicationContext,"Mapas", Toast.LENGTH_SHORT).show()
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}