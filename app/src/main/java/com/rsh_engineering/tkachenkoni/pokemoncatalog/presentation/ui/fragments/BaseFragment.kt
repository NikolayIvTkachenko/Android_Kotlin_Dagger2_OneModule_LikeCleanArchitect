package com.rsh_engineering.tkachenkoni.pokemoncatalog.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 *
 * Created by Nikolay Tkachenko on 01, October, 2020
 *
 */
abstract  class BaseFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutById(),container,false)
    }

    abstract  fun getLayoutById(): Int

}