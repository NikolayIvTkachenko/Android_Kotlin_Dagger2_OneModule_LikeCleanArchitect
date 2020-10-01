package com.rsh_engineering.tkachenkoni.pokemoncatalog.presentation.ui.activity

import com.rsh_engineering.tkachenkoni.pokemoncatalog.R
import com.rsh_engineering.tkachenkoni.pokemoncatalog.presentation.ui.fragments.PokemonListFragment

/**
 *
 * Created by Nikolay Tkachenko on 01, October, 2020
 *
 */
class MainActivity : BaseActivity() {
    override fun getLayoutById() = R.layout.activity_main
    private val pokemonListFragment = PokemonListFragment()

    override fun initUI() {
        supportFragmentManager.beginTransaction().add(R.id.container, pokemonListFragment).commit()
    }
}