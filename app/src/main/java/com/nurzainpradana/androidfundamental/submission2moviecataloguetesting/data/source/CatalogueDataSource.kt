package com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.data.source

import com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.data.source.local.entity.Movie
import com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.data.source.local.entity.TvShow

interface CatalogueDataSource {

    fun getListMovies(): List<Movie>

    fun getListTvShow(): List<TvShow>

    fun getDetailTvShow(tvShowId: Int): TvShow?

    fun getDetailMovie(movieId: Int): Movie?
}