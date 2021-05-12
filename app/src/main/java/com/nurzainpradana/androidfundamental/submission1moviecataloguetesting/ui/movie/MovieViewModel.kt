package com.nurzainpradana.androidfundamental.submission1moviecataloguetesting.ui.movie

import androidx.lifecycle.ViewModel
import com.nurzainpradana.androidfundamental.submission1moviecataloguetesting.data.Movie
import com.nurzainpradana.androidfundamental.submission1moviecataloguetesting.util.DummyData

class MovieViewModel : ViewModel() {
    fun getListMovie() : ArrayList<Movie> = DummyData.generateDummyMovies()
}