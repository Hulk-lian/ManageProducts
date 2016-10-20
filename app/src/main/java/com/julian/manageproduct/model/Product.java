package com.julian.manageproduct.model;

public class Product {
    private int mId;
    private String mName;
    private String mDescription;
    private String mDosage;
    private String mBrand;
    private double mPrice;
    private int mStock;
    private int mImage;

    public Product(String mName, String mDescription,String mDosage, String mBrand, double mPrice, int mStock, int mImage) {
        this.mName = mName;
        this.mDescription = mDescription;
        this.mDosage=mDosage;
        this.mBrand = mBrand;
        this.mPrice = mPrice;
        this.mStock = mStock;
        this.mImage = mImage;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getmDosage() {
        return mDosage;
    }

    public void setmDosage(String mDescription) {
        this.mDosage = mDosage;
    }

    public String getmBrand() {
        return mBrand;
    }

    public void setmBrand(String mBrand) {
        this.mBrand = mBrand;
    }

    public double getmPrice() {
        return mPrice;
    }

    public void setmPrice(double mPrice) {
        this.mPrice = mPrice;
    }

    public int getmStock() {
        return mStock;
    }

    public void setmStock(int mStock) {
        this.mStock = mStock;
    }

    public int getmImage() {
        return mImage;
    }

    public void setmImage(int mImage) {
        this.mImage = mImage;
    }

    @Override
    public String toString() {
        return this.mName;
    }

/*
* dos productos son iguales cuando tienen el mismo nombre, marca y concentracion
* */

    @Override
    public boolean equals(Object o) {
        boolean resultado=false;
        Product product = (Product) o;

        if (this == o)
            resultado= true;

        if (o == null || getClass() != o.getClass())
            resultado = false;

        if (!mName.equals(product.mName) || !mDosage.equals(product.mDosage))
            resultado= false;

        resultado=mBrand.equals(product.mBrand);

        return resultado;

    }

    @Override
    public int hashCode() {
        int result = mName.hashCode();
        result = 31 * result + mDosage.hashCode();
        result = 31 * result + mBrand.hashCode();
        return result;
    }
}
