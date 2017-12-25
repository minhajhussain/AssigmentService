package com.example.minhaj.assigmentservice;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MyService myServiceobject = new MyService() ;
    EditText editText;
    int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText);
    }



    public void saveData(View view) {

            number = Integer.parseInt(editText.getText().toString());
            myServiceobject.setLimit(number);
            Toast.makeText(this,"Saved",Toast.LENGTH_SHORT).show();

    }




    public void startService(View view){
        Intent intent = new Intent(this,MyService.class);
        editText.getText().toString();
        intent.putExtra("Limit", 0);
        startService(intent);

    }

    public void stopService(View view){
        Intent intent = new Intent(this,MyService.class);
        stopService(intent);

    }
}
