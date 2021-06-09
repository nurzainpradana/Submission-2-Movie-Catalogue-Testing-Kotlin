package com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.ui.detailtvshow

import com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.R
import com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.data.source.local.entity.TvShow
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class DetailTvShowViewModelTest {
    private var detailTvShowViewModel: DetailTvShowViewModel? = null
    private var tvShow: TvShow? = null
    @Before
    fun setUp() {
        detailTvShowViewModel = DetailTvShowViewModel()
        tvShow = TvShow(1,
                R.drawable.poster_arrow,
                "Arrow",
                "Drama, Action & Adventure",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "2012")
    }

    @Test
    fun getTvShow() {
        detailTvShowViewModel!!.setTvShowId(1)
        tvShow = detailTvShowViewModel!!.getTvShow()
        Assert.assertNotNull(tvShow)
        Assert.assertEquals(tvShow!!.tvShowId.toLong(), tvShow!!.tvShowId.toLong())
        Assert.assertEquals(tvShow!!.tvShowTitle, tvShow!!.tvShowTitle)
        Assert.assertEquals(tvShow!!.tvShowPoster.toLong(), tvShow!!.tvShowPoster.toLong())
        Assert.assertEquals(tvShow!!.tvShowGenre, tvShow!!.tvShowGenre)
        Assert.assertEquals(tvShow!!.tvShowDescription, tvShow!!.tvShowDescription)
        Assert.assertEquals(tvShow!!.tvShowYear, tvShow!!.tvShowYear)
    }
}