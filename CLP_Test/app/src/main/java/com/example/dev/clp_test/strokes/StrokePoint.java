package com.example.dev.clp_test.strokes;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.UUID;

/**
 * Created by Dev on 3/9/2015.
 */
public class StrokePoint extends Stroke{

    public float x, y;
    long timeStamp;

    public StrokePoint(float x, float y, long timeStamp) {
        this.x = x;
        this.y = y;
        this.timeStamp = timeStamp;
        this.id = UUID.randomUUID();
    }

    public long getTime() {
        return timeStamp;
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        canvas.drawPoint(x, y, paint);
    }

    @Override
    public void move(float deltaX, float deltaY) {
        this.x += deltaX;
        this.y += deltaY;
    }
}
