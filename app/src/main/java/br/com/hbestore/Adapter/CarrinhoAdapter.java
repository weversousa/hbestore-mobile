package br.com.hbestore.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.hbestore.ItemDoCarrinho;
import br.com.hbestore.R;

public class CarrinhoAdapter {
    private Context context;
    private List<ItemDoCarrinho> itensCarrinho;

    public CarrinhoAdapter(Context context, List<ItemDoCarrinho> itemCarrinho){
        this.context = context;
        this.itensCarrinho = itemCarrinho;
    }

    public int getCount(){
        return this.itensCarrinho.size();
    }

    public Object getItem(int posicao){
        return this.itensCarrinho.get(posicao);
    }

    public long getItemId(int posicao){
        return posicao;
    }

    public void removerProduto(int posicao){
        this.itensCarrinho.remove(posicao);
        notify();
    }

    public View getView(int posicao, View view, ViewGroup viewGroup){
        View v = View.inflate(this.context, R.layout.layout_carrinho_produtos, null);
        TextView tvNomeProduto = (TextView) v.findViewById(R.id.tvNomeProduto);
        TextView tvPrecoProduto = (TextView) v.findViewById(R.id.tvPrecoProduto);
        TextView tvQtdProduto = (TextView) v.findViewById(R.id.tvQteProduto);
        TextView tvValorItem = (TextView) v.findViewById(R.id.tvValorTotalItens);

        tvNomeProduto.setText(this.itensCarrinho.get(posicao).getNome());
        tvPrecoProduto.setText(String.valueOf(this.itensCarrinho.get(posicao).getPrecoProduto()));
        tvQtdProduto.setText(String.valueOf(this.itensCarrinho.get(posicao).getQuantidadeSelecionada()));
        tvValorItem.setText(String.valueOf(this.itensCarrinho.get(posicao).getPrecoDoItemVenda()));

        return v;
    }

    public void atualizar (List<ItemDoCarrinho> itensCarrinho){
        this.itensCarrinho.clear();
        this.itensCarrinho = itensCarrinho;
        this.notify();
    }



}
