package com.javacodegeeks.androidsurfaceviewexample;

import java.io.FileNotFoundException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import com.googlecode.tesseract.android.TessBaseAPI;

import stroke.Stroke;
import stroke.StrokePoint;

import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Environment;
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

	public static final String PACKAGE_NAME = "com.javacodegeeks.androidsurfaceviewexample";
	public static final String DATA_PATH = Environment
			.getExternalStorageDirectory().toString() + "/AndroidSurfaceviewExample/";
	
	// You should have the trained data file in assets folder
	// You can get them at:
	// http://code.google.com/p/tesseract-ocr/downloads/list
	public static final String lang = "eng";

	private static final String TAG = "AndroidSurfaceviewExample.java";
	
	SurfaceView surfaceView;
	SurfaceHolder surfaceHolder;
	
	int xLoc = 100;
	int w, h;
	Bitmap bmp;
	Canvas recognizerCanvas;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		String[] paths = new String[] { DATA_PATH, DATA_PATH + "tessdata/" };

		for (String path : paths) {
			File dir = new File(path);
			if (!dir.exists()) {
				if (!dir.mkdirs()) {
					Log.v(TAG, "ERROR: Creation of directory " + path + " on sdcard failed");
					return;
				} else {
					Log.v(TAG, "Created directory " + path + " on sdcard");
				}
			}

		}
		

		// lang.traineddata file with the app (in assets folder)
		// You can get them at:
		// http://code.google.com/p/tesseract-ocr/downloads/list
		// This area needs work and optimization
		if (!(new File(DATA_PATH + "tessdata/" + lang + ".traineddata")).exists()) {
			try {

				AssetManager assetManager = getAssets();
				InputStream in = assetManager.open("tessdata/" + lang + ".traineddata");
				//GZIPInputStream gin = new GZIPInputStream(in);
				OutputStream out = new FileOutputStream(DATA_PATH
						+ "tessdata/" + lang + ".traineddata");

				// Transfer bytes from in to out
				byte[] buf = new byte[1024];
				int len;
				//while ((lenf = gin.read(buff)) > 0) {
				while ((len = in.read(buf)) > 0) {
					out.write(buf, 0, len);
				}
				in.close();
				//gin.close();
				out.close();
				
				Log.v(TAG, "Copied " + lang + " traineddata");
			} catch (IOException e) {
				Log.e(TAG, "Was unable to copy " + lang + " traineddata " + e.toString());
			}
		}
		
		setContentView(R.layout.activity_main);
		
		DisplayMetrics metrics = getBaseContext().getResources().getDisplayMetrics();         
		w = metrics.widthPixels;
		h = metrics.heightPixels;
		
		Bitmap.Config conf = Bitmap.Config.ARGB_8888; // see other conf types
		bmp = Bitmap.createBitmap(w, h, conf); 
		recognizerCanvas = new Canvas(bmp);
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
		//++xLoc;
		Log.d("Time", String.format("%d",event.getEventTime())); //0 - down, 1 - up, 2 - move
		Canvas c = surfaceHolder.lockCanvas();
		StrokePoint point = new StrokePoint(event.getX(), event.getY(), event.getPressure());
        draw(c, point);
        surfaceHolder.unlockCanvasAndPost(c);
		return false;
	}
	
	public void draw(Canvas c, Stroke stroke) {
		Paint whitePaint = new Paint();
		whitePaint.setColor(Color.WHITE);
		c.drawRect(10, 10, w, h, whitePaint);
        Paint redPaint = new Paint();
        redPaint.setColor(Color.RED);
        stroke.draw(c, redPaint);
	}

	public void draw(Canvas c, ArrayList<Stroke> strokes) {
		Paint whitePaint = new Paint();
		whitePaint.setColor(Color.WHITE);
		c.drawRect(10, 10, w, h, whitePaint);
        Paint blackPaint = new Paint();
        blackPaint.setColor(Color.RED);
        for(Stroke stroke : strokes)
        	stroke.draw(c, blackPaint);
	}
	
	public void recognize(View view) {
		TextView recognized1 = (TextView) findViewById(R.id.recognized1);
		
		TessBaseAPI baseApi = new TessBaseAPI();
		baseApi.setDebug(true);
		baseApi.init(DATA_PATH, lang);
		baseApi.setImage(bmp);
		
		String recognizedText = baseApi.getUTF8Text();
		
		baseApi.end();
		recognized1.setText(recognizedText);
	}
}