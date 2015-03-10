package com.example.dev.clp_test.strokes;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.UUID;

/**
 * Created by Dev on 3/9/2015.
 */
public abstract class Stroke {

    long timeStamp;
    UUID id;

    public long getTime(){
        return timeStamp;
    }

    public abstract void draw(Canvas canvs, Paint paint);

    public abstract void move(float deltaX, float deltaY);
}
