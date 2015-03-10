package com.example.dev.clp_test.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.jar.Attributes;

/**
 * Created by Dev on 3/9/2015.
 */
public class PreviewView extends SurfaceView implements SurfaceHolder.Callback {

    Paint paint = new Paint();

    public PreviewView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);

        SurfaceHolder holder = getHolder();

        holder.addCallback(this);
    }


    public void onDraw(Canvas canvas) {
        int width = this.getWidth();
        int height = this.getHeight();
        paint.setStyle(Paint.Style.FILL);
        paint.setARGB(24, 54, 43, 213);
        canvas.drawRect(0, 0, width, height, paint);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
