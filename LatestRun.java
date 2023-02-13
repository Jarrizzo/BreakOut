import javax.swing.DefaultListModel;

public class LatestRun {
	
	ScoreBoard scoreBoard;
	private DefaultListModel <String> LRList;
	
	public LatestRun(ScoreBoard scoreBoard) {
		
		LRList = new DefaultListModel <String> ();
		LRList.addElement("Latest Run");
	}
	
	public void addScore () {
		
		LRList.addElement(Integer.toString(scoreBoard.getScore()));
		
	}
	
	public DefaultListModel <String> getLRList() {
		
		return LRList;
		
	}
	
}
