import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

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
		
		setY(getY()+2);
		CollisionCheck();
	}

	@Override
	public void draw(Graphics2D graphics) {
		
		
		graphics.setColor(Color.MAGENTA);
		graphics.fillOval(getX(), getY(), getWidth(), getHeight());
	}
	
	public void CollisionCheck() {
		
		Rectangle DpBox = new Rectangle(getX(),getY(),getWidth(),getHeight());
		Rectangle BatBox = new Rectangle(BB.getX(),BB.getY(),BB.getWidth(),BB.getHeight());
		
		if(DpBox.intersects(BatBox)) {
			BC.setPowerstate(PowerState.DuoblePoints);
		}
		
	}

}
