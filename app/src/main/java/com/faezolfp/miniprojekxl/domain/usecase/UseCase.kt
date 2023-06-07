package com.faezolfp.miniprojekxl.domain.usecase

import androidx.lifecycle.LiveData
import com.faezolfp.miniprojekxl.domain.domain.Datas

interface UseCase {
    fun getSchedule() : LiveData<List<Datas>>
}