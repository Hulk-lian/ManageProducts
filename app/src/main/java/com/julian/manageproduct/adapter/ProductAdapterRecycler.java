package com.julian.manageproduct.adapter;


import android.content.Context;
import android.speech.RecognizerIntent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.julian.manageproduct.Product_Aplication;
import com.julian.manageproduct.R;
import com.julian.manageproduct.model.Product;

import java.util.ArrayList;
import java.util.List;

/*
el adapter no gestina un arrty list lo que gestiona son objetos view holder, tiene tantos viewholder como datos tenga
gestiona una coleccion de viewHolder

el recycler view no tiene ninguna copia interna
* */

public class ProductAdapterRecycler extends RecyclerView.Adapter<ProductAdapterRecycler.ProductViewHolder>{

    private List<Product> products;
    private  Context context;
    boolean orderAZ=true;

    public ProductAdapterRecycler(Context context) {

        this.context=context;

        products= new ArrayList<Product>(((Product_Aplication) context.getApplicationContext()).getProducts());
       // products=((Product_Aplication) context.getApplicationContext()).getProducts();

    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // el false es para que mantenga el xml como esta no crea un nuevo padre lo añade
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_product,parent,false);

        return new ProductViewHolder(item);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        holder.imgProd.setImageResource(products.get(position).getmImage());
        holder.txvNameCA.setText(products.get(position).getmName());
        holder.txvStockCA.setText(products.get(position).getFormatedStock());
        holder.txvPriceCA.setText(products.get(position).getFormatedPrice());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    /*
     se pone static para evitar que se creen demasiados objetos no ocupe tanta memoria y solo tengamos un objeto de ProductViewHolder
     */

    public static class ProductViewHolder extends RecyclerView.ViewHolder{

        ImageView imgProd;
        View viwLinea;
        TextView txvStockCA,txvNameCA,txvPriceCA;

        public ProductViewHolder(View item) {
            super(item);

            //hacer el inflate
            imgProd=(ImageView) item.findViewById(R.id.imgProd);
            txvPriceCA=(TextView)item.findViewById(R.id.txvPriceCA);
            txvNameCA=(TextView)item.findViewById(R.id.txvNameCA);
            txvStockCA=(TextView)item.findViewById(R.id.txvStockCA);
            viwLinea=(View)item.findViewById(R.id.viwLinea);
        }

    }

    public void getAllProdcts(List<Product> productList){
        products.clear();//limpia
        products.addAll(productList);//añade todos los elementos
        notifyDataSetChanged();//notifica a todas las vistas cuyo adapter sea esa lista Patron observable-observador
    }


    public void getAllSortedProducts(){
        orderAZ=!orderAZ;
        products.clear();
        products.addAll(((Product_Aplication) context.getApplicationContext()).getSortedProducts(orderAZ));
        notifyDataSetChanged();
    }

}
