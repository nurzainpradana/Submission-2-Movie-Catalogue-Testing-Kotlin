package com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.data.source.CatalogueRepository
import com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.data.source.local.entity.TvShow
import com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.di.Injection
import com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.ui.detailmovie.DetailMovieViewModel
import com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.ui.detailtvshow.DetailTvShowViewModel
import com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.ui.movie.viewmodel.MovieViewModel
import com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.ui.tvshow.viewmodel.TvShowViewModel

class ViewModelFactory private constructor(private val mCatalogueRepository: CatalogueRepository): ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
                instance ?: synchronized(this) {
                    instance ?: ViewModelFactory(Injection.provideRepository(context)).apply {
                        instance = this
                    }
                }
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                return MovieViewModel(mCatalogueRepository) as T
            }

            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> {
                return TvShowViewModel(mCatalogueRepository) as T
            }

            modelClass.isAssignableFrom(DetailTvShowViewModel::class.java) -> {
                return DetailTvShowViewModel(mCatalogueRepository) as T
            }

            modelClass.isAssignableFrom(DetailMovieViewModel::class.java) -> {
                return DetailMovieViewModel(mCatalogueRepository) as T
            }

            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}