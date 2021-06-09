package com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.ui.tvshow

import com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.ui.tvshow.viewmodel.TvShowViewModel
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class TvShowViewModelTest {
    private var tvShowViewModel: TvShowViewModel? = null
    @Before
    fun init() {
        tvShowViewModel = TvShowViewModel()
    }

    //Cek isi list tvshow ada 10 atau tidak
    @get:Test
    val listTvShow: Unit
        get() {
            Assert.assertNotNull(tvShowViewModel!!.getListTvShow())

            //Cek isi list tvshow ada 10 atau tidak
            Assert.assertEquals(10, tvShowViewModel!!.getListTvShow().size.toLong())
        }
}