package com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.ui.movie

import com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.ui.movie.viewmodel.MovieViewModel
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class MovieViewModelTest {
    private var movieViewModel: MovieViewModel? = null
    @Before
    fun init() {
        movieViewModel = MovieViewModel()
    }

    //Mengecek isi dari list movie ada 10 atau tidak
    @get:Test
    val listMovie: Unit
        get() {
            Assert.assertNotNull(movieViewModel!!.getListMovie())

            //Mengecek isi dari list movie ada 10 atau tidak
            Assert.assertEquals(10, movieViewModel!!.getListMovie().size.toLong())
        }
}