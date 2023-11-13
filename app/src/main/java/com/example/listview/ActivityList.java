package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class ActivityList extends AppCompatActivity {

    private ListView lista;
    private RequestQueue requestQueue;
    private ArrayAdapter<String> postadapter;
    private String url = "https://jsonplaceholder.typicode.com/posts";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        lista = (ListView) findViewById(R.id.lista);

        //enlazamos postadapter al simple list item
        postadapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);

        //a la lista le enviamos el arreglo postadapter
        lista.setAdapter(postadapter);

        requestQueue = Volley.newRequestQueue(this);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                    //Cliclo for
                for(int i=0; i < response.length(); i++)
                {
                    try
                    {
                        JSONObject jsonObject = response.getJSONObject(i);
                        String mensaje = jsonObject.getString("title");
                        postadapter.add(mensaje);
                    }
                    catch (Exception ex)
                    {
                        ex.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


            }
    });

        requestQueue.add(jsonArrayRequest);

    }

    //metodo a usar en evento onCLick del boton regresar
    public void Regresar(View v)
    {
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);

    }




}