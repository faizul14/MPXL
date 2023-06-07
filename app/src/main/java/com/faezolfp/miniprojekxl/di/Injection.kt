package com.faezolfp.miniprojekxl.di

import com.faezolfp.miniprojekxl.data.Repository
import com.faezolfp.miniprojekxl.data.network.ApiConfig
import com.faezolfp.miniprojekxl.data.network.RemoteDataSource
import com.faezolfp.miniprojekxl.domain.repository.IRepository
import com.faezolfp.miniprojekxl.domain.usecase.UseCase
import com.faezolfp.miniprojekxl.domain.usecase.UseCaseIteractor

object Injection {
    private fun provideRepostitory(): IRepository {
        val remote = RemoteDataSource.getInstance(ApiConfig.provideApiService())
        return Repository.getInstance(remote)
    }

    fun provideUseCase(): UseCase {
        val repository = provideRepostitory()
        return UseCaseIteractor(repository)
    }
}