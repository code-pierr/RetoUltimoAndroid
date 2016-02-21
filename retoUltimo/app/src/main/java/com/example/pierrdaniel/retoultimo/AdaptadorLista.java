package com.example.pierrdaniel.retoultimo;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.pierrdaniel.retoultimo.entity.PokemonEntity;

import java.util.ArrayList;

/**
 * Created by PIERR DANIEL on 20/02/2016.
 */
public class AdaptadorLista extends ArrayAdapter {


    Activity context;
    ArrayList<PokemonEntity> datos;

    public AdaptadorLista(Activity context, ArrayList<PokemonEntity> datos) {
        super(context,R.layout.entrada, datos);
        this.context=context;
        this.datos = datos;
        // TODO Auto-generated constructor stub
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater=context.getLayoutInflater();
        View item=inflater.inflate(R.layout.entrada, null);

        TextView id = (TextView) item.findViewById(R.id.id);
        id.setText(String.valueOf(datos.get(position).getId()));

        TextView nombre = (TextView) item.findViewById(R.id.nombre);
        nombre.setText(String.valueOf(datos.get(position).getNombre()));

        TextView tipo = (TextView) item.findViewById(R.id.tipo);
        tipo.setText(String.valueOf(datos.get(position).getTipo()));

        TextView img = (TextView) item.findViewById(R.id.img);
        img.setText(String.valueOf(datos.get(position).getImagen()));

        return item;
    }
}