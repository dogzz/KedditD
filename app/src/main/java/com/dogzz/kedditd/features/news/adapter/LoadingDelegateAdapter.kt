package com.dogzz.kedditd.features.news.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.dogzz.kedditd.R
import com.dogzz.kedditd.commons.adapter.ViewType
import com.dogzz.kedditd.commons.adapter.ViewTypeDelegateAdapter
import com.dogzz.kedditd.commons.extensions.inflate

/**
 * in charge of inflating the Loading view and return it to our NewsAdapter
 * Created by afon on 12.08.2016.
 */
class LoadingDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup) = TurnsViewHolder(parent)


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
    }

    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.news_item_loading)) {
    }
}