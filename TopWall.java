import java.awt.Color;
import java.awt.Graphics2D;

public class TopWall extends Sprite{

	public TopWall(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	public void update(Keyboard keyboard) {
		
	}

	@Override
	public void draw(Graphics2D graphics) {
		
		graphics.setColor(Color.white);
		graphics.fillRect(0, 90, 800, 2);
		graphics.setColor(Color.white);
		graphics.fillRect(798, 0, 2, 600);
		
	}

}
