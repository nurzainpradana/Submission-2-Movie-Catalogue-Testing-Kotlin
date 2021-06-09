package com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.di

import android.content.Context
import com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.data.source.CatalogueRepository
import com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.data.source.local.LocalDataSource
import com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.util.DummyData

object Injection {
    fun provideRepository(context: Context): CatalogueRepository {

        val localDataSource = LocalDataSource.getInstance(DummyData)

        return CatalogueRepository.getInstance(localDataSource)
    }
}