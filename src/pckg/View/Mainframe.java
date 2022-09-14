package pckg.View;

import javax.swing.*;

import pckg.Controller.Controller;


public class Mainframe extends JFrame {

	private PlayerPanel playerPanel;
	private ScorePanel scorePanel;
	private Statistics stats;
	private JTabbedPane tabs;
	private GamesFrame gamesFrame;
	
	private JLabel label_player;
	private JLabel label_games;
	
	public Mainframe() {
		super("NBA App");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		initPanels();
		initTabs();
		activateMainFrame();
	}
	
	private void initPanels() {
		tabs = new JTabbedPane();
		label_player = new JLabel("Find Players");
		label_games = new JLabel("Find Games");
		playerPanel = new PlayerPanel();
		scorePanel = new ScorePanel();
	}
	
	private void initTabs() {
		playerPanel.add(label_player);
		scorePanel.add(label_games);
		
		tabs.add("Find players", playerPanel);
		tabs.add("Find games", scorePanel);
		add(tabs);
	}

	
	private void activateMainFrame() {
		
		playerPanel.setPlayerPanelListener(new PanelListener() {
			
			@Override
			public void playerPanelEventOccured(PlayerPanelEvent ppe) {
				 stats = new Statistics();
				 stats.update(ppe.getPlayerName());
				 stats.resultInit();			 
			}
			
		});
		
		scorePanel.setListener(new ScorePanelListener() {
			
			@Override
			public void scorePanelEventOccured(ScorePanelEvent spe) {
				gamesFrame = new GamesFrame(spe.getDay(), spe.getMonth(), spe.getYear());
				
			}
		});
	}
}