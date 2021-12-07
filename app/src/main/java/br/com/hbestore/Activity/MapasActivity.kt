package br.com.hbestore.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.hbestore.MapaFragment
import br.com.hbestore.R

class MapasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mapas)
    }

    override fun onResume() {
        super.onResume()
        val mapaFragment = MapaFragment()
        supportFragmentManager.beginTransaction().replace(R.id.layoutMapas, mapaFragment).commit()
    }
}