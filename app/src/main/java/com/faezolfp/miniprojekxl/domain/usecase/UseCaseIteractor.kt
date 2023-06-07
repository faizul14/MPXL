package com.faezolfp.miniprojekxl.domain.usecase

import androidx.lifecycle.LiveData
import com.faezolfp.miniprojekxl.data.Repository
import com.faezolfp.miniprojekxl.domain.domain.Datas
import com.faezolfp.miniprojekxl.domain.repository.IRepository

class UseCaseIteractor(private val repository: IRepository): UseCase {
    override fun getSchedule(): LiveData<List<Datas>>{
        return repository.getSchedule()
    }
}