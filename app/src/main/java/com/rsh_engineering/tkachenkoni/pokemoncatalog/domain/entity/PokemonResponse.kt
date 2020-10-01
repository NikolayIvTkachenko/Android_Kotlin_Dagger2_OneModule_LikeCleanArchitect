package com.rsh_engineering.tkachenkoni.pokemoncatalog.domain.entity

/**
 *
 * Created by Nikolay Tkachenko on 01, October, 2020
 *
 */
data class PokemonResponse (
    val count:Int ,
    val next:String ,
    val previous:String?,
    val  results:ArrayList<Pokemon> )