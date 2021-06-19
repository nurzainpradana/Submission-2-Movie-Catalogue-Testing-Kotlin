package com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.ui.detailtvshow

import com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.R
import com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.data.source.CatalogueRepository
import com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.data.source.local.LocalDataSource
import com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.data.source.local.entity.TvShow
import com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.ui.detailmovie.DetailMovieViewModel
import com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.util.DummyData
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailTvShowViewModelTest {
    private var detailTvShowViewModel: DetailTvShowViewModel? = null
    private var tvShow: TvShow? = null

    @Mock
    private lateinit var catalogueRepository: CatalogueRepository


    @Before
    fun setUp() {
        val movie = LocalDataSource.getInstance(DummyData)
        catalogueRepository = CatalogueRepository.getInstance(movie)
        detailTvShowViewModel = DetailTvShowViewModel(catalogueRepository)

        tvShow = TvShow(1,
                R.drawable.poster_arrow,
                "Arrow",
                "Drama, Action & Adventure",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "2012")
    }

    @Test
    fun getTvShow() {
        val tvShow = catalogueRepository.getDetailTvShow(1)
        Mockito.verify(catalogueRepository).getDetailTvShow(1)

        Assert.assertNotNull(tvShow)
        Assert.assertEquals(tvShow!!.tvShowId.toLong(), tvShow.tvShowId.toLong())
        Assert.assertEquals(tvShow.tvShowTitle, tvShow.tvShowTitle)
        Assert.assertEquals(tvShow.tvShowPoster.toLong(), tvShow.tvShowPoster.toLong())
        Assert.assertEquals(tvShow.tvShowGenre, tvShow.tvShowGenre)
        Assert.assertEquals(tvShow.tvShowDescription, tvShow.tvShowDescription)
        Assert.assertEquals(tvShow.tvShowYear, tvShow.tvShowYear)
    }
}