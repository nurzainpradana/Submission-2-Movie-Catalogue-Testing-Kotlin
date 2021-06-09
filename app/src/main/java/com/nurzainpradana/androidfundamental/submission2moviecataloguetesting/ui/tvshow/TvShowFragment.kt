package com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.ui.tvshow

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory
import androidx.recyclerview.widget.LinearLayoutManager
import com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.data.source.local.entity.TvShow
import com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.databinding.FragmentTvShowBinding
import com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.ui.detailtvshow.DetailTvShowActivity
import com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.ui.detailtvshow.DetailTvShowViewModel
import com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.ui.tvshow.adapter.CardViewTvShowAdapter
import com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.ui.tvshow.viewmodel.TvShowViewModel
import com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.viewmodel.ViewModelFactory

class TvShowFragment : Fragment() {

    private lateinit var binding: FragmentTvShowBinding

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentTvShowBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val factory = ViewModelFactory.getInstance(requireActivity())
        val tvShowViewModel = ViewModelProvider(this, factory) [TvShowViewModel::class.java]
        val tvShows = tvShowViewModel.getListTvShow()

        showRecyclerCardView(tvShows)
    }

    private fun showRecyclerCardView(tvShows: List<TvShow>) {
        with(binding) {
            rvTvshow.setHasFixedSize(true)
            rvTvshow.layoutManager = LinearLayoutManager(context)

            val cardViewTvShowAdapter = CardViewTvShowAdapter(tvShows)
            rvTvshow.adapter = cardViewTvShowAdapter

            cardViewTvShowAdapter.setOnItemClickCallback(object : CardViewTvShowAdapter.OnItemClickCallback {
                override fun onItemClicked(data: TvShow) {
                    showSelectedTvShow(data)
                    val gotoDetailTvShow = Intent(context, DetailTvShowActivity::class.java)
                    gotoDetailTvShow.putExtra(DetailTvShowActivity.EXTRA_TV_SHOW, data.tvShowId)
                    startActivity(gotoDetailTvShow)
                }
            })

        }
    }

    private fun showSelectedTvShow(tvShow: TvShow) {
        Toast.makeText(context, "Kamu memilih " + tvShow.tvShowTitle, Toast.LENGTH_SHORT).show()
    }
}