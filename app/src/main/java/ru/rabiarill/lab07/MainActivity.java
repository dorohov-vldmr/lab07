package ru.rabiarill.lab07;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText txt_key;
    EditText txt_value;
    DB mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_key = findViewById(R.id.txt_key);
        txt_value = findViewById(R.id.txt_value);

        mydb = new DB(this, "mybase.db", null,1);
    }

    public void insert(View view){
        String key = txt_key.getText().toString(); // get key and value strings
        if (key.isEmpty()){
            txt_value.setText("Нельзя сохранить пустое значение");
        }else {
            String value = txt_value.getText().toString();
            mydb.do_insert(key, value);
        }

    }

    public void updateDb(View view){
        String key = txt_key.getText().toString();
        String value = txt_value.getText().toString();

        mydb.do_update(key, value);
    }

    public void select(View view){
        String key = txt_key.getText().toString(); // get key string
        String value = mydb.do_select(key); // find value for that Rey in table

        txt_value.setText(value);
    }

    public void delete(View view){
        String key = txt_key.getText().toString(); // get key string
        mydb.do_delete(key);

        txt_value.setText("Значение удалено");
    }
}