package stroke;

import android.graphics.Canvas;
import android.graphics.Paint;

public class StrokePoint extends Stroke {

	float x, y;
	float pressure;
	
	public StrokePoint(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public StrokePoint(float x, float y, float pressure) {
		this.x = x;
		this.y = y;
		this.pressure = pressure;
	}
	
	@Override
	public void draw(Canvas canvas, Paint paint) {
		canvas.drawPoint(x, y, paint);
		canvas.drawText((x + ", " + y + ", " + pressure), x, y, paint);
	}

}
