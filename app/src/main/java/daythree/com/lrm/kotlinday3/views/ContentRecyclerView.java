package daythree.com.lrm.kotlinday3.views;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import daythree.com.lrm.kotlinday3.MainActivity;
import daythree.com.lrm.kotlinday3.R;
import daythree.com.lrm.kotlinday3.models.TwitterFeed;

/**
 * Created by manasi on 8/2/18.
 */

public class ContentRecyclerView  extends RecyclerView {

    private Context context;
    private MainActivity mainActivity;
    public ContentRecyclerView(Context context){
        super(context);
        //this.context=context;
        //mainActivity =(MainActivity)context;
        //mainActivity.setRecyclerView();
    }

}

