package com.rsh_engineering.tkachenkoni.pokemoncatalog.presentation.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 *
 * Created by Nikolay Tkachenko on 01, October, 2020
 *
 */
abstract  class BaseActivity : AppCompatActivity() {
    abstract  fun getLayoutById(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutById())
        initUI()
    }

    abstract fun initUI()
}