import java.awt.*;
import java.util.*;

public class PowerUp {

	BallBat BB;
	BrickCollection BC;
	
	ArrayList<DoublePoints> DPP = new ArrayList<>();
	Random rand = new Random();

	
	public PowerUp(BallBat BB, BrickCollection BC) {
		this.BB = BB;
		this.BC = BC;
	}
	
	public void update(Keyboard keyboard) {
		
		CollisionCheck();
		move();
/*		if(BC.checkCollisioon == true) {
			
			System.out.println("Hej");
			
			if(rand.nextInt(2) == 1) {
				createBPObject();
			}
		}
*/		
	}


	public void draw(Graphics2D graphics) {

		for(DoublePoints P: DPP) {
			graphics.setColor(Color.MAGENTA);
			graphics.fillOval(P.getX(), P.getY(), P.getWidth(), P.getHeight());
		}
		
	}
	
	private void CollisionCheck() {
		
		for(DoublePoints P: DPP) {
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
	private void move() {
		
		for(DoublePoints P: DPP) {
			P.setY(P.getY() + 2);	
		}
	}
	
	private void createBPObject() {
		
		int Xpos = rand.nextInt(580);
		DPP.add( new DoublePoints( 10+Xpos, 100, 5, 5));
	}
	
}
