package com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.data.source.local

import com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.data.source.local.entity.Movie
import com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.data.source.local.entity.TvShow
import com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.util.DummyData

class LocalDataSource private constructor(private val dummyData: DummyData) {

    companion object {
        @Volatile
        private var instance: LocalDataSource? = null

        fun getInstance(dummyData: DummyData): LocalDataSource =
                instance ?: synchronized(this) {
                    instance ?: LocalDataSource(dummyData).apply { instance = this }
                }
    }

    fun getListMovies(): List<Movie> = dummyData.generateDummyMovies()

    fun getListTvShows(): List<TvShow> = dummyData.generateDummyTvShow()
}