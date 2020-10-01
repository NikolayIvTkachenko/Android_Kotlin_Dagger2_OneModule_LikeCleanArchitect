package com.rsh_engineering.tkachenkoni.pokemoncatalog.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import com.rsh_engineering.tkachenkoni.pokemoncatalog.domain.entity.PokemonDetails
import com.rsh_engineering.tkachenkoni.pokemoncatalog.domain.usecase.PokemonUsecase
import javax.inject.Inject

/**
 *
 * Created by Nikolay Tkachenko on 01, October, 2020
 *
 */
class PokemonDetailsViewModel @Inject constructor(private val usecase: PokemonUsecase)  : BaseViewModel() {

    private val pokemonDetailsMutableLiveData  = MutableLiveData<PokemonDetails>()

    fun getPokemonDetails(id:Int) {
        val disposable = usecase.getPokemonDetails(id)
            .subscribe {
                pokemonDetailsMutableLiveData.value = it
            }
        compositeDisposable.add(disposable)
    }

    fun getLivePokemonDetails() = pokemonDetailsMutableLiveData
}