package pckg.View;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import com.drmilk.nbawrapper.domain.League;
import com.drmilk.nbawrapper.domain.Team;
import com.drmilk.nbawrapper.domain.utils.boxscore.BasicGameData;
import com.drmilk.nbawrapper.domain.utils.boxscore.Boxscore;
import com.drmilk.nbawrapper.domain.utils.boxscore.Stats;
import com.drmilk.nbawrapper.domain.utils.boxscore.TeamInfo;
import com.drmilk.nbawrapper.domain.utils.boxscore.TeamStats;
import com.drmilk.nbawrapper.domain.utils.boxscore.Totals;
import com.drmilk.nbawrapper.exception.BoxscoreNotFoundException;
import com.drmilk.nbawrapper.exception.TeamNotFoundException;

public class GameStats extends JPanel implements Results {

	private String day, month, year, gameID;
	private JLabel hTeam, vTeam, hScore, vScore;
	
	public GameStats(String day, String month, String year, String gameID) {
		Dimension dim = getPreferredSize();
		this.day = day;
		this.month = month;
		this.year = year;
		this.gameID = gameID;
		dim.width = 975;
		dim.height = 675;
		setPreferredSize(dim);
		setBorders();
		init();
		layoutComps();
	}
	
	 private void setBorders(){
	     Border inner = BorderFactory.createTitledBorder("Game Statistic");
	     Border outer = BorderFactory.createEmptyBorder(10,10,10,7);
	     Border fnlBr = BorderFactory.createCompoundBorder(outer, inner);
	     setBorder(fnlBr);
	 }
	 
	 
	 private void init() {
		 hTeam = new JLabel();
		 vTeam = new JLabel();
		 hScore = new JLabel();
		 vScore = new JLabel();
	 }
	 private void layoutComps() {
		 setLayout(null);
		 
		 hTeam.setBounds(50, 100, 200, 100);
		 add(hTeam);
		 
		 vTeam.setBounds(800, 100, 200, 100);
		 add(vTeam);
		 
		 hScore.setBounds(395, 200, 100, 100);
		 add(hScore);
		 
		 vScore.setBounds(465, 200, 100, 100);
		 add(vScore);
	 }

	 /**
	  * Verzija results metode iz istomenog interface-a koja se koristi da se prikažu rezultati na ekran.
	  */
	 
	@Override
	public void results() {
		try {
			Boxscore box = League.getBoxscore(day, month, year, gameID);
			Stats stats = box.getStats();
			BasicGameData bgd = box.getBasicGameData();
			TeamInfo homeTeam = bgd.getHomeTeam();
			TeamInfo visitingTeam = bgd.getVisitingTeam();
			TeamStats visitingTeamStats = stats.getVisitingTeam();
			TeamStats homeTeamStats = stats.getHomeTeam();
			Totals homeTotals = homeTeamStats.getTotals();
			Totals visitingTotals = visitingTeamStats.getTotals();
			Team hoTeam = Team.getTeamById(homeTeam.getTeamId());
			Team visTeam = Team.getTeamById(visitingTeam.getTeamId());
			hTeam.setText(hoTeam.getFullName());
			vTeam.setText(visTeam.getFullName());
			hScore.setText("Points: " + homeTotals.getPoints());
			vScore.setText("/ " + visitingTotals.getPoints());
		} catch (BoxscoreNotFoundException e) {
			e.printStackTrace();
		} catch (TeamNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
