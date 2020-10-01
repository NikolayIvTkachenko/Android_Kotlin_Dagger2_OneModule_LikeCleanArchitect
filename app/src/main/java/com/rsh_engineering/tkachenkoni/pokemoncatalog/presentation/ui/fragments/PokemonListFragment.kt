package com.rsh_engineering.tkachenkoni.pokemoncatalog.presentation.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.rsh_engineering.tkachenkoni.pokemoncatalog.R
import com.rsh_engineering.tkachenkoni.pokemoncatalog.domain.entity.PokemonResponse
import com.rsh_engineering.tkachenkoni.pokemoncatalog.presentation.BaseApp
import com.rsh_engineering.tkachenkoni.pokemoncatalog.presentation.POKEMON_DETAILS_KEY
import com.rsh_engineering.tkachenkoni.pokemoncatalog.presentation.baseApp
import com.rsh_engineering.tkachenkoni.pokemoncatalog.presentation.ui.interfaces.OnClickListener
import com.rsh_engineering.tkachenkoni.pokemoncatalog.presentation.ui.activity.BaseActivity
import com.rsh_engineering.tkachenkoni.pokemoncatalog.presentation.viewmodel.PokeMonListViewModel
import com.rsh_engineering.tkachenkoni.pokemoncatalog.presentation.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_pokemon_list.*
import javax.inject.Inject

/**
 *
 * Created by Nikolay Tkachenko on 01, October, 2020
 *
 */

class PokemonListFragment : BaseFragment(), OnClickListener {
    private val pokemonDetailsFragment = PokemonDetailsFragment()

    private lateinit var pokeMonListViewModel: PokeMonListViewModel
    val pokadapter = PokemonListAdapter()

    @Inject
    lateinit var viewModelFactory: ViewModelFactory


    override fun onAttach(context: Context) {
        super.onAttach(context)
        context.baseApp.appComponent
        //BaseApp.instance.appComponent
            .newPokemonLisComponent().inject(this)
        pokeMonListViewModel = ViewModelProviders.of(this, viewModelFactory)[PokeMonListViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    fun setupView() {
        val linearLayoutManager = LinearLayoutManager(context)
        pokadapter.setClickListener(this)
        pokemonList.apply {
            layoutManager = linearLayoutManager
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            adapter = pokadapter
        }
    }

    fun getPokemonListData() {
        pokeMonListViewModel.getPokemonList()
        observePokemonList()
    }

    fun setData(response: PokemonResponse?) {
        response?.results?.let { pokadapter.addPokmons(it) }
    }

    override fun onClick(position: Int, view: View) {
        getPokemonDetails(position+1)
    }

    fun observePokemonList() {
        pokeMonListViewModel.getLivePokemonList().observe(viewLifecycleOwner, Observer {
            setData(it)
        })
    }


    override fun getLayoutById(): Int {
        return R.layout.fragment_pokemon_list
    }

    fun initUI() {
        setupView()
        getPokemonListData()
    }


    fun getPokemonDetails(id: Int) {
        val bundle = Bundle()
        bundle.putInt(POKEMON_DETAILS_KEY,id)
        pokemonDetailsFragment.arguments = bundle

        (activity as BaseActivity).supportFragmentManager.beginTransaction()
            .replace(R.id.container, pokemonDetailsFragment)
            .addToBackStack(null)
            .commit()
    }
}
