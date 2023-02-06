import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

public class BrickCollection {
	Ball ball;
	ScoreBoard score;
	Game game;
	PowerState powerState;
	DoublePointsObject DPO;

	ArrayList <Brick> BC = new ArrayList<>();
	Random rand = new Random();

	
	public BrickCollection (Ball ball,ScoreBoard score,Game game) {
		this.ball = ball;
		this.score = score;
		this.game = game;
		BrickCreation();

	}
	
	
	public void update (Keyboard keyboard) {
		checkCollision();
		checkIsEmpty();
		
		}
		
	
	public void draw(Graphics graphics) {
		
		for(Brick b: BC) {
			graphics.setColor(b.color);
			graphics.fillRect(b.getX(), b.getY(), b.getWidth(), b.getHeight());
		}
		
	}
	
	private void BrickCreation() {
		
		Random rand = new Random();
		
		for(int i = 0; i < C.NumberOfBricks; i++) {
			
			int colorPick = rand.nextInt(3);
			int x =15 + i % 14 * 55;
			int y = 100 + i / 14 * 25;
			
			if(colorPick == 0)
			BC.add( new Brick(x, y, C.BrickWidth, C.BrickHeight, Color.RED));
			if( colorPick == 1)
			BC.add( new Brick(x, y,C.BrickWidth,  C.BrickHeight, Color.WHITE));
			if( colorPick == 2)
			BC.add( new Brick(x, y, C.BrickWidth,  C.BrickHeight, Color.BLUE));
		}	
		
	}
	private void checkCollision() {
		
		for(Brick B: BC) {
			Rectangle ballbox = new Rectangle(ball.getX(),ball.getY(),ball.getWidth(),ball.getHeight());
			Rectangle brickbox = new Rectangle(B.getX(),B.getY(),B.getWidth(),B.getHeight());
			
			int PowerUpChance = rand.nextInt(1);
			
			if(brickbox.intersects(ballbox)) {
				
				ball.setYSpeed(-(ball.getYSpeed())); 
				if(B.color == Color.BLUE) {
					score.setScore(score.getScore()+10);
					if(powerState == PowerState.DuoblePoints) {
						score.setScore(score.getScore()+10);
					}
					if(PowerUpChance == 0){
					//	DPO.createBPObject();
					}
					B.color = Color.WHITE;
				}	
				else if(B.color == Color.WHITE) {
					score.setScore(score.getScore()+20);
					if(powerState == PowerState.DuoblePoints) {
						score.setScore(score.getScore()+20);
					}
					if(PowerUpChance == 0){
					//	DPO.createBPObject();
					}
					B.color = Color.RED; 
				}	
				else if(B.color == Color.RED ) {
					score.setScore(score.getScore()+30);
					if(powerState == PowerState.DuoblePoints) {
						score.setScore(score.getScore()+30);
					}
					if(PowerUpChance == 0 ) {
					//	DPO.createBPObject();
					}
					BC.remove(B);
					break;
				}
			}	
		}
	}
	
	private void checkIsEmpty() {
		
		if(BC.isEmpty()) {
			game.setGamestate(GameState.WIN);
		}
		
	}
	public PowerState getPowerstate() {
		return this.powerState;
	}
	public void setPowerstate(PowerState powerState) {
		this.powerState = powerState;
	}	
}
