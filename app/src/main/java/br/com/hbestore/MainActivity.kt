package br.com.hbestore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import kotlinx.android.synthetic.main.login.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        image_view_tela_inicial.setImageResource(R.drawable.hb_logo)

        edit_text_usuario.setText(Prefs.getString("nome_usuario"))
        edit_text_senha.setText(Prefs.getString("senha_usuario"))
        checkLogin.isChecked = Prefs.getBoolean("lembrar_login")

        // Evento click no botão da Tela de Login
        button_entrar.setOnClickListener {
            Toast.makeText(this,"Clicou no botão de login", Toast.LENGTH_LONG).show()

            progress_bar_entrar.visibility = View.VISIBLE

            // Pegar valores dos campos input
            val usuario = edit_text_usuario.text.toString()
            val senha = edit_text_senha.text.toString()
            val check_login = checkLogin.isChecked

            if (check_login){
                Prefs.setString("nome_usuario", usuario)
                Prefs.setString("senha_usuario", senha)
            }else {
                Prefs.setString("nome_usuario", "")
                Prefs.setString("senha_usuario", "")
            }
            Prefs.setBoolean("lembrar_login", check_login)


            if ((usuario == "usuario") and (senha == "senha")) {
                // Ir para outra tela
                // this = A Activy atual
                // TelaInicial::class.java = Referência para o SO da Activy que queremos abrir
                var intent = Intent(this, TelaInicial::class.java)

                // Passar parâmetros de uma Activy para outra
                val parametros = Bundle()
                parametros.putString("parametro_usuario", usuario)
                parametros.putString("parametro_senha", senha)

                // Informa a itent que junto a chamada estão sendo enviados outras coisas
                intent.putExtras(parametros)  // PS.: na Activy chamada é necessário pegar os parâmetros

                // Vai exibir o efeito de Processando antes de chamara nova Activy
                Handler(Looper.getMainLooper()).postDelayed({startActivity(intent)}, 5000)
            } else {
                Toast.makeText(this, "Login ou Senha incorretos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}