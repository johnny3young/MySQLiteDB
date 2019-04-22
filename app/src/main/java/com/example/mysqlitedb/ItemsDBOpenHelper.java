package com.example.mysqlitedb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


//Se le agrega la herencia de SQLiteOpenHelper con el extends para que nos sirva de BD
public class ItemsDBOpenHelper extends SQLiteOpenHelper {
    //Agregamos la informacion de la BD para poder llenar campo de abajo
    //Los dejamos como publico o en un archivo separado para poder acceder a ellos desde otra Clase
    public static final String DB_NAME = "itemsdatabase.db";
    public static final int DB_VERSION = 1;
    public static final String TABLE_ITEMS = "items";
    public static final String COLUMN_ID = "itemsID";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_AMOUNT = "amount";
    
    private static final String TAG = "TAG";

    private static final String TABLE_CREATE =
        //en el momento no tenemos el nombre de la tabla ni de las columnas por lo que debemos definirlo arriba
        "CREATE TABLE " + TABLE_ITEMS + "(" + COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NAME + "TEXT, " + COLUMN_AMOUNT + "INTEGER" + ")";


    public ItemsDBOpenHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Acá se colocan las sentencias para crear la DB como CREATE TABLE....etc
        //pero no se ve muy estético por lo que se crean variables fijas arriba
        db.execSQL(TABLE_CREATE);
        // Para revisar si se está ejecutando creamos un TAG
        Log.e(TAG, "Table Created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_ITEMS);
        onCreate(db);
    }
}
