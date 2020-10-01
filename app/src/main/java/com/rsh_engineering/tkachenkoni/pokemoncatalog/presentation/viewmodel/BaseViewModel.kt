package com.rsh_engineering.tkachenkoni.pokemoncatalog.presentation.viewmodel

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

/**
 *
 * Created by Nikolay Tkachenko on 01, October, 2020
 *
 */
open class BaseViewModel  : ViewModel() {
    val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}