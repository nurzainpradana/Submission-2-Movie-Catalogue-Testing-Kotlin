package com.nurzainpradana.androidfundamental.submission1moviecataloguetesting.ui.tvshow

import androidx.lifecycle.ViewModel
import com.nurzainpradana.androidfundamental.submission1moviecataloguetesting.data.TvShow
import com.nurzainpradana.androidfundamental.submission1moviecataloguetesting.util.DummyData.generateDummyTvShow

class TvShowViewModel : ViewModel() {
    fun getListTvShow() : ArrayList<TvShow> = generateDummyTvShow()
}