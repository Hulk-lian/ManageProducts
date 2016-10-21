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


public class ProductAdapterC extends ArrayAdapter<Product> {

    public ProductAdapterC(Context context) {
        super(context, R.layout.item_list_product,((Product_Aplication)context.getApplicationContext()).getProducts());

    }

    //metodo mas optimo que el A y el B
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View item=convertView;
        ProductHolder productholder;

        //si el item ya tiene memoria lo usa.
        //utiliza la misma zona de memoria, la reutiliza
        if(item==null) {
            //1.crear un objeto inflaer que incicializamos al Layout inflater del contexto
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);


            //2.inflar la vista . crear en memoria el objeto view que contienen los widgets
            item = inflater.inflate(R.layout.item_list_product, null);

            //asignar memoria al holder
            productholder= new ProductHolder();

            //3.vinculado con el item(view), que se acaba de crear, con las variables del holder
            //con las direcciones de memoria de lo que se esta visualizando
            productholder.imgProd=(ImageView) item.findViewById(R.id.imgProd);
            productholder.txvPriceCA=(TextView)item.findViewById(R.id.txvPriceCA);
            productholder.txvNameCA=(TextView)item.findViewById(R.id.txvNameCA);
            productholder.txvStockCA=(TextView)item.findViewById(R.id.txvStockCA);
            productholder.viwLinea=(View)item.findViewById(R.id.viwLinea);

            item.setTag(productholder);

        }
        else{
            //en caso de que se tenga un objeto se reutiliza
            productholder=(ProductHolder) item.getTag();
        }
        //4 asignar datos del adapter a los widget
        productholder.imgProd.setImageResource(getItem(position).getmImage());
        productholder.txvNameCA.setText(getItem(position).getmName());
        productholder.txvPriceCA.setText(getItem(position).getFormatedPrice());
        productholder.txvStockCA.setText(getItem(position).getFormatedStock());

        if(position%2==0)
        {
            item.setBackgroundResource(R.color.colorFondo1);
        }
        else{
            item.setBackgroundResource(R.color.colorFondo2);
        }


        return item;
    }

    /**
     * Cla
     * */
    class ProductHolder{
        ImageView imgProd;
        View viwLinea;
        TextView txvStockCA,txvNameCA,txvPriceCA;

    }
}
