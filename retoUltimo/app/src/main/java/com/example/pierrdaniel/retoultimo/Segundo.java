package com.example.pierrdaniel.retoultimo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pierrdaniel.retoultimo.entity.PokemonEntity;
import com.example.pierrdaniel.retoultimo.service.ApiImplementacion;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by PIERR DANIEL on 20/02/2016.
 */
public class Segundo extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segundo);

        ApiImplementacion.getService().getPokemon(new Callback<ArrayList<PokemonEntity>>() {
            @Override
            public void success(ArrayList<PokemonEntity> lista, Response response) {
                AdaptadorLista miAdaptador = new AdaptadorLista(Segundo.this, lista);
                final ListView lstOpciones = (ListView) findViewById(R.id.lista);
                lstOpciones.setAdapter(miAdaptador);
                lstOpciones.setItemsCanFocus(false);
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                Toast.makeText(Segundo.this, "No hay datos",Toast.LENGTH_LONG).show();
            }
        });
    }
}
