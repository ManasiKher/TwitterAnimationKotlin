package daythree.com.lrm.kotlinday3.views;

import android.content.Context;
import android.widget.ImageView;


import java.util.List;

import daythree.com.lrm.kotlinday3.R;


/**
 * Nothing but an ImageView with a preset image resource
 * @author yildizkabaran
 *
 */
public class ContentView extends android.support.v7.widget.AppCompatImageView {

  public ContentView(Context context){
    super(context);
    initialize();
  }
  
  private void initialize(){
    // set the dummy content image here
    setImageResource(R.drawable.content);
  }
}
