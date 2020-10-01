package com.rsh_engineering.tkachenkoni.pokemoncatalog.presentation

import android.app.Application
import android.content.Context
import com.rsh_engineering.tkachenkoni.pokemoncatalog.di.component.AppComponent
import com.rsh_engineering.tkachenkoni.pokemoncatalog.di.component.DaggerAppComponent
import com.rsh_engineering.tkachenkoni.pokemoncatalog.di.module.NetworkModule
import com.rsh_engineering.tkachenkoni.pokemoncatalog.di.module.PokemonUsecaseModule
import com.rsh_engineering.tkachenkoni.pokemoncatalog.di.module.RepositoryModule


/**
 *
 * Created by Nikolay Tkachenko on 01, October, 2020
 *
 */
class BaseApp : Application() {

    //Exist two case to create refer to App class
    //1 - Use instance
    //2 - use applicationContext

    lateinit var appComponent : AppComponent

    companion object{
        lateinit var instance: BaseApp
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        appComponent = this.initDagger()
    }

    private fun initDagger() = DaggerAppComponent.builder()
        .networkModule(NetworkModule())
        .repositoryModule(RepositoryModule())
        .pokemonUsecaseModule(PokemonUsecaseModule())
        .build()
}

val Context.baseApp: BaseApp
    get() = applicationContext as BaseApp