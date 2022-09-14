package pckg.View;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Statistics extends JFrame{

	private PlayerStats playerStats;
	public String playerName;
	
	public Statistics() {
		super("Player Stats");
		setSize(1000, 1000);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		initPanels();
		layoutPanels();
	}
	
	private void initPanels() {
		playerStats = new PlayerStats();
	}
	
	private void layoutPanels() {
		setLayout(new BorderLayout());
		add(playerStats, BorderLayout.WEST);
	}		
	
	public void update(String playername) {
		playerStats.setPlayerName(playername);
	}
	
	public void resultInit() {
		playerStats.results();
	}
}