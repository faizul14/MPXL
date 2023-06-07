package com.faezolfp.miniprojekxl.utils

import com.faezolfp.miniprojekxl.data.network.ResponseApiItem
import com.faezolfp.miniprojekxl.domain.domain.Datas

object DataMapper {
    fun DataResponseToModel(input: List<ResponseApiItem?>?): List<Datas> {
        val dataList = ArrayList<Datas>()
        input?.map {
            val data = Datas(
                nama = it?.name,
                genre = it?.embedded?.show?.genres,
                rating = it?.embedded?.show?.rating?.average.toString(),
                gambar = it?.embedded?.show?.image?.original
            )
            dataList.add(data)
        }
        return dataList
    }
}