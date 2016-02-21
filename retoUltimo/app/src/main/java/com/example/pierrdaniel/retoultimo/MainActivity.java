package com.example.pierrdaniel.retoultimo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pierrdaniel.retoultimo.entity.PokemonEntity;
import com.example.pierrdaniel.retoultimo.service.ApiImplementacion;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText nombre = (EditText)findViewById(R.id.nombre);
        final EditText tipo = (EditText)findViewById(R.id.tipo);
        final Button entrar = (Button)findViewById(R.id.btnEntrar);

        ApiImplementacion.getService().getPokemon(new Callback<ArrayList<PokemonEntity>>() {
            @Override
            public void success(final ArrayList<PokemonEntity> lista, Response response) {
                entrar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        for (PokemonEntity p : lista){
                            if(p.getNombre().equals(nombre.getText().toString()) && p.getTipo().equals(tipo.getText().toString())){
                                Intent i = new Intent(MainActivity.this, Segundo.class);
                                startActivity(i);
                            }
//                            else if(!p.getNombre().equals(nombre.getText().toString()) && !p.getTipo().equals(tipo.getText().toString())){
//                                Toast.makeText(MainActivity.this, "Ingrese el nombre o el tipo correcto",Toast.LENGTH_SHORT).show();
//                            }
                        }
                    }
                });

            }

            @Override
            public void failure(RetrofitError retrofitError) {
                    Log.i("Respuesta", "algfo salio makl");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
