import java.awt.Color;
import java.awt.Graphics2D;

public class Brick extends Sprite{

	public Color color;
	
	public Brick(int x, int y, int width, int height, Color color) {
		super(x, y, width, height);
		this.color = color;
	}



	@Override
	public void update(Keyboard keyboard) {
		
	}

	@Override
	public void draw(Graphics2D graphics) {
		
	}

}
