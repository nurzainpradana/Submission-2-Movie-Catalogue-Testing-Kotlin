package com.nurzainpradana.androidfundamental.submission1moviecataloguetesting.ui.detailtvshow

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.nurzainpradana.androidfundamental.submission1moviecataloguetesting.R
import com.nurzainpradana.androidfundamental.submission1moviecataloguetesting.data.TvShow
import com.nurzainpradana.androidfundamental.submission1moviecataloguetesting.databinding.ActivityDetailTvShowBinding
import jp.wasabeef.glide.transformations.BlurTransformation

class DetailTvShowActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailTvShowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailTvShowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tvShowId = intent.getIntExtra(EXTRA_TV_SHOW, 0)
        val detailTvShowViewModel = ViewModelProvider(this, NewInstanceFactory()).get(DetailTvShowViewModel::class.java)

        detailTvShowViewModel.setTvShowId(tvShowId)
        detailTvShowViewModel.getTvShow()?.let { setView(it) }
    }

    private fun setView(tvShow: TvShow) {
        with(binding) {
            tvDetailTvShowTitle.text = tvShow.tvShowTitle
            tvDetailTvShowDescription.text = tvShow.tvShowDescription
            tvDetailTvShowGenre.text = tvShow.tvShowGenre
            tvDetailTvShowYear.text = tvShow.tvShowYear

            Glide.with(applicationContext)
                    .load(tvShow.tvShowPoster)
                    .apply(RequestOptions().override(150, 150))
                    .into(imgDetailTvShowPoster)

            Glide.with(applicationContext)
                    .load(tvShow.tvShowPoster)
                    .apply(RequestOptions.bitmapTransform(BlurTransformation(25)))
                    .into(imgDetailTvShowPosterBlur)

            val actionBar = supportActionBar
            if (actionBar != null) {
                actionBar.title = getString(R.string.tvshow) + " : " + tvShow.tvShowTitle
            }
        }
    }

    companion object {
        const val EXTRA_TV_SHOW = "extra_tv_show"
    }
}