package com.dogzz.kedditd.commons

import android.support.v4.app.Fragment
import rx.subscriptions.CompositeSubscription


/**
 * Superclass for fragments with all RxJava logic
 * Created by afon on 13.08.2016.
 */
open class RxBaseFragment : Fragment() {
    protected var subscriptions = CompositeSubscription()

    override fun onResume() {
        super.onResume()
        subscriptions = CompositeSubscription()
    }

    override fun onPause() {
        super.onPause()
        if (!subscriptions.isUnsubscribed) {
            subscriptions.unsubscribe()
        }
        subscriptions.clear()
    }
}