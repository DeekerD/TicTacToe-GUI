package gui;

import java.util.Random;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TicTacToe extends JFrame implements ActionListener{
	Font btnFont;
	Color bgColor, fgColor,winColor, panelColor;
	boolean isplayerOne;
	int scoreX, scoreO;
	JLabel playerXscore;
	JLabel playerOscore;
	JLabel playerX, playerO;
	JLabel title2;
	JButton exit, reset;
	
	Random rd = new Random();
	
	String[] plays;
	JButton[] buttons;
	
	private JButton createButton() {
		JButton btn = new JButton();
		btn.setText("");
		btn.setFont(btnFont);
		btn.setBackground(bgColor);
		btn.setForeground(fgColor);
		btn.addActionListener(this);
		btn.setFocusable(false);
		
		return btn;
	}
	
	
	//Constructor
	public TicTacToe() {
		btnFont = new Font("Ink Free", Font.ITALIC, 55);
		isplayerOne = rd.nextBoolean();
		
		
//		String path = "C:\Users\hp\Downloads\adam-winger-6G17JP-b9kk-unsplash";
		
		plays = new String[9];
		buttons = new JButton[9];
		
		bgColor = Color.black;
		fgColor = Color.YELLOW;
		winColor = Color.gray;
		panelColor = Color.black;
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3,3));
		add(panel, BorderLayout.CENTER);
		
		for(int i = 0; i < 9; i++) {
			JButton btn = createButton();
			btn.setActionCommand(String.valueOf(i));
			panel.add(btn);
			
			buttons[i] = btn;
		}
		
		JPanel scorePanel = new JPanel();
		scorePanel.setBackground(panelColor);
		add(scorePanel, BorderLayout.SOUTH);
		
		scorePanel.setLayout(new GridLayout(3,2));
		
		
		
	    playerX = new JLabel(acceptName("PlayerX"));
		playerX.setFont(btnFont);
		playerX.setBackground(bgColor);
		playerX.setForeground(fgColor);
		playerX.setHorizontalAlignment(JLabel.CENTER);
		
		playerO = new JLabel(acceptName("PlayerO"));
		
			while ((playerX.getText().equalsIgnoreCase(playerO.getText()))) {
				JOptionPane.showMessageDialog(null, 
						"You cannot have the same name with playerX");
				playerO = new JLabel(acceptName("PlayerO"));
			}
		playerO.setFont(btnFont);
		playerO.setBackground(bgColor);
		playerO.setForeground(fgColor);
		playerO.setHorizontalAlignment(JLabel.CENTER);
		
		 playerXscore = new JLabel("0");
		playerXscore.setFont(btnFont);
		playerXscore.setBackground(bgColor);
		playerXscore.setForeground(fgColor);
		playerXscore.setHorizontalAlignment(JLabel.CENTER);
		
		 playerOscore = new JLabel("0");
		playerOscore.setFont(btnFont);
		playerOscore.setBackground(bgColor);
		playerOscore.setForeground(fgColor);
		playerOscore.setHorizontalAlignment(JLabel.CENTER);
		
		exit = createButton();
		exit.setText("Exit");
		
		
		reset = createButton();
		reset.setText("Restart");
		reset.addActionListener(this);
		
		scorePanel.add(playerX);
		scorePanel.add(playerXscore);
		scorePanel.add(playerO);
		scorePanel.add(playerOscore);
		scorePanel.add(reset);
		scorePanel.add(exit);
		
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(panelColor);
		titlePanel.setLayout(new GridLayout(2, 1));
		add(titlePanel, BorderLayout.NORTH);
		
		JPanel titlePanel1 = new JPanel();
		titlePanel1.setBackground(panelColor);
		
		JLabel title = new JLabel("Tic Tac Toe");
		titlePanel1.add(title);
		title.setFont(btnFont);
		title.setBackground(bgColor);
		title.setForeground(fgColor);
		title.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				title.setFont(new Font("Ink Free", Font.ITALIC, 75));
				title.setForeground(Color.orange);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				title.setFont(btnFont);
				title.setForeground(fgColor);
			}
			
		});
		
		JPanel titlePanel2 = new JPanel();
		titlePanel2.setBackground(panelColor);
		if(isplayerOne) {
			title2 = new JLabel("X Turn");
		}else {
			title2 = new JLabel("O Turn");
		}
		 
		titlePanel2.add(title2);
		title2.setFont(btnFont);
		title2.setBackground(bgColor);
		title2.setForeground(fgColor);
		
		
		titlePanel.add(titlePanel1);
		titlePanel.add(titlePanel2);
		
		
		//Frame properties
		
		addWindowListener(new BackMainMenu());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Tic Tac Toe");
		setVisible(true);
		setSize(750,750);
		getContentPane().setBackground(Color.blue);
		setLocationRelativeTo(null);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton btn = (JButton)e.getSource();
		int index = Integer.parseInt(e.getActionCommand());
		
		  if(e.getSource() == exit) {
			   int option = JOptionPane.showConfirmDialog(null,"Sure to Exit ?", "Exit Game",
					   JOptionPane.YES_NO_CANCEL_OPTION
					   );
			   if(option == JOptionPane.YES_OPTION) {
				  System.exit(0);
			   }
				   
		   }
		  
		  else if(e.getSource() == reset){
			 
						int result = JOptionPane.showConfirmDialog(null, "Sure to restart?",
							"Confirmation Message",JOptionPane.YES_NO_OPTION);
						
						if(result == 0) {
						String nplayerX =	acceptName("PlayerX");
							
							
					     String nplayerO = acceptName("PlayerO");
							
							while ((nplayerX.equalsIgnoreCase(nplayerO))) {
								JOptionPane.showMessageDialog(null, 
										"You cannot have the same name with playerX");
								nplayerO = acceptName("PlayerO");
							}
							
							
							playerX.setText(nplayerX);
							playerO.setText(nplayerO);
							playerXscore.setText("0");
							playerOscore.setText("0");
							reset();
						}
						
						
				
		  }
		
		  else if(btn.getText().equals("")) {
			String played;
			
			if(isplayerOne) {
				btn.setForeground(Color.white);
				played = "X";
				title2.setText("O turn");
				
			}else {
				btn.setForeground(Color.red);
				played = "O";
				title2.setText("X turn");
				
			}
			btn.setText(played);
			plays[index] = played;
			
			isplayerOne = !isplayerOne;
			checkWin(played);
			
			boolean vacant = false;
			for(String str: plays) {
				if(str == null)
					vacant = true;
			}
			
			if(vacant == false) {
				JOptionPane.showMessageDialog(this,"No Winner\nPlay Again");
				reset();
			}
		}
	}
	
	public static void main(String[] args) {
		new TicTacToe();
	}
	
	void checkWin(String text) {
		int[][] winningPositions = {
				{0,1,2}, {3,4,5}, {6,7,8},
				{6,3,0}, {7,4,1}, {5,8,2},
				{0,4,8}, {2,4,6} 
		};
		
		for(int[] arr : winningPositions) {
			int first = arr[0];
			int second = arr[1];
			int third = arr[2];
			
			if(plays[first] == null ||
					plays[second] == null ||
					plays[third] == null) {
				continue;
			}
			
			if(plays[first].equals(text) && plays[second].equals(text)
					&& plays[third].equals(text)) {
				buttons[first].setBackground(winColor);
				buttons[second].setBackground(winColor);
				buttons[third].setBackground(winColor);
				if(text.equals("X")) {
					JOptionPane.showMessageDialog(this, "X win");
					scoreX++;
					System.out.println(scoreX);
					playerXscore.setText(String.valueOf(scoreX));
					
				}
				else {
					JOptionPane.showMessageDialog(this, "O win");
					scoreO++;
					System.out.println(scoreO);
					playerOscore.setText(String.valueOf(scoreO));
				}
				
				reset();
				break;
			}
		}
	}
	
	private String acceptName(String text) {
		String name = JOptionPane.showInputDialog(null, " "+ text+ "\nEnter your name");
		
		while (name == null || name.isEmpty() || name.isBlank() ) {
			name = JOptionPane.showInputDialog(null, " "+ text+ "\nEnter your name");
		}
		return name;
		
	}
	
	void reset() {
		for(int i = 0; i < buttons.length; i++) {
			plays[i] = null;
			buttons[i].setText("");
			buttons[i].setBackground(bgColor);
		}
	}

}
