package daythree.com.lrm.kotlinday3

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import daythree.com.lrm.kotlinday3.models.TwitterFeed
import daythree.com.lrm.kotlinday3.views.ContentRecyclerView
import daythree.com.lrm.kotlinday3.views.ContentView
import daythree.com.lrm.kotlinday3.views.MainView
import daythree.com.lrm.kotlinday3.views.SplashView
import daythree.com.lrm.kotlinday3.views.SplashView.ISplashListener
import java.util.*
import kotlin.collections.ArrayList
import android.text.method.TextKeyListener.clear




class MainActivity : Activity() {

    private val DO_XML = false

    private var mMainView: SwipeRefreshLayout? = null
    private var mContentView: View? = null
    private var mContentRecyclerView: View? = null
    private val mHandler = Handler()
    val TAG ="MainActivity"
    private var splashView:SplashView?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        // change the DO_XML variable to switch between code and xml
        if (DO_XML) {
            // inflate the view from XML and then get a reference to it
            setContentView(R.layout.activity_main)
            mMainView = findViewById(R.id.main_view) as SwipeRefreshLayout
            splashView = findViewById(R.id.splash_view) as SplashView

        } else {
            // create the main view and it will handle the rest
            mMainView = MainView(this@MainActivity)
            splashView = (mMainView as MainView).getSplashView()
            setContentView(mMainView)
        }

        // pretend like we are loading data
        startLoadingData()
    }


        fun startLoadingData() {
            // finish "loading data" in a random time between 1 and 3 seconds
            val random = Random()
            mHandler.postDelayed(
                    { onLoadingDataEnded() }
                    , (1000 + random.nextInt(1000)).toLong())
        }

        fun onLoadingDataEnded() {
            val context = applicationContext
            // now that our data is loaded we can initialize the content view
            /*mContentView = ContentView(context)
            // add the content view to the background
            mMainView?.addView(mContentView, 0)*/
            mContentRecyclerView= ContentRecyclerView(context)

            splashView?.splashAndDisappear(object : ISplashListener {
                override fun onStart() {
                    // the animation will last 0.5 seconds
                    if (BuildConfig.DEBUG) {
                        Log.d(TAG, "splash started")
                    }

                }

                override fun onUpdate(completionFraction: Float) {

                    if (BuildConfig.DEBUG) {
                        Log.d(TAG, "splash at " + String.format("%.2f", completionFraction * 100) + "%")
                    }
                }

                override fun onEnd() {
                    //finish()
                    // log the animation end event
                    if (BuildConfig.DEBUG) {
                        Log.d(TAG, "splash ended")
                    }
                    // free the view so that it turns into garbage
                    //splashView = null
                    if (!DO_XML) {
                        // if inflating from code we will also have to free the reference in MainView as well
                        // otherwise we will leak the View, this could be done better but so far it will suffice
                        (mMainView as MainView).unsetSplashView()
                        setContentView(R.layout.activity_main)
                        mMainView = findViewById(R.id.main_view) as SwipeRefreshLayout
                        splashView = findViewById(R.id.splash_view) as SplashView
                        val intent = Intent(this@MainActivity, PullToRefreshActivity::class.java)
                        startActivity(intent)
                    }

                }
            })

        }


}
