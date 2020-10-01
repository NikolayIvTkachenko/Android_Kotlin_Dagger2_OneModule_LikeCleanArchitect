package com.rsh_engineering.tkachenkoni.pokemoncatalog.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import com.rsh_engineering.tkachenkoni.pokemoncatalog.domain.entity.PokemonResponse
import com.rsh_engineering.tkachenkoni.pokemoncatalog.domain.usecase.PokemonUsecase
import javax.inject.Inject

/**
 *
 * Created by Nikolay Tkachenko on 01, October, 2020
 *
 */
class PokeMonListViewModel @Inject constructor(private val usecase: PokemonUsecase) : BaseViewModel() {

    private val pokemonListMutableLiveData = MutableLiveData<PokemonResponse>()

    fun getPokemonList() {
        if (pokemonListMutableLiveData.value != null) {
            return
        }
        val disposable = usecase.getPokemonList(0)
            .subscribe {
                pokemonListMutableLiveData.value = it
            }
        compositeDisposable.add(disposable)
    }

    fun getLivePokemonList() = pokemonListMutableLiveData

}