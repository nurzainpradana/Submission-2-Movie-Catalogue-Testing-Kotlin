package com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.ui.tvshow.adapter

import com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.data.source.local.entity.TvShow
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.databinding.ItemCardviewTvshowBinding

class CardViewTvShowAdapter internal constructor(private val listTvShow: List<TvShow>) : RecyclerView.Adapter<CardViewTvShowAdapter.CardViewViewHolder>() {
    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback?) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewViewHolder {
        val itemCardviewTvshowBinding = ItemCardviewTvshowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardViewViewHolder(itemCardviewTvshowBinding)
    }

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        val tvShow = listTvShow[position]
        return holder.bind(tvShow)
    }

    override fun getItemCount(): Int = listTvShow.size

    inner class CardViewViewHolder(private val binding: ItemCardviewTvshowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TvShow) {
            with(binding) {
                Glide.with(binding.root)
                        .load(tvShow.tvShowPoster)
                        .apply(RequestOptions().override(150, 220))
                        .into(imgTvshowItemPoster)
                tvTvshowItemTitle.text = tvShow.tvShowTitle
                tvTvshowItemDescription.text = tvShow.tvShowDescription
                tvTvshowItemGenre.text = tvShow.tvShowGenre
                tvTvshowItemYear.text = tvShow.tvShowYear
                itemView.setOnClickListener { onItemClickCallback?.onItemClicked(tvShow) }
            }
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: TvShow)
    }
}