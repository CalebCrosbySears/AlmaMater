package edu.csearsggc.almamater;

/**
 * Created by Caleb Sears on 11/1/2016.
 */

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.ImageView;

public class About extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_LOCKED);

    }
}
