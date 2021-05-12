package com.nurzainpradana.androidfundamental.submission1moviecataloguetesting.ui.detailmovie

import com.nurzainpradana.androidfundamental.submission1moviecataloguetesting.R
import com.nurzainpradana.androidfundamental.submission1moviecataloguetesting.data.Movie
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class DetailMovieViewModelTest {
    private var detailMovieViewModel: DetailMovieViewModel? = null
    private var movie: Movie? = null
    @Before
    fun setUp() {
        detailMovieViewModel = DetailMovieViewModel()
        movie = Movie(1, R.drawable.poster_aquaman, "Aquaman", "Action, Adventure, Fantasy",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a very large army, Orm plans to conquer the remaining ocean people and then to the surface. Stand in his way is Arthur Curry, the half-human half-brother of Orm and the true heir to the throne.",
                "2018")
    }

    @Test
    fun getMovie() {
        detailMovieViewModel!!.setMovieId(1)
        val movies = detailMovieViewModel!!.getMovie()
        Assert.assertNotNull(movies)
        Assert.assertEquals(movies!!.movieId.toLong(), movie!!.movieId.toLong())
        Assert.assertEquals(movies.movieTitle, movie!!.movieTitle)
        Assert.assertEquals(movies.moviePoster.toLong(), movie!!.moviePoster.toLong())
        Assert.assertEquals(movies.movieGenre, movie!!.movieGenre)
        Assert.assertEquals(movies.movieDescription, movie!!.movieDescription)
        Assert.assertEquals(movies.movieYear, movie!!.movieYear)
    }
}