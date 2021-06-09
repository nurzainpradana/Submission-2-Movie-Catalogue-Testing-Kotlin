package com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.ui.detailmovie

import androidx.lifecycle.ViewModel
import com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.data.source.local.entity.Movie
import com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.util.DummyData

class DetailMovieViewModel : ViewModel() {

    private var movieId = 0

    fun getMovie(): Movie? {
        var movie: Movie? = null
        for (i in DummyData.generateDummyMovies().indices) {
            val movies = DummyData.generateDummyMovies()[i]
            if (movies.movieId == movieId) {
                movie = movies
            }
        }
        return movie
    }


    fun setMovieId(movieId: Int) {
        this.movieId = movieId
    }
}