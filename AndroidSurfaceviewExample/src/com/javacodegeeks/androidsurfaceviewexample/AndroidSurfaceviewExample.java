package com.javacodegeeks.androidsurfaceviewexample;

import java.io.FileNotFoundException;

import java.io.FileOutputStream;
import java.io.IOException;

import stroke.Stroke;
import stroke.StrokePoint;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import android.widget.Toast;


public class AndroidSurfaceviewExample extends Activity implements SurfaceHolder.Callback, View.OnClickListener, View.OnTouchListener {
	TextView testView;

	SurfaceView surfaceView;
	SurfaceHolder surfaceHolder;
	
	int xLoc = 100;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);

		/*surfaceView = (SurfaceView) findViewById(R.id.surfaceView);
		surfaceHolder = surfaceView.getHolder();

		// Install a SurfaceHolder.Callback so we get notified when the
		// underlying surface is created and destroyed.
		surfaceHolder.addCallback(this);

		// deprecated setting, but required on Android versions prior to 3.0
		surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
		
		surfaceView.setOnTouchListener(this);
		surfaceView.setClickable(true);
		surfaceView.setOnClickListener(this);*/
	}
	
	public void surfaceChanged(SurfaceHolder holder, int format, int w, int h) {
		
	}

	
	public void surfaceCreated(SurfaceHolder holder) {
		Log.d("Message", "P");
		Canvas c = holder.lockCanvas();
        c.drawARGB(255, 234, 243, 234);
        Paint redPaint = new Paint();
        redPaint.setColor(Color.RED);
        c.drawCircle(xLoc, 100, 30, redPaint);
        holder.unlockCanvasAndPost(c);
	}

	public void surfaceDestroyed(SurfaceHolder holder) {
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Log.d("Message", "C");
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		++xLoc;
		Log.d("Action", String.format("%d",event.getAction())); //0 - down, 1 - up, 2 - move
		Canvas c = surfaceHolder.lockCanvas();
		StrokePoint point = new StrokePoint(event.getX(), event.getY(), event.getPressure());
        draw(c, point);
        surfaceHolder.unlockCanvasAndPost(c);
		return false;
	}
	
	public void draw(Canvas c, Stroke stroke) {
		Paint whitePaint = new Paint();
		whitePaint.setColor(Color.WHITE);
		DisplayMetrics metrics = getBaseContext().getResources().getDisplayMetrics();         
		int w = metrics.widthPixels;
		int h = metrics.heightPixels;
		c.drawRect(10, 10, w, h, whitePaint);
        Paint redPaint = new Paint();
        redPaint.setColor(Color.RED);
        stroke.draw(c, redPaint);
	}

}