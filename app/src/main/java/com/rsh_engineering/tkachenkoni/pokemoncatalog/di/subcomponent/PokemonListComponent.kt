package com.rsh_engineering.tkachenkoni.pokemoncatalog.di.subcomponent

import com.rsh_engineering.tkachenkoni.pokemoncatalog.di.module.PokemonListViewModelModule
import com.rsh_engineering.tkachenkoni.pokemoncatalog.di.module.ViewModelFactoryModule
import com.rsh_engineering.tkachenkoni.pokemoncatalog.di.scope.FragmentScope
import com.rsh_engineering.tkachenkoni.pokemoncatalog.presentation.ui.fragments.PokemonListFragment
import dagger.Subcomponent

/**
 *
 * Created by Nikolay Tkachenko on 01, October, 2020
 *
 */

@FragmentScope
@Subcomponent(
    modules = [
        ViewModelFactoryModule::class,
        PokemonListViewModelModule::class
    ]
)
interface PokemonListComponent {
    fun inject(pokemonListFragment: PokemonListFragment)
}