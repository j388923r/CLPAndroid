package stroke;

import android.graphics.Canvas;
import android.graphics.Paint;

public class StrokeLine extends Stroke {

	float startX, startY, endX, endY;
	
	public StrokeLine(float startX, float startY, float endX, float endY) {
		this.startX = startX;
		this.startY = startY;
		this.endX = endX;
		this.endY = endY;
	}
	
	@Override
	public void draw(Canvas canvas, Paint paint) {
		canvas.drawLine(startX, startY, endX, endY, paint);
	}

}
