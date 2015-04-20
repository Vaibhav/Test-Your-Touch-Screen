package vk.testtouchscreen;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    private TextView Message;
    private GestureDetector GD;
    private Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = (Button) findViewById(R.id.button);
        Message = (TextView) findViewById(R.id.Message);
        this.GD = new GestureDetector(this, this);
        GD.setOnDoubleTapListener(this);

        b.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Message.setText("Button Clicked");
                    }
                });

        b.setOnLongClickListener(
                new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        Message.setText("Button Long Clicked");
                        return true;
                    }
                }
        );

    }


    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        Message.setText("Single Tap Confirmed");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        Message.setText("Double Tap");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        Message.setText("Double Tap Event");
        return true;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        Message.setText("onDown");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        Message.setText("Show Press");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        Message.setText("Single Tap Up");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        Message.setText("Scrolling");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        Message.setText("Long Press");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        Message.setText("Fling");
        return true;
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.GD.onTouchEvent(event);
        return super.onTouchEvent(event);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
