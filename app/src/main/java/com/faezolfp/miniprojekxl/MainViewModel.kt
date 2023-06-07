package com.faezolfp.miniprojekxl

import androidx.lifecycle.ViewModel
import com.faezolfp.miniprojekxl.domain.usecase.UseCase

class MainViewModel(private val useCase: UseCase) : ViewModel(){
    fun getListDataGempaTerkini() = useCase.getSchedule()
}