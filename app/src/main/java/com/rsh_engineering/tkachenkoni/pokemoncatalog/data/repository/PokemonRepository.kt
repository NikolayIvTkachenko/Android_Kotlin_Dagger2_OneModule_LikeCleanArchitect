package com.rsh_engineering.tkachenkoni.pokemoncatalog.data.repository

import com.rsh_engineering.tkachenkoni.pokemoncatalog.data.network.PokemonApi
import com.rsh_engineering.tkachenkoni.pokemoncatalog.domain.entity.PokemonDetails
import com.rsh_engineering.tkachenkoni.pokemoncatalog.domain.entity.PokemonResponse
import com.rsh_engineering.tkachenkoni.pokemoncatalog.presentation.LIMIT
import io.reactivex.Observable

/**
 *
 * Created by Nikolay Tkachenko on 01, October, 2020
 *
 */
class PokemonRepository (val pokemonApi: PokemonApi){

    fun getPokemonList(offset:Int): Observable<PokemonResponse> {
        return  pokemonApi.getPokemonList(offset , LIMIT)
    }

    fun getPokemonDetails(id:Int): Observable<PokemonDetails> {
        return pokemonApi.getPokemonDetails(id)
    }

}