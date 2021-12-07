package br.com.hbestore.Activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.hbestore.*
import br.com.hbestore.Adapter.ProdutoAdapter
import kotlinx.android.synthetic.main.activity_tela_inicial.*
import kotlinx.android.synthetic.main.cardview_roupas.*
import kotlinx.android.synthetic.main.toolbar.*


class TelaInicial : NavegationDrawerActivity() {

    //Inicia o Action Bar
    lateinit var toggle : ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)

        // Pegando parâmetros vindos de outra Activy
        val parametros_tela_login = intent.extras

        // ? = Se não vir parâmetro ele não busca a chave (evita erros de buscar chave inexistente)
        val parametro_usuario = parametros_tela_login?.getString("parametro_usuario")
        val parametro_senha = parametros_tela_login?.getString("parametro_senha")


        // Importando a nossa Toolbar para ser exibida na tela
        setSupportActionBar(toolbar)

        // Título na toolbar e configuração do menu
        supportActionBar?.title = "Produtos"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        configuraMenuLateral()

        //Configurando Lista
        recyclerView?.layoutManager = LinearLayoutManager(this)
        recyclerView?.itemAnimator = DefaultItemAnimator()
        recyclerView?.setHasFixedSize(true)

        val usuario_prefs = Prefs.getString("nome_usuario")
        Toast.makeText(this, "Nome do usuario Prefs: $usuario_prefs", Toast.LENGTH_LONG).show()
    }

    fun onClickProduto(produto: Produto){
        Toast.makeText(this, "Clicou na Roupa ${produto.nome}", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, ProdutoActivity::class.java)
        intent.putExtra("produto", produto)
        startActivity(intent)
    }

    fun onClickItemCarrinho(produto: Produto){
        Toast.makeText(this, "Clicou na Roupa ${produto.nome}", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, CarrinhoActivity::class.java)
        intent.putExtra("produto", produto)
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
        taskProdutos()
    }
    var produtos = listOf<Produto>()
    fun taskProdutos(){
        Thread{
            this.produtos = ProdutoService.getProduto(this)
            runOnUiThread{
                recyclerView?.adapter = ProdutoAdapter(produtos){
                    onClickProduto(it)
                }

                enviaNotificacoes(this.produtos.get(1))
            }
        }.start()
    }

    fun enviaNotificacoes(produto: Produto){
        val intent = Intent(this, ProdutoActivity::class.java)
        intent.putExtra("produto", produto)
        NotificationUtil.create(
            1, intent, "LMSApp",
            "Veja as novidades - ${produto.nome} por ${produto.valor}"
        )
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_tela_inicial, menu)
        return super.onCreateOptionsMenu(menu)
    }

    // Função que captura cliques na barra de Menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        // Armazenar o ID do item clicado na barra de Menu
        val id = item.itemId

        // Descobrir qual item foi clicado através do seu ID e aplicar a ação que deseja para ele
        if (id == R.id.menu_item_buscar) {
            Toast.makeText(this, "Botão buscar", Toast.LENGTH_SHORT).show()
        } else if (id == R.id.menu_item_atualizar) {
            Toast.makeText(this, "Botão atualizar", Toast.LENGTH_SHORT).show()
        } else if(toggle.onOptionsItemSelected(item)){
            return true
        }else if (id === android.R.id.home) {
            // Se for clicado na seta de voltar (esse ID é fornecido pela aplicação não somos nós que criamos)
            // método que destrói a Activity atual, se ele vai destruir a atual a tela que será exibida é a anterior
            finish()
        }

        return super.onOptionsItemSelected(item)
    }
}