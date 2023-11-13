package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class ActivityPost extends AppCompatActivity {

    private TextView post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        post = (TextView) findViewById(R.id.postTextView);

        //variable tipo string que contiene la direccion web
        String url = "https://jsonplaceholder.typicode.com/posts/1";

        // Inicializar la cola de solicitudes de Volley
        RequestQueue queue = Volley.newRequestQueue(this);

        // Crear la solicitud GET
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response)
                    {
                        try
                        {
                            // Obtener el título del post desde la respuesta JSON
                            String title = response.getString("title");

                            // Mostrar el título en el TextView
                           // postTextView.setText(title);
                            post.setText(title);
                        }
                        catch (JSONException e)
                        {
                            e.printStackTrace();
                        }
                    }
                },new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Manejar errores de la solicitud
                        error.printStackTrace();
                    }
                });

        // Agregar la solicitud a la cola
        queue.add(jsonObjectRequest);

    }
    //metodo a usar en evento onCLick del boton regresar
    public void Regresar(View v)
    {
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);

    }

}