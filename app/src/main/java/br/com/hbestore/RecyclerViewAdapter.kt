package br.com.hbestore

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    private val itemTitle = arrayOf("Conjunto de Ropas Femininas-Verão", "Conjunto de Ropas Femininas-Verão Floral", "Conjunto de Ropas Femininas-Inverno")
    private val itemDatail = arrayOf("R$150,00", "R$160,00", "R$200,00")
    private val itemImage = intArrayOf(
        R.drawable.roupa,
        R.drawable.roupa2,
        R.drawable.roupa3
    )

    // Aqui eu busco os textos de title e datail e a imagem
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var image : ImageView
        var textTitle : TextView
        var textDatail : TextView

        init {
            image = itemView.findViewById(R.id.item_image)
            textTitle = itemView.findViewById(R.id.item_title)
            textDatail = itemView.findViewById(R.id.item_datail)
        }
    }

    // Aqui eu estou buscando o CardView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.cardview_roupas, parent, false)

        return ViewHolder(v)
    }

    // Aqui tem o metodo para adicionar o efeito de click
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textTitle.text = itemTitle[position]
        holder.textDatail.text = itemDatail[position]
        holder.image.setImageResource(itemImage[position])

        holder.itemView.setOnClickListener{
            v: View -> Toast.makeText(v.context, "Clicked on the item", Toast.LENGTH_SHORT).show()
        }
    }

    //Aqui retorna o tamanho do titulo
    override fun getItemCount(): Int {
        return itemTitle.size
    }
}