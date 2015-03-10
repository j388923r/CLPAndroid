package com.example.dev.clp_test.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import java.util.ArrayList;

import com.example.dev.clp_test.strokes.StrokePoint;

/**
 * Created by Dev on 3/9/2015.
 */
public class StudentAnswerView extends SurfaceView implements SurfaceHolder.Callback, View.OnTouchListener{

    Paint paint = new Paint();
    ArrayList<StrokePoint> pointsDrawn = new ArrayList<StrokePoint>();

    public StudentAnswerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setWillNotDraw(false);
        paint.setARGB(0, 234, 34, 45);

        SurfaceHolder holder = getHolder();

        holder.addCallback(this);

        setOnTouchListener(this);
    }

    @Override
    public void onDraw(Canvas canvas) {
        paint.setARGB(0, 234, 34, 45);
        //canvas.drawRect(100, 100, 100, 100, paint);
        paint.setARGB(0, 45, 34, 234);
        for(StrokePoint point: pointsDrawn)
            point.draw(canvas, paint);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        setWillNotDraw(false);
        Log.w("NE", "DRAwing");
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Log.w("AA", "" + event.getDownTime());
        pointsDrawn.add(new StrokePoint(event.getX(), event.getY(), event.getEventTime()));
        invalidate();
        return false;
    }
}
