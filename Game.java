import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Game {
	
	GameState gamestate;
	Ball ball;
	BrickCollection BC;
	BallBat BB;
	TopWall topWall;
	Life life;
	ScoreBoard scoreBoard;
	PowerState powerState;
	PowerUp DPO;
	WinAndLooseScreen WALS;
	
	public Game(GameBoard board) {

		GameStart();
	
	}
	

	public void update(Keyboard keyboard) {
		
		if(BC.getPowerstate() == PowerState.DrawPowerUP || BC.getPowerstate() == PowerState.DuoblePoints) {
			DPO.update(keyboard);
		}
		
		life.update(keyboard);
		if(keyboard.isKeyDown(Key.Space)) {
			gamestate = GameState.PLAY;
		}	

		if(gamestate == GameState.PLAY) {
			ball.update(keyboard);
			BC.update(keyboard);
			BB.update(keyboard);

		}
		if(gamestate == GameState.ROUNDLOSS) {
			GameReStart();
		}
		if(gamestate == GameState.LOST && keyboard.isKeyDown(Key.Enter) || gamestate == GameState.WIN && keyboard.isKeyDown(Key.Enter)) {
			GameStart();
		}		
		
	}

	public void draw(Graphics2D graphics) {
		
		if(BC.getPowerstate() == PowerState.DrawPowerUP || BC.getPowerstate() == PowerState.DuoblePoints) {
			DPO.draw(graphics);
		}

		if(gamestate == GameState.LOST) {
			WALS.LOOSE(graphics);
		}
		if(gamestate == GameState.WIN) {
			WALS.WIN(graphics);
		}
		
		ball.draw(graphics);
		BC.draw(graphics);
		BB.draw(graphics);
		topWall.draw(graphics);
		life.draw(graphics);
		scoreBoard.draw(graphics);
		
	}
	
	private void GameStart() {
	
		gamestate = GameState.START;
		topWall = new TopWall(0, 0, 0, 0);
		ball = new Ball(C.BallStartX, C.BallStartY, C.BallSize, C.BallSize, this);
		BB = new BallBat(C.BatStartX, C.BatStartY, ball);
		scoreBoard = new ScoreBoard(0, 0, 0, 0);
		BC = new BrickCollection(ball,scoreBoard,this);
		life = new Life(0, 0, 0, 0, this);
		DPO = new PowerUp(BB, BC);
		WALS = new WinAndLooseScreen(scoreBoard);
	
		
	}
	public void GameReStart() {
		
		gamestate = GameState.PAUSE;
		BB.setX(C.BatStartX);
		ball.setX(C.BallStartX);
		ball.setY(C.BallStartY);
		life.setLifes(life.getLifes()-1);
	}
	
	public GameState getGamestate() {
		return this.gamestate;
	}
	public void setGamestate(GameState gamestate) {
		this.gamestate = gamestate;
	}
	
}
