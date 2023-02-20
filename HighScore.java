import javax.swing.DefaultListModel;

public class HighScore {
	
	ScoreBoard scoreBoard;
	private DefaultListModel <String> HSList;
	
	public HighScore(ScoreBoard scoreBoard) {
		this.scoreBoard = scoreBoard;
		
		HSList = new DefaultListModel <String> ();
		HSList.addElement("HighScore");
	}
	
	public void addScore() {
		
		if(HSList.size() < 11) {
			HSList.addElement(Integer.toString(scoreBoard.getScore()));
		}
		else {
			HSList.remove(10);
			HSList.addElement(Integer.toString(scoreBoard.getScore()));

		}
		
	}
	
	public DefaultListModel <String> getHSList() {
		
		return HSList;
		
	}
	
}
