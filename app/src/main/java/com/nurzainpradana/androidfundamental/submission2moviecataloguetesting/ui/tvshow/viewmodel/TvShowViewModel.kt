package com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.ui.tvshow.viewmodel

import androidx.lifecycle.ViewModel
import com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.data.source.CatalogueRepository
import com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.data.source.local.entity.TvShow
import com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.util.DummyData.generateDummyTvShow

class TvShowViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {
    fun getListTvShow() : ArrayList<TvShow> = catalogueRepository.getListTvShow()
}