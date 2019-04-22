package com.example.mysqlitedb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    EditText editText;
    Button buttonAll, buttonDelete;
    DataSource dataSource;
    List<Item> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Referencias
         listView = findViewById(R.id.listview);
         editText = findViewById(R.id.edittext);
         buttonAll = findViewById(R.id.allelements);
         buttonDelete = findViewById(R.id.delete);

         dataSource = new DataSource(this);
         dataSource.open();
         items = dataSource.finAll();

         //Si es CERO es porque no hay nada, por eso creamos un método para crearle items
         if (items.size()== 0) {
            createData();
            items = dataSource.finAll();
         }

         display();

         //Acciones de los botones
         buttonAll.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                display();
             }
         });

         buttonDelete.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                long id = Long.valueOf(editText.getText().toString());
                if (dataSource.remove(id)){
                    setResult(-1);
                }
             }
         });
    }

    public void createData (){
        Item item = new Item();
        item.setName("x");
        item.setAmount(1);
        dataSource.create(item);

        item = new Item();
        item.setName("x");
        item.setAmount(1);
        dataSource.create(item);

        item = new Item();
        item.setName("x");
        item.setAmount(1);
        dataSource.create(item);

        item = new Item();
        item.setName("x");
        item.setAmount(1);
        dataSource.create(item);

        item = new Item();
        item.setName("x");
        item.setAmount(1);
        dataSource.create(item);

        item = new Item();
        item.setName("x");
        item.setAmount(1);
        dataSource.create(item);
    }

    //Método para que se muestren los datos
    public void display (){
        ArrayAdapter<Item> adapter = new ArrayAdapter<Item>(this,android.R.layout.simple_list_item_1,items);
        listView.setAdapter(adapter);
    }

    @Override
    protected void onResume(){
        super.onResume();
        dataSource.open();
    }

    protected void onPause(){
        super.onPause();
        dataSource.close();
    }
}
