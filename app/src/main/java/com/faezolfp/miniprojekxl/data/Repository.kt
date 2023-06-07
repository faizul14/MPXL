package com.faezolfp.miniprojekxl.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.faezolfp.miniprojekxl.data.network.RemoteDataSource
import com.faezolfp.miniprojekxl.data.network.ResponseApiItem
import com.faezolfp.miniprojekxl.domain.domain.Datas
import com.faezolfp.miniprojekxl.domain.repository.IRepository
import com.faezolfp.miniprojekxl.utils.DataMapper

class Repository(private val remoteDataSource: RemoteDataSource): IRepository {
    override fun getSchedule(): LiveData<List<Datas>>{
        return Transformations.map(remoteDataSource.getData()){
            DataMapper.DataResponseToModel(it)
        }
    }
    companion object{
        @Volatile
        private var INSTANCE: Repository? = null

        fun getInstance(remote: RemoteDataSource): Repository =
            INSTANCE ?: synchronized(this){
                INSTANCE ?: Repository(remote)
            }
    }
}