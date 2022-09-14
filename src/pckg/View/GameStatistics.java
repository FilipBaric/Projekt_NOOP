package pckg.View;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class GameStatistics extends JFrame{

	private GameStats gameStats;
	private IndividualStatistics indivStats;
	private JTabbedPane tabs;
	private String day,month,year,gameID;
	
	public GameStatistics(String day, String month, String year, String gameID) {
		super("GameStat");
		this.day = day;
		this.month = month;
		this.year = year;
		this.gameID = gameID;
		setSize(1000, 700);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		initPanels();
		layoutPanels();
	}
	private void initPanels() {
		gameStats= new GameStats(day, month, year, gameID);
		indivStats = new IndividualStatistics();
		tabs = new JTabbedPane();
	}
	
	private void layoutPanels() {
		
		tabs.add("Overall Statistics", gameStats);
		tabs.add("Player Statistics", indivStats);
		add(tabs);
	}	
	
	public void resultsInit() {
		gameStats.results();
	}
}
