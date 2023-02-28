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
	Scenes scene;
	HighScore highScore;
	LatestRun latestRun;
	
	public Game(GameBoard board) {

		GameStart();
	
	}
	

	public void update(Keyboard keyboard) {
		
		life.update(keyboard);
		if(gamestate == GameState.ROUNDLOSS && keyboard.isKeyDown(Key.Space) || gamestate == GameState.PAUSE && keyboard.isKeyDown(Key.Space) || gamestate == GameState.START && keyboard.isKeyDown(Key.Space)) {
			gamestate = GameState.PLAY;
		}	

		if(gamestate == GameState.PLAY) {
			ball.update(keyboard);
			BC.update(keyboard);
			BB.update(keyboard);
		}
		if(gamestate == GameState.ROUNDLOSS) {
			RoundReStart();
		}

		if(gamestate == GameState.LOST && keyboard.isKeyDown(Key.Space) || gamestate == GameState.WIN && keyboard.isKeyDown(Key.Enter)) {
			latestRun.addScore();
			highScore.addScore();
			GameReStart();
		}	
		
	}

	public void draw(Graphics2D graphics) {
		
		if(gamestate == GameState.LOST) {
			topWall.draw(graphics);
			life.draw(graphics);
			scoreBoard.draw(graphics);
			scene.LOOSE(graphics);
			ball.draw(graphics);
			BC.draw(graphics);
			BB.draw(graphics);
		}
		if(gamestate == GameState.WIN) {
			scene.WIN(graphics);
			topWall.draw(graphics);
			life.draw(graphics);
			scoreBoard.draw(graphics);
			ball.draw(graphics);
			BC.draw(graphics);
			BB.draw(graphics);
		}
		if(gamestate == GameState.PAUSE || gamestate == GameState.START) {
			scene.PAUSE(graphics);
			topWall.draw(graphics);
			life.draw(graphics);
			scoreBoard.draw(graphics);
			ball.draw(graphics);
			BC.draw(graphics);
			BB.draw(graphics);
		}
		
		if(gamestate == GameState.PLAY) {
		ball.draw(graphics);
		BC.draw(graphics);
		BB.draw(graphics);
		topWall.draw(graphics);
		life.draw(graphics);
		scoreBoard.draw(graphics);
		}

	}
	
	private void GameStart() {
	
		gamestate = GameState.START;
		topWall = new TopWall(0, 0, 0, 0);
		ball = new Ball(C.BallStartX, C.BallStartY, C.BallSize, C.BallSize, this);
		BB = new BallBat(C.BatStartX, C.BatStartY, ball);
		scoreBoard = new ScoreBoard(0, 0, 0, 0);
		BC = new BrickCollection(ball,scoreBoard,this);
		life = new Life(0, 0, 0, 0, this);
		scene = new Scenes(scoreBoard);
		highScore = new HighScore(scoreBoard);
		latestRun = new LatestRun(scoreBoard);
	
	}
	public void RoundReStart() {
		
		gamestate = GameState.PAUSE;
		BB.setX(C.BatStartX);
		ball.setX(C.BallStartX);
		ball.setY(C.BallStartY);
		life.setLifes(life.getLifes()-1);
	}
	public void GameReStart() {
		
		gamestate = GameState.START;
		ball = new Ball(C.BallStartX, C.BallStartY, C.BallSize, C.BallSize, this);
		BB = new BallBat(C.BatStartX, C.BatStartY, ball);
		scoreBoard.setScore(0);
		BC = new BrickCollection(ball,scoreBoard,this);
		life.setLifes(C.NumberOfLifes);
		
	}
	
	public GameState getGamestate() {
		return this.gamestate;
	}
	public void setGamestate(GameState gamestate) {
		this.gamestate = gamestate;
	}
	
}
