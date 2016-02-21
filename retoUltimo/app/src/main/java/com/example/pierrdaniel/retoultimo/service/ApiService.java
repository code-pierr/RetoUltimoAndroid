package com.example.pierrdaniel.retoultimo.service;

import com.example.pierrdaniel.retoultimo.entity.PokemonEntity;

import java.util.ArrayList;

import retrofit.Callback;

import retrofit.http.GET;

/**
 * Created by PIERR DANIEL on 20/02/2016.
 */
public interface ApiService {
    @GET("/lista_pokemons.php")
    void getPokemon(Callback<ArrayList<PokemonEntity>> callback);

}
