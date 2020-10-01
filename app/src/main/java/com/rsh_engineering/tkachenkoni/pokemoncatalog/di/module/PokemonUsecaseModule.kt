package com.rsh_engineering.tkachenkoni.pokemoncatalog.di.module

import com.rsh_engineering.tkachenkoni.pokemoncatalog.data.repository.PokemonRepository
import com.rsh_engineering.tkachenkoni.pokemoncatalog.di.scope.AppScope
import com.rsh_engineering.tkachenkoni.pokemoncatalog.domain.usecase.PokemonUsecase
import dagger.Module
import dagger.Provides

/**
 *
 * Created by Nikolay Tkachenko on 01, October, 2020
 *
 */

@Module
class PokemonUsecaseModule {
    @AppScope
    @Provides
    fun provideFeedUseCase(repository : PokemonRepository) = PokemonUsecase(repository)
}