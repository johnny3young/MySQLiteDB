package com.example.mysqlitedb;

import java.text.NumberFormat;

public class Item {
    long id;
    String name;
    int amount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    //Sirve para poner todos los elementos en una linea y poder leerlos
    public String toString(){
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        return name + "\n" + numberFormat.format(amount);
    }

}
