import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.*;

public class Program extends JFrame {
	GameBoard board;
	private JPanel ScorePanel;
	private JList HSList;
	private JList LRList;
	HighScore highScore;
	LatestRun latestRun;
	
	public Program() {
		
		board = new GameBoard();
		add(board);
		setSize(950,600);
		setResizable(false);
		
		JPanel scorePanel = new JPanel();
		add(scorePanel, BorderLayout.EAST);
		scorePanel.setLayout(new GridLayout(2,1));
		
		JList LRList = new JList(board.getGame().latestRun.getLRList());
		LRList.setFocusable(false);
		LRList.setPreferredSize(new Dimension (115,300));
		LRList.setBackground(Color.BLACK);
		LRList.setForeground(Color.WHITE);
		LRList.setFont(new Font("Coslolas",Font.PLAIN, 19));
		setResizable(false);
		
		JList HSList = new JList(board.getGame().highScore.getHSList());
		HSList.setFocusable(false);
		HSList.setPreferredSize(new Dimension (115,300));
		HSList.setBackground(Color.BLACK);
		HSList.setForeground(Color.WHITE);
		HSList.setFont(new Font("Coslolas",Font.PLAIN, 19));
		setResizable(false);
		
		scorePanel.add(LRList);
		scorePanel.add(HSList);
		
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		board.start();
	}
	
	@Override
	protected void processKeyEvent(KeyEvent e) {
		super.processKeyEvent(e);
		board.processKeyEvent(e);
	}

	public static void main(String[] args) {
		Program program = new Program();
	}

}
