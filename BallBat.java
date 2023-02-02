import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class BallBat extends Sprite {
	private Ball ball;
	
	
	public BallBat(int x, int y, Ball ball) {
		super(x, y, C.BatWidth, C.BatHeight);
		this.ball = ball; 

	}

	@Override
	public void update(Keyboard keyboard) {
		checkCollision(keyboard);		
		move(keyboard);
	}

	@Override
	public void draw(Graphics2D graphics) {

		graphics.setColor(Color.green);
		graphics.fillRect(getX(), getY(), getWidth(), getHeight());
		
	}

	private void move(Keyboard keyboard) {
		
		if(keyboard.isKeyDown(Key.Right))
			setX(getX()+C.BATSPEED);
		if(keyboard.isKeyDown(Key.Left))
			setX(getX()-C.BATSPEED);
		if(getX() <= 0)
			setX(0);
		if(getX() >= 700)
			setX(700);	
		
	}
	private void checkCollision (Keyboard keyboard) {
		
		Rectangle batBox = new Rectangle(getX(),getY(), getWidth(), getHeight());
		Rectangle ballBox = new Rectangle(ball.getX(),ball.getY(),ball.getWidth(),ball.getHeight());
		
		if(batBox.intersects(ballBox)) {
			
			if(keyboard.isKeyDown(Key.Right) && ball.getXSpeed() < 0) {
				ball.setYSpeed(-ball.getYSpeed());
				ball.setXSpeed(-ball.getXSpeed());
			}
			else if(keyboard.isKeyDown(Key.Left) && ball.getXSpeed() > 0) {
				ball.setYSpeed(-ball.getYSpeed());
				ball.setXSpeed(-ball.getXSpeed());
			}
			else {
				ball.setYSpeed(-ball.getYSpeed());
			}

			
		}
	}
}
