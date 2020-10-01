package com.rsh_engineering.tkachenkoni.pokemoncatalog.di.module

import androidx.lifecycle.ViewModelProvider
import com.rsh_engineering.tkachenkoni.pokemoncatalog.presentation.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module

/**
 *
 * Created by Nikolay Tkachenko on 01, October, 2020
 *
 */

@Module
abstract class ViewModelFactoryModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}