import java.awt.*;
import java.util.*;

public class DoublePointsObject {

	BallBat BB;
	BrickCollection BC;
	
	ArrayList<DoublePointsPower> DPP = new ArrayList<>();
	
	public DoublePointsObject(BallBat BB, BrickCollection BC) {
		this.BB = BB;
		this.BC = BC;
	}
	
	public void update(Keyboard keyboard) {
		
		CollisionCheck();
		move();

	}


	public void draw(Graphics2D graphics) {

		for(DoublePointsPower P: DPP) {
			graphics.setColor(Color.MAGENTA);
			graphics.fillOval(P.getX(), P.getY(), P.getWidth(), P.getHeight());
		}
		
	}
	
	public void CollisionCheck() {
		
		for(DoublePointsPower P: DPP) {
			Rectangle DpBox = new Rectangle(P.getX(),P.getY(),P.getWidth(),P.getHeight());
			Rectangle BatBox = new Rectangle(BB.getX(),BB.getY(),BB.getWidth(),BB.getHeight());
		
			if(DpBox.intersects(BatBox)) {
				BC.setPowerstate(PowerState.DuoblePoints);
			}
			if(P.getY() >= 800) {
				DPP.remove(P);
				break;
			}		
		}
		
	}
	public void move() {
		
		for(DoublePointsPower P: DPP) {
			P.setY(P.getY() + 2);	
		}
	}
	
	public void createBPObject() {
		
		Random rand = new Random();
		int Xpos = rand.nextInt(580);
		DPP.add( new DoublePointsPower( 10+Xpos, 100, 5, 5));
	}
	
}
