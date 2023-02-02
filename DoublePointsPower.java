import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

public class DoublePointsPower extends Sprite{
	
	BallBat BB;
	BrickCollection BC;
	

	
	public DoublePointsPower(int x, int y, int width, int height,BallBat BB,BrickCollection BC) {
		super(x, y, width, height);
		this.BB = BB;
		this.BC = BC;
	}

	@Override
	public void update(Keyboard keyboard) {
		
		CollisionCheck();
		//move();
	}

	@Override
	public void draw(Graphics2D graphics) {
	/*	int i = 0;
		i++;
		
		if(i <= 20) {
			graphics.setColor(Color.MAGENTA);
		}
		if(i>20) {*/
			graphics.setColor(Color.RED);
		
		graphics.fillOval(getX(), getY(), getWidth(), getHeight());
		
	}
	
	public void CollisionCheck() {
		
		Rectangle DpBox = new Rectangle(getX(),getY(),getWidth(),getHeight());
		Rectangle BatBox = new Rectangle(BB.getX(),BB.getY(),BB.getWidth(),BB.getHeight());
		
		if(DpBox.intersects(BatBox)) {
			BC.setPowerstate(PowerState.DuoblePoints);
		}
		if(getY() >= 600) {
			
		}
		
	}
	public void move() {	
		setY(getY() + 2);	
	}

}
