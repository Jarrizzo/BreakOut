import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Scenes {

	ScoreBoard scoreBoard;
	TopWall topWall;
	
	public Scenes(ScoreBoard scoreBoard) {
		this.scoreBoard = scoreBoard;
	}
	
	public void WIN(Graphics graphics) {
		
		graphics.setColor(Color.RED);
		graphics.setFont(new Font("Coslolas",Font.PLAIN, 100));
		graphics.drawString("Victory",200 ,350);
		graphics.setFont(new Font("Coslolas",Font.PLAIN, 40));
		graphics.drawString("Your Score: " + scoreBoard.getScore(),265 ,400);
		graphics.setFont(new Font("Coslolas",Font.PLAIN, 10));
		graphics.drawString("(Press Enter to Play again)",330 ,420);
		
	}
	
	public void LOOSE(Graphics graphics) {
		
		graphics.setColor(Color.RED);
		graphics.setFont(new Font("Coslolas",Font.PLAIN, 100));
		graphics.drawString("Game Over",140 ,350);
		graphics.setFont(new Font("Coslolas",Font.PLAIN, 40));
		graphics.drawString("Your Score: " + scoreBoard.getScore(),265 ,400);
		graphics.setFont(new Font("Coslolas",Font.PLAIN, 10));
		graphics.drawString("(Press Enter to Play again)",330 ,420);
		
	}
	
	public void PAUSE(Graphics graphics) {
		
		graphics.setColor(Color.RED);
		graphics.setFont(new Font("Coslolas",Font.PLAIN, 50));
		graphics.drawString("Press Space to play",150 ,300);
		
	}
	
}
