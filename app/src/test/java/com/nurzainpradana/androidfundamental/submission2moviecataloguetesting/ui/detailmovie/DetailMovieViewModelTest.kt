package com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.ui.detailmovie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.data.source.CatalogueRepository
import com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.data.source.local.LocalDataSource
import com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.data.source.local.entity.Movie
import com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.util.DummyData
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailMovieViewModelTest {

    private var detailMovieViewModel: DetailMovieViewModel? = null
    private var movie: Movie? = null


    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository: CatalogueRepository

    @Before
    fun setUp() {
        val movie = LocalDataSource.getInstance(DummyData)
        catalogueRepository = CatalogueRepository.getInstance(movie)
        detailMovieViewModel = DetailMovieViewModel(catalogueRepository)
    }

    @Test
    fun getDetailMovie() {

        val detailMovie = catalogueRepository.getDetailMovie(1)
        verify(catalogueRepository).getDetailMovie(1)

        Assert.assertNotNull(detailMovie)
        Assert.assertEquals(detailMovie!!.movieId.toLong(), movie!!.movieId.toLong())
        Assert.assertEquals(detailMovie.movieTitle, movie!!.movieTitle)
        Assert.assertEquals(detailMovie.moviePoster.toLong(), movie!!.moviePoster.toLong())
        Assert.assertEquals(detailMovie.movieGenre, movie!!.movieGenre)
        Assert.assertEquals(detailMovie.movieDescription, movie!!.movieDescription)
        Assert.assertEquals(detailMovie.movieYear, movie!!.movieYear)
    }
}