package daythree.com.lrm.kotlinday3

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import daythree.com.lrm.kotlinday3.models.TwitterFeed

class PullToRefreshActivity : Activity() {

    private lateinit var feedList: List<TwitterFeed>
    private var mMainView: SwipeRefreshLayout? = null
    lateinit var adapter: RecyclerView.Adapter<MyAndroidAdapter.ViewHolder>
    private var recyclerView: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pull_to_refresh)
        mMainView = findViewById(R.id.main_view) as SwipeRefreshLayout
        recyclerView = findViewById(R.id.rv_twitter_feed) as RecyclerView
        setRecyclerView()
    }




    fun setRecyclerView() {
        feedList = ArrayList<TwitterFeed>()
        //adding a layoutmanager
        recyclerView?.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false) as RecyclerView.LayoutManager?

        var x = 3
        while (x > 0) {
            (feedList as ArrayList<TwitterFeed>).add(TwitterFeed(R.drawable.alarm, "The New York Times", "Ang punto ng paggamit ng Lorem Ipsum ay ito ay may humigit-kumulang na normal na distribusyion ng mga lettra",
                    R.drawable.remote_control, R.drawable.book2, "kesa sa paggamit ng 'Dito ang nilalaman, dito ang nilalaman', pinamumuka nitong nababasa. Maraming desktop publishing packages at web page editors ang gumagamit na ngayong ng Lorem Ipsum bilang ..."))
            x--
        }


        adapter = MyAndroidAdapter(feedList)
        //now adding the adapter to recyclerview
        recyclerView?.adapter = adapter


        mMainView?.setOnRefreshListener(object : SwipeRefreshLayout.OnRefreshListener {
            override fun onRefresh() {

                feedList = arrayListOf()
                adapter.notifyDataSetChanged()
                mMainView?.setRefreshing(false);
               /* var x = 3
                while (x > 0) {
                    (feedList as ArrayList<TwitterFeed>).add(TwitterFeed(R.drawable.alarm, "The New York Times", "Ang punto ng paggamit ng Lorem Ipsum ay ito ay may humigit-kumulang na normal na distribusyion ng mga lettra",
                            R.drawable.remote_control, R.drawable.book2, "kesa sa paggamit ng 'Dito ang nilalaman, dito ang nilalaman', pinamumuka nitong nababasa. Maraming desktop publishing packages at web page editors ang gumagamit na ngayong ng Lorem Ipsum bilang ..."))
                    x--
                }
                adapter.notifyDataSetChanged()*/
            }

        }
        )

    }

    //adapter
    class MyAndroidAdapter(var feedList: List<TwitterFeed>) : RecyclerView.Adapter<MyAndroidAdapter.ViewHolder>()
    {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAndroidAdapter.ViewHolder {
            val v = LayoutInflater.from(parent.context).inflate(R.layout.item_twitter_feed, parent, false)
            return ViewHolder(v)
        }

        override fun onBindViewHolder(holder: MyAndroidAdapter.ViewHolder, position: Int) {
            holder.bindItems(feedList[position])
        }

        override fun getItemCount(): Int {
            return feedList.size
        }

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
        {

            fun bindItems(feed: TwitterFeed)
            {
                val ivFeed = itemView.findViewById(R.id.iv_feed) as ImageView
                val tvFeedTitle  = itemView.findViewById(R.id.tv_feed_title) as TextView
                val tvFeedDetails  = itemView.findViewById(R.id.tv_feed_details) as TextView
                val tvFeedDesc  = itemView.findViewById(R.id.tv_feed_desc) as TextView
                val ivFeedImage1  = itemView.findViewById(R.id.iv_image1) as ImageView
                val ivFeedImage2  = itemView.findViewById(R.id.iv_image2) as ImageView

                ivFeed.setBackgroundResource(feed.icon)
                ivFeedImage1.setBackgroundResource(feed.feedImage1)
                ivFeedImage2.setBackgroundResource(feed.feedImage2)
                tvFeedTitle.text = feed.feedTitle
                tvFeedDetails.text = feed.feedDetails
                tvFeedDesc.text = feed.feedDesc



            }
        }

        fun clear()
        {
            feedList= arrayListOf()
            notifyDataSetChanged()
        }

        fun addAll(list:List<TwitterFeed>)
        {
            (feedList as ArrayList<TwitterFeed>).addAll(list);
            notifyDataSetChanged();

        }

    }

}
