package stroke;

import java.util.UUID;

import com.javacodegeeks.androidsurfaceviewexample.User;

import android.graphics.Canvas;
import android.graphics.Paint;

public abstract class Stroke {

	protected UUID id;
	protected long timestamp;
	public User user;
	
	public long getTime(){
		return timestamp;
	}
	
	public abstract void draw(Canvas canvas, Paint paint);
}
