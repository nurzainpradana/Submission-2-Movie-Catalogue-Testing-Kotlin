package com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.data.source

import com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.data.source.local.LocalDataSource
import com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.data.source.local.entity.Movie
import com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.data.source.local.entity.TvShow

/*
    Untuk menghubungkan kelas RemoteDataSource
 */
class CatalogueRepository private constructor(private val localDataSource: LocalDataSource): CatalogueDataSource {
    companion object {
        @Volatile
        private var instance: CatalogueRepository? = null

        fun getInstance(localData: LocalDataSource): CatalogueRepository =
                instance ?: synchronized(this) {
                    instance ?: CatalogueRepository(localData).apply { instance = this }
                }
    }

    override fun getListMovies(): ArrayList<Movie> {
        val movies = localDataSource.getListMovies()
        val movieList = ArrayList<Movie>()
        for (mv in movies) {
            val movie = Movie(
                    movieId = mv.movieId,
                    movieTitle = mv.movieTitle,
                    movieDescription = mv.movieDescription,
                    movieGenre = mv.movieGenre,
                    moviePoster = mv.moviePoster,
                    movieYear = mv.movieYear
                )
            movieList.add(movie)
            }
        return movieList
    }

    override fun getListTvShow(): ArrayList<TvShow> {
        val tvShows = localDataSource.getListTvShows()
        val tvShowList = ArrayList<TvShow>()
        for (tv in tvShows) {
            val movie = TvShow(
                    tvShowId = tv.tvShowId,
                    tvShowDescription = tv.tvShowDescription,
                    tvShowGenre = tv.tvShowGenre,
                    tvShowPoster = tv.tvShowPoster,
                    tvShowTitle = tv.tvShowTitle,
                    tvShowYear = tv.tvShowYear
            )
            tvShowList.add(movie)
        }
        return tvShowList
    }
}