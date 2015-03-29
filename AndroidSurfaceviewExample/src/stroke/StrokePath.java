package stroke;

import java.util.ArrayList;

import android.graphics.Canvas;
import android.graphics.Paint;

public class StrokePath extends Stroke {

	ArrayList<StrokePoint> points;
	
	public StrokePath() {
		points = new ArrayList<StrokePoint>();
	}
	
	public StrokePath(ArrayList<StrokePoint> points) {
		this.points = points;
	}
	
	public void addPoint(StrokePoint p) {
		points.add(p);
	}
	
	@Override
	public void draw(Canvas canvas, Paint paint) {
		// TODO Auto-generated method stub
		for(int i = points.size() - 1; i >= 1; --i) {
			canvas.drawLine(points.get(i).x, points.get(i).y, points.get(i-1).x, points.get(i-1).y, paint);
		}
	}

}
