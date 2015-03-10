package com.example.dev.clp_test.strokes;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.UUID;

/**
 * Created by Dev on 3/9/2015.
 */
public class StrokeLine extends Stroke {

    float startX, startY, endX, endY;

    public StrokeLine(float startX, float startY, float endX, float endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.id = UUID.randomUUID();
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        canvas.drawLine(startX, startY, endX, endY, paint);
    }

    @Override
    public void move(float deltaX, float deltaY) {
        this.startX += deltaX;
        this.endX += deltaX;
        this.startY += deltaY;
        this.endY += deltaY;
    }
}
