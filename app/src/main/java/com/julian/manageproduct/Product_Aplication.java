package com.julian.manageproduct;


import android.app.Application;

import com.julian.manageproduct.model.Product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Product_Aplication extends Application {

    private ArrayList<Product> products = new ArrayList<Product>();

    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public void onCreate() {
        super.onCreate();
            //String mName, String mDescription,String mDosage, String mBrand, double mPrice, int mStock, int mImage
        addProduct(new Product("Diazepan","Diazepan del bueno","1gr","generico",10.2,50,R.drawable.pill2));
        addProduct(new Product("Prozac","Prozac capsula de 1gr","1gr","generico",10.2,0,R.drawable.pill2));
        addProduct(new Product("Diazepan","Diazepan del regulero","1gr","generico",15.2,500,R.drawable.pill2));
        addProduct(new Product("Dalsi","Dalsi de toda la vida","250ml","Dalsi SL",5.2,100,R.drawable.pill2));
        addProduct(new Product("Jarabe para la tos","jarabe para la tos ","125ml","generico",7.25,120,R.drawable.pill));
        addProduct(new Product("Mercromina","Frasco de mercromina ","100ml","generico",8.59,69,R.drawable.pill));
        addProduct(new Product("Betadine","Frasco de betadine 250ml","250ml","generico",4.2,20,R.drawable.pill2));
        addProduct(new Product("Paracetamol","paracetamol 1gr capsulas","1gr","generico",9.66,58,R.drawable.pill2));
        addProduct(new Product("Paracetamol","paracetamol 600mg capsulas","600mg","generico",12.0,6,R.drawable.pill2));
        addProduct(new Product("Ibuprofeno","Ibuprofeno sobres 1gr","1gr","generico",2.50,20,R.drawable.pill2));
        addProduct(new Product("Diazepan","Diazepan del bueno","1gr","generico",10.2,50,R.drawable.pill2));
        addProduct(new Product("Prozac","Prozac capsula de 1gr","1gr","generico",10.2,0,R.drawable.img_med));
        addProduct(new Product("Diazepan","Diazepan del regulero","1gr","generico",15.2,500,R.drawable.pill));
        addProduct(new Product("Dalsi","Dalsi de toda la vida","250ml","Dalsi SL",5.2,100,R.drawable.pill));
        addProduct(new Product("Jarabe para la tos","jarabe para la tos ","125ml","generico",7.25,120,R.drawable.pill));
        addProduct(new Product("Mercromina","Frasco de mercromina ","100ml","generico",8.59,69,R.drawable.pill));
        addProduct(new Product("Betadine","Frasco de betadine 250ml","250ml","generico",4.2,20,R.drawable.pill));
        addProduct(new Product("Paracetamol","paracetamol 1gr capsulas","1gr","generico",9.66,58,R.drawable.img_med));
        addProduct(new Product("Paracetamol","paracetamol 600mg capsulas","600mg","generico",12.0,6,R.drawable.img_med));
        addProduct(new Product("Ibuprofeno","Ibuprofeno sobres 1gr","1gr","generico",2.50,20,R.drawable.pill2));
        addProduct(new Product("Diazepan","Diazepan del bueno","1gr","generico",10.2,50,R.drawable.pill));
        addProduct(new Product("Prozac","Prozac capsula de 1gr","1gr","generico",10.2,0,R.drawable.pill2));
        addProduct(new Product("Diazepan","Diazepan del regulero","1gr","generico",15.2,500,R.drawable.pill));
        addProduct(new Product("Dalsi","Dalsi de toda la vida","250ml","Dalsi SL",5.2,100,R.drawable.img_med));
        addProduct(new Product("Jarabe para la tos","jarabe para la tos ","125ml","generico",7.25,120,R.drawable.pill));
        addProduct(new Product("Mercromina","Frasco de mercromina ","100ml","generico",8.59,69,R.drawable.img_med));
        addProduct(new Product("Betadine","Frasco de betadine 250ml","250ml","generico",4.2,20,R.drawable.pill));
        addProduct(new Product("Paracetamol","paracetamol 1gr capsulas","1gr","generico",9.66,58,R.drawable.pill2));
        addProduct(new Product("Paracetamol","paracetamol 600mg capsulas","600mg","generico",12.0,6,R.drawable.pill));
        addProduct(new Product("Ibuprofeno","Ibuprofeno sobres 1gr","1gr","generico",2.50,20,R.drawable.pill2));
        addProduct(new Product("Diazepan","Diazepan del bueno","1gr","generico",10.2,50,R.drawable.pill));
        addProduct(new Product("Prozac","Prozac capsula de 1gr","1gr","generico",10.2,0,R.drawable.img_med));
        addProduct(new Product("Diazepan","Diazepan del regulero","1gr","generico",15.2,500,R.drawable.img_med));
        addProduct(new Product("Dalsi","Dalsi de toda la vida","250ml","Dalsi SL",5.2,100,R.drawable.pill2));
        addProduct(new Product("Jarabe para la tos","jarabe para la tos ","125ml","generico",7.25,120,R.drawable.pill2));
        addProduct(new Product("Mercromina","Frasco de mercromina ","100ml","generico",8.59,69,R.drawable.pill2));
        addProduct(new Product("Betadine","Frasco de betadine 250ml","250ml","generico",4.2,20,R.drawable.pill));
        addProduct(new Product("Paracetamol","paracetamol 1gr capsulas","1gr","generico",9.66,58,R.drawable.pill));
        addProduct(new Product("Paracetamol","paracetamol 600mg capsulas","600mg","generico",12.0,6,R.drawable.pill2));
        addProduct(new Product("Ibuprofeno","Ibuprofeno sobres 1gr","1gr","generico",2.50,20,R.drawable.pill2));
    }

    public List<Product> getProducts(){

        Collections.sort(products, (p1, p2) -> p1.getmStock() - p2.getmStock());

        return  products;
        //se ha de añadir al apartado del gradle app
        //jackOptions {
          //  enabled true
        //}
    }

    public List<Product> getSortedAphabetical(boolean sortedAZ){

//ordenar de manera alfabetica
        if(sortedAZ)
            Collections.sort(products, (p1, p2) -> );
        else
            Collections.sort(products, (p2, p1) -> p1.getmStock() - p2.getmStock());

        return products;
    }

    public List<Product> getSortedProducts(boolean sorted){

        if(sorted)
            Collections.sort(products, (p1, p2) -> p1.getmStock() - p2.getmStock());
        else
            Collections.sort(products, (p2, p1) -> p1.getmStock() - p2.getmStock());

        return products;
    }


}
