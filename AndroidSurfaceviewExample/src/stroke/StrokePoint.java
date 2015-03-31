package stroke;

import android.graphics.Canvas;
import android.graphics.Paint;

public class StrokePoint extends Stroke {

	float x, y;
	float pressure;
	
	public StrokePoint(float x, float y) {
		this.x = x;
		this.y = y;
		this.pressure = 0;
	}
	
	public StrokePoint(float x, float y, float pressure) {
		this.x = x;
		this.y = y;
		this.pressure = pressure;
	}
	
	@Override
	public void draw(Canvas canvas, Paint paint) {
		if(pressure < .5) {
			canvas.drawPoint(x, y, paint);
		} else {
			canvas.drawRect(x - pressure * 2.5f, y - pressure * 2.5f, x - pressure * 2.5f, y + pressure * 2.5f, paint);
		}
		canvas.drawText((x + ", " + y + ", " + pressure), x, y, paint);
	}

}
