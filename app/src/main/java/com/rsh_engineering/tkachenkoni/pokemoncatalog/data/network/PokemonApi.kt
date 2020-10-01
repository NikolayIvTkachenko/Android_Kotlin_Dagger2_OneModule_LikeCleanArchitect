package com.rsh_engineering.tkachenkoni.pokemoncatalog.data.network

import com.rsh_engineering.tkachenkoni.pokemoncatalog.domain.entity.PokemonDetails
import com.rsh_engineering.tkachenkoni.pokemoncatalog.domain.entity.PokemonResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 *
 * Created by Nikolay Tkachenko on 01, October, 2020
 *
 */
interface PokemonApi {
    @GET("api/v2/pokemon")
    fun getPokemonList(@Query("offset") offset: Int, @Query("limit") limit: Int):
            Observable<PokemonResponse>

    @GET("api/v2/pokemon/{id}/")
    fun getPokemonDetails(@Path("id") id:Int) : Observable<PokemonDetails>

}