package com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.ui.detailmovie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.R
import com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.data.source.local.entity.Movie
import com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.databinding.ActivityDetailMovieBinding
import jp.wasabeef.glide.transformations.BlurTransformation

class DetailMovieActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movieId = intent.getIntExtra(EXTRA_MOVIE, 0)
        val detailMovieViewModel = ViewModelProvider(this, NewInstanceFactory()).get(DetailMovieViewModel::class.java)
        detailMovieViewModel.setMovieId(movieId)
        detailMovieViewModel.getMovie()?.let { setView(it) }
    }

    private fun setView(movie: Movie) {
        with(binding) {
            tvDetailMovieTitle.text = movie.movieTitle
            tvDetailMovieDescription.text = movie.movieDescription
            tvDetailMovieGenre.text = movie.movieGenre
            tvDetailMovieYear.text = movie.movieYear

            Glide.with(applicationContext)
                    .load(movie.moviePoster)
                    .apply(RequestOptions().override(150, 150))
                    .into(imgDetailMoviePoster)

            Glide.with(applicationContext)
                    .load(movie.moviePoster)
                    .apply(RequestOptions.bitmapTransform(BlurTransformation(25)))
                    .into(imgDetailMoviePosterBlur)

            val actionBar = supportActionBar
            if (actionBar != null) actionBar.title = getString(R.string.movie) + " : " + movie.movieTitle
        }
    }

    companion object {
        @JvmField
        var EXTRA_MOVIE = "extra_movie"
    }
}