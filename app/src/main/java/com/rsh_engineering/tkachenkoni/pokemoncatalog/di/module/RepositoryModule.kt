package com.rsh_engineering.tkachenkoni.pokemoncatalog.di.module

import com.rsh_engineering.tkachenkoni.pokemoncatalog.data.network.PokemonApi
import com.rsh_engineering.tkachenkoni.pokemoncatalog.data.repository.PokemonRepository
import com.rsh_engineering.tkachenkoni.pokemoncatalog.di.scope.AppScope
import dagger.Module
import dagger.Provides

/**
 *
 * Created by Nikolay Tkachenko on 01, October, 2020
 *
 */
@Module
class RepositoryModule {
    @AppScope
    @Provides
    fun provideFeedRepository(api: PokemonApi) = PokemonRepository(api)
}