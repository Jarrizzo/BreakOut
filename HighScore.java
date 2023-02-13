import javax.swing.DefaultListModel;

public class HighScore {
	
	ScoreBoard scoreBoard;
	private DefaultListModel <String> HSList;
	
	public HighScore(ScoreBoard scoreBoard) {
		HSList = new DefaultListModel <String> ();
		HSList.addElement("HighScore");
	}
	
	public void addScore() {
		
		HSList.addElement(Integer.toString(scoreBoard.getScore()));
		
	}
	
	public DefaultListModel <String> getHSList() {
		
		return HSList;
		
	}
	
}
