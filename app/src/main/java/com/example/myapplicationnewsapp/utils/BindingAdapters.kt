package com.example.myapplicationnewsapp.utils

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import coil.load
import coil.request.ImageRequest
import com.example.myapplicationnewsapp.R
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
//
//fun formatDateForDetails(date: Timestamp?): String {
//  val format = SimpleDateFormat("dd MMM yyyy | hh:mm aaa", Locale.getDefault())
//  return format.format(Date(date?.time.replaceIfNull()))
//}

fun formatDateForDetails(date: Timestamp?): String {
  val format = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
  return format.format(Date(date?.time.replaceIfNull()))
}

@BindingAdapter("imagesSourceUrl")
fun getImageNewsSourceUrl(iv: ImageView, urlNews: String?) {
  val iconUrl = "https://besticon-demo.herokuapp.com/icon?url=${urlNews}&size=80..120..200"
  iconUrl.let {
    val imageUrl = ImageRequest.Builder(iv.context)
      .data("${it.toUri()}")
      .allowHardware(false)
      .build()
    iv.load("${imageUrl.data}") {
      placeholder(R.drawable.loading_animation)
      this.error(R.drawable.ic_broken_image)
    }
  }
}

@BindingAdapter("imagesUrl")
fun getImageNewsUrl(iv: ImageView, imgUrl: String?) {
  imgUrl.let {
    val imageUrl = ImageRequest.Builder(iv.context)
      .data("${it?.toUri()}")
      .allowHardware(false)
      .build()
    iv.load("${imageUrl.data}") {
      placeholder(R.drawable.loading_animation)
      this.error(R.drawable.ic_broken_image)
    }
  }
}