import java.awt.*;

public class Life extends Sprite{
	private int Life = C.NumberOfLifes;
	Game game;

	public Life(int x, int y, int width, int height, Game game) {
		super(x, y, width, height);
		this.game = game;
	}

	@Override
	public void update(Keyboard keyboard) {

		if(Life == 0) {
			game.setGamestate(GameState.LOST);
		}
		
	}

	@Override
	public void draw(Graphics2D graphics) {
		
		graphics.setColor(Color.CYAN);
		graphics.setFont(new Font("Coslolas",Font.PLAIN, 25));
		graphics.drawString("Lifes : " + Life,680 ,55);
		
	}
	
	public int getLifes() {
		return Life;
	}
	public void setLifes(int Life) {
		this.Life = Life;
	}


}
