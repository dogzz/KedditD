package com.dogzz.kedditd.commons

import com.dogzz.kedditd.commons.adapter.AdapterConstants
import com.dogzz.kedditd.commons.adapter.ViewType

/** Data object to represent each news
 * Created by afon on 12.08.2016.
 */
data class RedditNewsItem(
        val author: String,
        val title: String,
        val numComments: Int,
        val created: Long,
        val thumbnail: String,
        val url: String
) : ViewType {
    override fun getViewType(): Int = AdapterConstants.NEWS
}

data class RedditNews(
        val after: String,
        val before: String,
        val news: List<RedditNewsItem>)