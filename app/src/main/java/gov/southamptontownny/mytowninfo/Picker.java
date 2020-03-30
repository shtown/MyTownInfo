package gov.southamptontownny.mytowninfo;

import gov.southamptontownny.mytowninfo.util.SystemUiHider;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 * @see SystemUiHider
 */
public class Picker extends Activity {
	
	Button b1,b2,b3,b4,b5;
	int request_Code = 1;
    /**
     * Whether or not the system UI should be auto-hidden after
     * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
     */ 
    private static final boolean AUTO_HIDE = false;

    /**
     * If {@link #AUTO_HIDE} is set, the number of milliseconds to wait after
     * user interaction before hiding the system UI.
     */
    private static final int AUTO_HIDE_DELAY_MILLIS = 24000;

    /**
     * If set, will toggle the system UI visibility upon interaction. Otherwise,
     * will show the system UI visibility upon interaction.
     */
    private static final boolean TOGGLE_ON_CLICK = false;

    /**
     * The flags to pass to {@link SystemUiHider#getInstance}.
     */
    private static final int HIDER_FLAGS = SystemUiHider.FLAG_FULLSCREEN;

    /**
     * The instance of the {@link SystemUiHider} for this activity.
     */
    private SystemUiHider mSystemUiHider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picker);
        
        b1 = (Button) findViewById(R.id.button1);
        b1.setOnClickListener(new OnClickListener()
        {
        	public void onClick(View arg0) {
        		Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("https://gis.southamptontownny.gov/infocenter"));
        		startActivity(i);
        	}
        });

        b2 = (Button) findViewById(R.id.button2);
        b2.setOnClickListener(new OnClickListener()
        {
        	public void onClick(View arg0) {
        		Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("https://eportal.southamptontownny.gov/webprofile"));
        		startActivity(i);
        	}
        });
        
        b3 = (Button) findViewById(R.id.button3);
        b3.setOnClickListener(new OnClickListener()
        {
        	public void onClick(View arg0) {
        		Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("https://gis.southamptontownny.gov/sales"));
        		startActivity(i);
        	}
        });
        
        b4 = (Button) findViewById(R.id.button4);
        b4.setOnClickListener(new OnClickListener()
        {
        	public void onClick(View arg0) {
        		Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("https://gis.southamptontownny.gov/historic"));
        		startActivity(i);
        	}
        });
        
        b5 = (Button) findViewById(R.id.button5);
        b5.setOnClickListener(new OnClickListener()
        {
        	public void onClick(View arg0) {
        		Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("https://gis.southamptontownny.gov/evaclocator"));
        		startActivity(i);
        	}
        });


    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // Trigger the initial hide() shortly after the activity has been
        // created, to briefly hint to the user that UI controls
        // are available.
        delayedHide(100);
    }


    /**
     * Touch listener to use for in-layout UI controls to delay hiding the
     * system UI. This is to prevent the jarring behavior of controls going away
     * while interacting with activity UI.
     */
    View.OnTouchListener mDelayHideTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (AUTO_HIDE) {
                delayedHide(AUTO_HIDE_DELAY_MILLIS);
            }
            return false;
        }
    };

    Handler mHideHandler = new Handler();
    Runnable mHideRunnable = new Runnable() {
        @Override
        public void run() {
            //mSystemUiHider.hide();
        }
    };

    /**
     * Schedules a call to hide() in [delay] milliseconds, canceling any
     * previously scheduled calls.
     */
    private void delayedHide(int delayMillis) {
        mHideHandler.removeCallbacks(mHideRunnable);
        mHideHandler.postDelayed(mHideRunnable, delayMillis);
    }
    
    }
