package com.dogzz.kedditd.commons.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

/**
 * This interface allow us to have a generic list of delegate adapters and invoke those methods without and
 * knowledge of adapter type - News, Loading or any other
 * One method to create the ViewHolder and another to bind it.
 * Created by afon on 12.08.2016.
 */
interface ViewTypeDelegateAdapter {

    fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder

    fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType)
}