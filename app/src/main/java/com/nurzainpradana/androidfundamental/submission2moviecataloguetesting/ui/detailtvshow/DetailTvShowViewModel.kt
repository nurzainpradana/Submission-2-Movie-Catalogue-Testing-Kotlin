package com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.ui.detailtvshow

import androidx.lifecycle.ViewModel
import com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.data.source.local.entity.TvShow
import com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.util.DummyData

class DetailTvShowViewModel : ViewModel() {
    private var tvShowId = 0

    fun getTvShow(): TvShow? {
        var tvShow: TvShow? = null

        for (i in DummyData.generateDummyTvShow().indices) {
            val tvShows = DummyData.generateDummyTvShow()[i]
            if (tvShows.tvShowId == tvShowId) {
                tvShow = tvShows
            }
        }
        return tvShow
    }

    fun setTvShowId(tvShowId: Int) {
        this.tvShowId = tvShowId
    }
}