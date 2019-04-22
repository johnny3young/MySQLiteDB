package com.example.mysqlitedb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    //Acá utilizaremos la BD y el OPEN HELPER para hacer las peticiones, consultas, etc.
    SQLiteOpenHelper dbhelper;
    SQLiteDatabase database;

    //Defenimos el nombre de las columnas porque en la lista nos lo va a pedir
    private static final String [] colums = {
            ItemsDBOpenHelper.COLUMN_ID,
            ItemsDBOpenHelper.COLUMN_NAME,
            ItemsDBOpenHelper.COLUMN_AMOUNT
    };

    //Creamos el constructor
    public DataSource (Context context){
        dbhelper = new ItemsDBOpenHelper(context);
    }

    //Los 2 métodos para CUALQUIER DB que son open y close
    public void open (){
        database = dbhelper.getWritableDatabase();
    }

    public void close (){
        database.close();
    }

    //Para crear el elemento e insertarlo en la DB
    public Item create (Item item){
        //Hay mas de 3 formas para crear un item en SQLite, usaremos ContentValues
        ContentValues contentValues = new ContentValues();
        contentValues.put(ItemsDBOpenHelper.COLUMN_NAME,item.getName());
        contentValues.put(ItemsDBOpenHelper.COLUMN_AMOUNT,item.getAmount());
        long id = database.insert(ItemsDBOpenHelper.TABLE_ITEMS,null, contentValues);
        item.setId(id);
        return item;
    }
    //Para traer o listar los elementos de la BD
    public List<Item> finAll(){
        Cursor cursor = database.query(ItemsDBOpenHelper.TABLE_ITEMS,colums,null,null,null,null,null);
        List<Item> items = cursorToList(cursor);
        return items;
    }

    public boolean remove (long id){
        String where = ItemsDBOpenHelper.COLUMN_ID + "=" + id;
        int result = database.delete(ItemsDBOpenHelper.TABLE_ITEMS,where,null);
        return (result==1);
    }

    //Gerenamos un método para listar los item con la clase Cursor. Tmb agregamos un If con un While para que recorra la lista
    public List<Item> cursorToList(Cursor cursor){
        List<Item> items = new ArrayList<Item>();
        if (cursor.getCount()>0){
            while (cursor.moveToNext()) {
                Item item = new Item();
                item.setId(cursor.getLong(cursor.getColumnIndex(ItemsDBOpenHelper.COLUMN_ID)));
                item.setName(cursor.getString(cursor.getColumnIndex(ItemsDBOpenHelper.COLUMN_NAME)));
                item.setAmount(cursor.getInt(cursor.getColumnIndex(ItemsDBOpenHelper.COLUMN_AMOUNT)));
                items.add(item);
            }
        }
        return items;
    }
}


