package com.example.myapplicationnewsapp.presentation.home.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

enum class TabHome(val type: Int) {
  BUSINESS(0),
  ENTERTAINMENT(1),
  HEALTH(2),
  SCIENCE(3),
  SPORTS(4),
  TECHNOLOGY(5)
}

@Parcelize
data class TabHomeModel(
  val type: Int,
  val nameTab: String,
  val param: String
) : Parcelable

object HomeModel {
  fun getList(list: ArrayList<TabHomeModel>): ArrayList<TabHomeModel> {
    list.clear()
    list.add(TabHomeModel(TabHome.BUSINESS.type, "Business", "business"))
    list.add(TabHomeModel(TabHome.ENTERTAINMENT.type, "Entertainment", "entertainment"))
    list.add(TabHomeModel(TabHome.HEALTH.type, "Health", "health"))
    list.add(TabHomeModel(TabHome.SCIENCE.type, "Science", "science"))
    list.add(TabHomeModel(TabHome.SPORTS.type, "Sports", "sports"))
    list.add(TabHomeModel(TabHome.TECHNOLOGY.type, "Technology", "technology"))
    return list
  }
}


