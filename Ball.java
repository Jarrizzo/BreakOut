import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball extends Sprite{
	
	private int ySpeed = -C.BALLSPEED;
	private int xSpeed = -C.BALLSPEED;
	Game game;
	
	public Ball(int x, int y, int width, int height,Game game) {
		super(x, y, width, height);
		this.game = game;
	}

	@Override
	public void update(Keyboard keyboard) {

		WallCollision();
		move();
	}

	@Override
	public void draw(Graphics2D graphics) {
		graphics.setColor(Color.WHITE);
		graphics.fillOval(getX(), getY(), getWidth(), getHeight());
		
	}
	
	
	private void move() {
		
		setY(getY() + ySpeed);
		setX(getX() + xSpeed);
		
	}
	

	private void WallCollision () {
		
		if (getY( ) <= 105-C.BallSize ) {
			
			ySpeed = -ySpeed;
		}
		if (getX( ) <= 0 || getX() >= 800-C.BallSize ) {
			
			xSpeed = -xSpeed;
		}
		if(getY() >= C.BoardHeight - C.BallSize) {
			game.setGamestate(GameState.ROUNDLOSS  );
		}

	}

	public void setYSpeed(int ySpeed) {
		this.ySpeed = ySpeed;
	}
	public int getYSpeed() {
		return this.ySpeed;
	}
	public void setXSpeed(int xSpeed) {
		this.xSpeed = xSpeed;
	}
	public int getXSpeed() {
		return this.xSpeed;
	}

}
