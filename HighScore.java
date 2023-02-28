import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class HighScore {
	
	ScoreBoard scoreBoard;
	private DefaultListModel <String> HSList;
	
	public HighScore(ScoreBoard scoreBoard) {
		this.scoreBoard = scoreBoard;
		
		HSList = new DefaultListModel <String> ();
		HSList.addElement("HighScore");
	}
	
	public void addScore() {
		
		if(scoreBoard.getScore() > HSList.lastIndexOf(HSList)) {
			if(scoreBoard.getScore() > 0 && HSList.size() < 11) {
				HSList.addElement(Initials()+ " - " + Integer.toString(scoreBoard.getScore()));
				sort();
			}
			else {
			
				HSList.remove(10);
				HSList.addElement(Initials()+ " - " + Integer.toString(scoreBoard.getScore()));
				sort();
			}
		}
	}
	
	public DefaultListModel <String> getHSList() {
		
		return HSList;
		
	}
	
	public void sort() {
			
		List < String > list = new ArrayList();
		
		HSList.remove(0);
		
		for(int i = 0; i < HSList.size(); i++) {
			list.add((String)HSList.getElementAt(i));
		}
			
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return extractInt(o1) - extractInt(o2);
			}

			private int extractInt(String s) {
				
				String num = s.replaceAll("\\D", "");
				
				return num.isEmpty() ? 0 : Integer.parseInt(num);
			}
		});
		
		Collections.reverse(list);
		HSList.removeAllElements();
		
		HSList.addElement("HighScore");
		for(String s: list ) {
			HSList.addElement(s);
		}	
	}
	
	public String Initials() {
		String Init = "----";
		
		while(Init.length() > 2) {
			Init = JOptionPane.showInputDialog("Write your initials - (XX)").toUpperCase();
		
			char [] chars = Init.toCharArray();
			for(char C : chars) {
				if(Character.isDigit(C)) {
					Init = "----";
				}
			}
		}	
		
		return Init;
	}
	
}
