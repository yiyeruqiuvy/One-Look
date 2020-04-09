package com.example.myapplication1;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class HomePage extends AppCompatActivity {
    private EditText nav_edit;
    private ImageView nav_search;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        nav_search = (ImageView)findViewById(R.id.nav_search);
        nav_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, MainActivity.class);

                nav_edit = (EditText)findViewById(R.id.nav_edit);
                String url = nav_edit.getText().toString();
                intent.putExtra("url",url);
                startActivityForResult(intent,1);
            }
        });





    }

}
