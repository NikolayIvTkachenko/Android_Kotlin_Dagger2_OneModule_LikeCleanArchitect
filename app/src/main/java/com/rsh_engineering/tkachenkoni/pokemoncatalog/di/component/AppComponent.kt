package com.rsh_engineering.tkachenkoni.pokemoncatalog.di.component

import com.rsh_engineering.tkachenkoni.pokemoncatalog.di.module.NetworkModule
import com.rsh_engineering.tkachenkoni.pokemoncatalog.di.module.PokemonUsecaseModule
import com.rsh_engineering.tkachenkoni.pokemoncatalog.di.module.RepositoryModule
import com.rsh_engineering.tkachenkoni.pokemoncatalog.di.scope.AppScope
import com.rsh_engineering.tkachenkoni.pokemoncatalog.di.subcomponent.PokemonDetailsComponent
import com.rsh_engineering.tkachenkoni.pokemoncatalog.di.subcomponent.PokemonListComponent
import dagger.Component

/**
 *
 * Created by Nikolay Tkachenko on 01, October, 2020
 *
 */
@AppScope
@Component(
    modules = [
        NetworkModule::class,
        PokemonUsecaseModule::class,
        RepositoryModule::class
    ]
)
interface AppComponent {
    fun newPokemonLisComponent(): PokemonListComponent
    fun newPokemonDetailsComponent(): PokemonDetailsComponent
}