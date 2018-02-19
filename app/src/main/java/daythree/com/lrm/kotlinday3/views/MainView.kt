/*
package daythree.com.lrm.kotlinday3.views

import android.content.Context
import android.graphics.Color
import android.widget.FrameLayout
import daythree.com.lrm.kotlinday3.R

*/
/**
 * Created by manasi on 7/2/18.
 *//*

class MainView(ctx: Context) : FrameLayout(ctx)
{

    init {
        initialize()
    }

    private var mSplashView: SplashView? = null

    private fun initialize() {
        val context = getContext()

        // initialize the view with all default values
        // you don't need to set these default values, they are already set, except for setIconResource
        // this is only for demonstration purposes
        mSplashView = SplashView(context)
        mSplashView!!.setDuration(500) // the animation will last 0.5 seconds
        mSplashView!!.setBackgroundColor(Color.WHITE) // transparent hole will look white before the animation
        mSplashView!!.setIconColor(Color.rgb(23, 169, 229)) // this is the Twitter blue color
        mSplashView!!.setIconResource(R.drawable.ic_twitter) // a Twitter icon with transparent hole in it
        mSplashView!!.setRemoveFromParentOnEnd(true) // remove the SplashView from MainView once animation is completed

        // add the view
        addView(mSplashView)
    }

    fun unsetSplashView() {
        mSplashView = null
    }

    fun getSplashView(): SplashView? {
        return mSplashView
    }
}
*/
