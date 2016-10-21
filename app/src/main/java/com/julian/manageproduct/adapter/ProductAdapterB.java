package com.julian.manageproduct.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.julian.manageproduct.Product_Aplication;
import com.julian.manageproduct.R;
import com.julian.manageproduct.model.Product;


public class ProductAdapterB extends ArrayAdapter<Product> {

    public ProductAdapterB(Context context) {
        super(context, R.layout.item_list_product,((Product_Aplication)context.getApplicationContext()).getProducts());

    }

    //metodo un poco mas optimo que el A
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imgProd;
        View viwLinea;
        TextView txvStockCA,txvNameCA,txvPriceCA;

        //1.crear un objeto inflaer que incicializamos al Layout inflater del contexto
        LayoutInflater inflater =(LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        //2.inflar la vista . crear en memoria el objeto view que contienen los widgets
        View item= inflater.inflate(R.layout.item_list_product,null);

        //3.vinculado con el item(view), que se acaba de crear, con las variables
        imgProd=(ImageView) item.findViewById(R.id.imgProd);
        txvPriceCA=(TextView)item.findViewById(R.id.txvPriceCA);
        txvNameCA=(TextView)item.findViewById(R.id.txvNameCA);
        txvStockCA=(TextView)item.findViewById(R.id.txvStockCA);
        viwLinea=(View)item.findViewById(R.id.viwLinea);

        // signar datos del adapter a los widget
            imgProd.setImageResource(getItem(position).getmImage());
            txvNameCA.setText(getItem(position).getmName());
            txvPriceCA.setText(getItem(position).getFormatedPrice());
            txvStockCA.setText(getItem(position).getFormatedStock());


        return item;
    }

}
