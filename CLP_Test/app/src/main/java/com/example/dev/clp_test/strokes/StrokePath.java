package com.example.dev.clp_test.strokes;

import java.util.ArrayList;

/**
 * Created by Dev on 3/10/2015.
 */
public class StrokePath {
    ArrayList<StrokePoint> path = new ArrayList<StrokePoint>();

    public StrokePath() {

    }

    public void addPoint(StrokePoint point) {
        path.add(point);
    }

    public void move(float x, float y) {
        for(StrokePoint point: path) {
            point.move(x, y);
        }
    }
}
