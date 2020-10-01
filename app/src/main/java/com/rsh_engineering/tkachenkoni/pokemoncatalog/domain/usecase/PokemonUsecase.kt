package com.rsh_engineering.tkachenkoni.pokemoncatalog.domain.usecase

import com.rsh_engineering.tkachenkoni.pokemoncatalog.data.repository.PokemonRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
/**
 *
 * Created by Nikolay Tkachenko on 01, October, 2020
 *
 */
class PokemonUsecase(private val repository: PokemonRepository) {

    fun getPokemonList(offset: Int) = repository.getPokemonList(offset)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

    fun getPokemonDetails(id: Int) = repository.getPokemonDetails(id)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

}