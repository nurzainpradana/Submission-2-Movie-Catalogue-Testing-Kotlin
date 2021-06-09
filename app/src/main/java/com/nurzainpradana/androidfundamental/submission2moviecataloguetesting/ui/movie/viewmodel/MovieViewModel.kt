package com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.ui.movie.viewmodel

import androidx.lifecycle.ViewModel
import com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.data.source.CatalogueRepository
import com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.data.source.local.entity.Movie
import com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.util.DummyData

class MovieViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {

    fun getListMovie() : ArrayList<Movie> = catalogueRepository.getListMovies()
}