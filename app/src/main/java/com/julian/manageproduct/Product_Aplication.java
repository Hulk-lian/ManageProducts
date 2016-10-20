package com.julian.manageproduct;


import android.app.Application;

import com.julian.manageproduct.model.Product;

import java.util.ArrayList;
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
        addProduct(new Product("Diazepan","Diazepan del bueno","1gr","generico",10.2,50,R.drawable.img_med));
        addProduct(new Product("Prozac","Prozac capsula de 1gr","1gr","generico",10.2,0,R.drawable.img_med));
        addProduct(new Product("Diazepan","Diazepan del regulero","1gr","generico",15.2,500,R.drawable.img_med));
        addProduct(new Product("Dalsi","Dalsi de toda la vida","250ml","Dalsi SL",5.2,100,R.drawable.img_med));
        addProduct(new Product("Jarabe para la tos","jarabe para la tos ","125ml","generico",7.25,120,R.drawable.img_med));
        addProduct(new Product("Mercromina","Frasco de mercromina ","100ml","generico",8.59,69,R.drawable.img_med));
        addProduct(new Product("Betadine","Frasco de betadine 250ml","250ml","generico",4.2,20,R.drawable.img_med));
        addProduct(new Product("Paracetamol","paracetamol 1gr capsulas","1gr","generico",9.66,58,R.drawable.img_med));
        addProduct(new Product("Paracetamol","paracetamol 600mg capsulas","600mg","generico",12.0,6,R.drawable.img_med));
        addProduct(new Product("Ibuprofeno","Ibuprofeno sobres 1gr","1gr","generico",2.50,20,R.drawable.img_med));
    }

    public List<Product> getProducts(){
        return  products;
    }
}
