package com.faezolfp.miniprojekxl.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.faezolfp.miniprojekxl.MainViewModel
import com.faezolfp.miniprojekxl.di.Injection
import com.faezolfp.miniprojekxl.domain.usecase.UseCase

class ViewModelFactory private constructor(private val useCase: UseCase) :
    ViewModelProvider.NewInstanceFactory() {
    companion object {
        const val TAG = "ViewModelFactory"

        @Volatile
        private var INCSTANCE: ViewModelFactory? = null

        fun getInstance(): ViewModelFactory = INCSTANCE ?: synchronized(this) {
            INCSTANCE ?: ViewModelFactory(Injection.provideUseCase())
        }
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(useCase) as T
        }

        throw IllegalArgumentException("Message ${modelClass.name}")

    }
}