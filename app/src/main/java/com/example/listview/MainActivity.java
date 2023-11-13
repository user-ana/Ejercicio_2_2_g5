package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    //metodo a usar en evento onCLick del boton VerLista
    public void VerLista(View v)
    {
        Intent lista = new Intent(this, ActivityList.class);
        startActivity(lista);

    }
    //metodo a usar en evento onCLick del boton VerPost
    public void VerPost(View v)
    {
        Intent lista = new Intent(this, ActivityPost.class);
        startActivity(lista);

    }
}