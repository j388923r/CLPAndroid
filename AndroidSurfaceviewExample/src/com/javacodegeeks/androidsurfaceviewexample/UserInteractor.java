package com.javacodegeeks.androidsurfaceviewexample;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.*;

public class UserInteractor implements View.OnTouchListener{

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		Log.d("Message", String.format("X:%.2f Y:%.2f Pressure:%d", event.getX(), event.getY(), event.getPressure()));
		return true;
	}

}
