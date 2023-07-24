package com.example.myapplicationnewsapp.presentation.home.listnewsrecent

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.myapplicationnewsapp.databinding.ItemNewsBinding
import com.example.myapplicationnewsapp.domain.model.ArticleModel

class ListNewsRecentAdapter(private val onclickListener: OnclickListener) :
  PagingDataAdapter<ArticleModel, ViewHolder>(
    DiffCallback
  ) {
  object DiffCallback : DiffUtil.ItemCallback<ArticleModel>() {
    override fun areItemsTheSame(
      oldItem: ArticleModel,
      newItem: ArticleModel
    ) =
      oldItem.hashCode() == newItem.hashCode()

    override fun areContentsTheSame(
      oldItem: ArticleModel,
      newItem: ArticleModel
    ) =
      oldItem.hashCode() == newItem.hashCode()
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val newsItem = getItem(position)
    val itemHolder = holder as ListNewsViewHolder
    newsItem?.let { itemHolder.bind(it) }
    holder.itemView.setOnClickListener {
      newsItem?.let { data -> onclickListener.onClick(data) }
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val binding = ItemNewsBinding.inflate(
      LayoutInflater.from(parent.context), parent, false
    )
    return ListNewsViewHolder(binding)
  }

  class OnclickListener(
    val clickListener: (entity: ArticleModel) ->
    Unit
  ) {
    fun onClick(entity: ArticleModel) = clickListener(entity)
  }
}