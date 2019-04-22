package com.example.mysqlitedb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    EditText editText;
    Button buttonAll, buttonDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Referencias
         listView = findViewById(R.id.listview);
         editText = findViewById(R.id.edittext);
         buttonAll = findViewById(R.id.allelements);
         buttonDelete = findViewById(R.id.delete);

         //Acciones de los botones
         buttonAll.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

             }
         });

         buttonDelete.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

             }
         });
    }
}
