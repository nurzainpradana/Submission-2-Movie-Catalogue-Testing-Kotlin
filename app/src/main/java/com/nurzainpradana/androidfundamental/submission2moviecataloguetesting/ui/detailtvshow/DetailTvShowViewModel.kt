package com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.ui.detailtvshow

import androidx.lifecycle.ViewModel
import com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.data.source.CatalogueRepository
import com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.data.source.local.entity.TvShow
import com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.util.DummyData

class DetailTvShowViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {
    fun getTvShow(tvShowId: Int) : TvShow? = catalogueRepository.getDetailTvShow(tvShowId)
}