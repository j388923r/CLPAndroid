package com.javacodegeeks.androidsurfaceviewexample;

import java.util.ArrayList;

import stroke.Stroke;
import stroke.StrokePath;
import stroke.StrokePoint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

public class StudentAnswerView extends SurfaceView implements SurfaceHolder.Callback, View.OnTouchListener {

	SurfaceHolder holder;
	ArrayList<Stroke> strokes;
	StrokePath currentPath = new StrokePath();
	boolean touching = false;
	int xLoc = 100;
	
	public StudentAnswerView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		holder = this.getHolder();
		strokes = new ArrayList<Stroke>();
		
		holder.addCallback(this);
		
		setOnTouchListener(this);
		setClickable(true);
	}
	
	public StudentAnswerView(Context context, AttributeSet attributes) {
		super(context, attributes);
		
		holder = this.getHolder();
		strokes = new ArrayList<Stroke>();
		
		holder.addCallback(this);
		
		setOnTouchListener(this);
		setClickable(true);
	}

	@Override
	public void onDraw(Canvas canvas) {
		Log.d("Action", String.format("%d",123)); //0 - down, 1 - up, 2 - move
		Paint redPaint = new Paint();
        redPaint.setColor(Color.RED);
		for(Stroke s: strokes) {
			s.draw(canvas, redPaint);
		}
	}
	
	//@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		++xLoc;
		Log.d("Action", String.format("%d",event.getAction())); //0 - down, 1 - up, 2 - move
		StrokePoint point = new StrokePoint(event.getX(), event.getY(), event.getPressure());
		if(event.getAction() == 0) {
			currentPath = new StrokePath();
			strokes.add(currentPath);
			currentPath.addPoint(point);
			touching = true;
		} else if(event.getAction() == 2 && touching) {
			currentPath.addPoint(point);
		} else {
			if(touching) {
				currentPath.addPoint(point);
				touching = false;
			}
		}
		//Canvas c = holder.lockCanvas();
		
        //holder.unlockCanvasAndPost(c);
        invalidate();
		return false;
	}

	//@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		Log.d("Message", "P");
		setWillNotDraw(false);
		Canvas c = holder.lockCanvas();
        c.drawARGB(0, 234, 234, 234);
        Paint whitePaint = new Paint();
        whitePaint.setColor(Color.WHITE);
        c.drawRect(10, 10, 580, 580, whitePaint);
        holder.unlockCanvasAndPost(c);
	}

	//@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub
		
	}

	//@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		
	}

}
