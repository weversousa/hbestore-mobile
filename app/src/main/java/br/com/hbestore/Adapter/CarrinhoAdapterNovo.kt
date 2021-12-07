package br.com.hbestore.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import br.com.hbestore.Produto
import br.com.hbestore.R
import com.squareup.picasso.Picasso

class CarrinhoAdapterNovo(
    val produto: List<Produto>,
    val onClick: (Produto) -> Unit
    ): RecyclerView.Adapter<CarrinhoAdapterNovo.ProdutoViewHolder>()
{
    class ProdutoViewHolder(view: View): RecyclerView.ViewHolder(view){
        val cardNomeProduto: TextView
        val cardValorProduto: TextView
        val cardImg: ImageView
        val cardProgress: ProgressBar
        val cardView: CardView

        init {
            cardNomeProduto = view.findViewById(R.id.item_title)
            cardValorProduto = view.findViewById(R.id.item_datail)
            cardImg = view.findViewById(R.id.item_image)
            cardProgress = view.findViewById(R.id.card_progress)
            cardView = view.findViewById(R.id.Card_View_Roupas)
        }
    }

    override fun getItemCount() = this.produto.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cardview_roupas, parent, false)
        val holder = ProdutoViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: ProdutoViewHolder, position: Int) {
        val context = holder.itemView.context
        val produto = this.produto[position]

        holder.cardNomeProduto.text = produto.nome
        holder.cardValorProduto.text = produto.valor
        holder.cardProgress.visibility = View.VISIBLE

        Picasso.with(context).load(produto.url).fit().into(holder.cardImg,
                object : com.squareup.picasso.Callback{
                    override fun onSuccess() {
                        holder.cardProgress.visibility = View.GONE
                    }

                    override fun onError() {
                        holder.cardProgress.progress = View.GONE
                    }
                }
            )
        holder.itemView.setOnClickListener{onClick(produto)}
    }

}