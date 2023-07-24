package com.example.myapplicationnewsapp.data.remote.response


import com.example.myapplicationnewsapp.domain.model.ArticleModel
import com.example.myapplicationnewsapp.domain.model.NewsModel
import com.example.myapplicationnewsapp.utils.orEmpty
import com.example.myapplicationnewsapp.utils.replaceIfNull
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.sql.Timestamp

data class NewsResponse(
  @SerializedName("status")
  @Expose
  val status: String?,
  @SerializedName("totalResults")
  @Expose
  val totalResults: Int?,
  @SerializedName("articles")
  @Expose
  val articles: ArrayList<ArticleResponse>?
) {
  companion object {

    fun transform(response: NewsResponse): NewsModel {
      return NewsModel(
        response.status.replaceIfNull(),
        response.totalResults.replaceIfNull(),
        transformList(response.articles.orEmpty())
      )
    }

    private fun transformList(response: ArrayList<ArticleResponse>): ArrayList<ArticleModel> {
      return ArrayList(
        response.map {
          ArticleModel(
            it.urlToImage.replaceIfNull(),
            it.title.replaceIfNull(),
            it.source?.let { src -> transformSource(src) }.replaceIfNull(),
            it.publishedAt,
            it.url.replaceIfNull()
          )
        }
      )
    }

    private fun transformSource(response: SourceResponse): String {
      return response.name.replaceIfNull()
    }
  }
}

data class ArticleResponse(
  @SerializedName("source")
  @Expose
  val source: SourceResponse?,
  @SerializedName("author")
  @Expose
  val author: String?,
  @SerializedName("title")
  @Expose
  val title: String?,
  @SerializedName("description")
  @Expose
  val description: String?,
  @SerializedName("url")
  @Expose
  val url: String?,
  @SerializedName("urlToImage")
  @Expose
  val urlToImage: String?,
  @SerializedName("publishedAt")
  @Expose
  val publishedAt: Timestamp?,
  @SerializedName("content")
  @Expose
  val content: String?
)

data class SourceResponse(
  @SerializedName("id")
  @Expose
  val id: String?,
  @SerializedName("name")
  @Expose
  val name: String?
)