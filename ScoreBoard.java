import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class ScoreBoard extends Sprite {

	private int score = 0;
	
	public ScoreBoard(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	public void update(Keyboard keyboard) {
		
		
	}

	@Override
	public void draw(Graphics2D graphics) {
		
		graphics.setColor(Color.CYAN);
		graphics.setFont(new Font("Coslolas",Font.PLAIN, 25));
		graphics.drawString("Score : " + score,30 ,55);
		
	}
	
	public int getScore() {
	//	System.out.println("get" +score);
		return this.score;

	}
	public void setScore(int score) {
		this.score = score;
	//	System.out.println("set"+score);
	}

}
