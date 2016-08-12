package com.dogzz.kedditd.features.news.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.dogzz.kedditd.R
import com.dogzz.kedditd.commons.RedditNewsItem
import com.dogzz.kedditd.commons.adapter.ViewType
import com.dogzz.kedditd.commons.adapter.ViewTypeDelegateAdapter
import com.dogzz.kedditd.commons.extensions.getFriendlyTime
import com.dogzz.kedditd.commons.extensions.inflate
import com.dogzz.kedditd.commons.extensions.loadImg
import kotlinx.android.synthetic.main.news_item.view.*

/**
 * in charge of inflating the News view and return it to our NewsAdapter
 * Created by afon on 12.08.2016.
 */
class NewsDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder = TurnsViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as TurnsViewHolder
        holder.bind(item as RedditNewsItem)
    }

    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
                        parent.inflate(R.layout.news_item)) {
        fun bind(item: RedditNewsItem) = with(itemView) {
            //Picasso.with(itemView.context).load(item.thumbnail).into(img_thumbnail)
            img_thumbnail.loadImg(item.thumbnail)
            description.text = item.title
            author.text = item.author
            comments.text = "${item.numComments} comments"
            time.text = item.created.getFriendlyTime()
        }
    }

}