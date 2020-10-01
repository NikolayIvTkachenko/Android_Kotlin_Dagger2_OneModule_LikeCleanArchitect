package com.rsh_engineering.tkachenkoni.pokemoncatalog.di.module

import androidx.lifecycle.ViewModel
import com.rsh_engineering.tkachenkoni.pokemoncatalog.presentation.viewmodel.PokemonDetailsViewModel
import com.rsh_engineering.tkachenkoni.pokemoncatalog.presentation.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 *
 * Created by Nikolay Tkachenko on 01, October, 2020
 *
 */

@Module
abstract class PokemonDetailsViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(PokemonDetailsViewModel::class)
    internal abstract fun bindPokemonDetailsViewModel(viewModel: PokemonDetailsViewModel): ViewModel
}