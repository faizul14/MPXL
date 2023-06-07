package com.faezolfp.miniprojekxl.domain.repository

import androidx.lifecycle.LiveData
import com.faezolfp.miniprojekxl.domain.domain.Datas

interface IRepository {
    fun getSchedule() : LiveData<List<Datas>>
}