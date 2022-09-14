package pckg.View;

import java.awt.Dimension;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import com.drmilk.nbawrapper.domain.Player;
import com.drmilk.nbawrapper.domain.Team;
import com.drmilk.nbawrapper.domain.utils.player.Latest;
import com.drmilk.nbawrapper.domain.utils.player.Stats;
import com.drmilk.nbawrapper.exception.PlayerNotFoundException;
import com.drmilk.nbawrapper.exception.TeamNotFoundException;


public class PlayerStats extends JPanel implements Results{

	public String playerName;
	
	private Player player;
	private Team team;
	private Stats stats;
	private Latest latest;
	private URL url;
	private Image image;
	
	private JLabel name, surname, country, position, college, height, weight, dateOfBirth, playerTeam, ppg, apg , rpg, fg, wl, headshot;
	
	public PlayerStats() {
		Dimension dim = getPreferredSize();
		dim.width = 575;
		dim.height = 375;
		setPreferredSize(dim);
		setBorders();
		init();
		layoutComps();
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	/**
	 * PlayerStats verzija results istoimenog interface služi za ispisivanje i prikazivanje statistike igraèa na JPanel
	 */
	
	@Override
	public void results() {
		try {
			player = Player.getPlayerByNameKeywords(playerName);
			team = Team.getTeamById(player.getTeamId());
			stats = player.getStats();
			latest = stats.getLatest();
			displayImage(player);
			name.setText(player.getFirstName());
			surname.setText(player.getLastName());
			country.setText(player.getCountry());
			playerTeam.setText(team.getFullName());
			position.setText(player.getPosition());
			college.setText(player.getCollegeName());
			height.setText(player.getHeightMeters() + " meters");
			weight.setText(player.getWeightKilograms() + " kg");
			dateOfBirth.setText(player.getDateOfBirthUTC());
			ppg.setText("Points per game: " + latest.getPpg());
			apg.setText("Assists per game: " + latest.getApg());
			rpg.setText("Rebounds per game: " + latest.getRpg());
			fg.setText("Field goals: " + latest.getFga());
			wl.setText("Games player: " + latest.getGamesPlayed());
		} catch (PlayerNotFoundException e) {
			System.out.println("Player not found");
		} catch (TeamNotFoundException e) {
			System.out.println("Team not found");
		}
	}
	
	 private void setBorders(){
	        Border inner = BorderFactory.createTitledBorder("Player Statistic");
	        Border outer = BorderFactory.createEmptyBorder(10,10,10,7);
	        Border fnlBr = BorderFactory.createCompoundBorder(outer, inner);
	        setBorder(fnlBr);
	    }
	 
	 private void init() {	
		 headshot = new JLabel();
		 name = new JLabel();
		 surname = new JLabel();
		 position = new JLabel();
		 country = new JLabel();
		 college = new JLabel();
		 weight = new JLabel();
		 height = new JLabel();
		 dateOfBirth = new JLabel();
		 playerTeam = new JLabel();
		 ppg = new JLabel();
		 apg = new JLabel();
		 rpg = new JLabel();
		 fg = new JLabel();
		 wl = new JLabel();
	 }
	 
	 private void layoutComps() {
		 setLayout(null);
		 
		 name.setBounds(45, 35, 100, 50);
		 add(name);
		 
		 surname.setBounds(100, 35, 100, 50);
		 add(surname);
		 
		 country.setBounds(45, 65, 50, 50);
		 add(country);
		 
		 playerTeam.setBounds(45,95,300,50);
		 add(playerTeam);
		 
		 position.setBounds(45, 125,100,50);
		 add(position);
		 
		 college.setBounds(45, 155, 150, 50);
		 add(college);
		 
		 height.setBounds(45, 185, 100,50);
		 add(height);
		 
		 weight.setBounds(45, 215,100,50);
		 add(weight);
		 
		 dateOfBirth.setBounds(45, 245, 100, 50);
		 add(dateOfBirth);
		 
		 ppg.setBounds(195, 35, 200, 50);
		 add(ppg);
		 
		 apg.setBounds(195, 65, 200, 50);
		 add(apg);
		 
		 rpg.setBounds(195, 95, 200, 50);
		 add(rpg);
		 
		 fg.setBounds(195, 125, 200, 50);
		 add(fg);
		 
		 wl.setBounds(195, 155, 200, 50);
		 add(wl);
		 
		 headshot.setBounds(300, 70, 270, 250);
		 add(headshot);
		 
	 }
	 
	 /**
	  * Klasa koja prikaže sliku uzetu s URL-a, kao ulazni parametar uzima objekt klase Player
	  * 
	  * @param player
	  */

	 private void displayImage(Player player) {
		 try {
			url = new URL(player.getHeadshotUrl());
			image = ImageIO.read(url);
			headshot.setIcon(new ImageIcon(image));
		} catch (MalformedURLException e) {
			System.out.println("Malformed URL!");
		} catch (IOException e2) {
			System.out.println("Can not load image!");
		}
	 }
}