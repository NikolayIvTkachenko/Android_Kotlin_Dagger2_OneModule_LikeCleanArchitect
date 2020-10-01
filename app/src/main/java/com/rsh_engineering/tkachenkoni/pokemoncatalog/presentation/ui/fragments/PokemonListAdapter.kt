package com.rsh_engineering.tkachenkoni.pokemoncatalog.presentation.ui.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rsh_engineering.tkachenkoni.pokemoncatalog.R
import com.rsh_engineering.tkachenkoni.pokemoncatalog.domain.entity.Pokemon
import com.rsh_engineering.tkachenkoni.pokemoncatalog.presentation.ui.interfaces.OnClickListener
import kotlinx.android.synthetic.main.item_list.view.*

/**
 *
 * Created by Nikolay Tkachenko on 01, October, 2020
 *
 */
class PokemonListAdapter : RecyclerView.Adapter<PokemonListAdapter.PokemonViewHolder>() {
    val pokemonList = ArrayList<Pokemon>()
    lateinit var listener: OnClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.item_list,null)
        return PokemonViewHolder(view)
    }

    override fun getItemCount() = pokemonList.size

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.pokemonName.text = pokemonList.get(position).name
        holder.pokemonName.setOnClickListener {
            listener.onClick(position,it)
        }
    }


    class  PokemonViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val pokemonName = view.pokemonName
    }

    fun addPokmons(list: ArrayList<Pokemon>){
        pokemonList.clear()
        pokemonList.addAll(list)
        notifyDataSetChanged()
    }

    fun setClickListener(listener: OnClickListener){
        this.listener = listener
    }

}
