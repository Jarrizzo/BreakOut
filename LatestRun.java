import javax.swing.DefaultListModel;

public class LatestRun {
	
	ScoreBoard scoreBoard;
	
	private DefaultListModel <String> LRList;
	
	public LatestRun(ScoreBoard scoreBoard) {
		this. scoreBoard = scoreBoard;
		
		LRList = new DefaultListModel <String> ();
		LRList.addElement("Latest Run");
	}
	public void addScore () {
		
		if(LRList.size() < 4) {
			LRList.add(1,Integer.toString(scoreBoard.getScore()));
		}
		else {
			LRList.remove(3);
			LRList.add(1,Integer.toString(scoreBoard.getScore()));
		}
	}
	
	public DefaultListModel <String> getLRList() {
		
		return LRList;
		
	}
	
}
