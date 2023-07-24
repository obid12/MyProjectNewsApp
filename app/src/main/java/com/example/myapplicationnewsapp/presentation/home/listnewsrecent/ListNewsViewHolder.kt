package com.example.myapplicationnewsapp.presentation.home.listnewsrecent

import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationnewsapp.databinding.ItemNewsBinding
import com.example.myapplicationnewsapp.domain.model.ArticleModel
import com.example.myapplicationnewsapp.utils.formatDateForDetails
import com.example.myapplicationnewsapp.utils.getImageNewsSourceUrl
import com.example.myapplicationnewsapp.utils.getImageNewsUrl

class ListNewsViewHolder(private val binding: ItemNewsBinding) :
  RecyclerView.ViewHolder(binding.root) {
  fun bind(data: ArticleModel) {
    binding.run {
      getImageNewsUrl(imgNewsRecent, data.image)
      getImageNewsSourceUrl(imgSource, data.url)
      txtDate.text = formatDateForDetails(data.time)
      txtTitle.text = data.title
      txtSource.text = data.source
    }
  }
}