package pckg.View;

import java.awt.BorderLayout;
import javax.swing.JFrame;

import pckg.Model.TableModel;

public class GamesFrame extends JFrame{
	
	private GamesTable table;
	private String day,month,year;
	
	public GamesFrame(String day, String month, String year) {
		super("Listed Games for that date");
		this.day = day;
		this.month = month;
		this.year = year;
		setSize(700, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		initPanels();
		layoutPanels();
	}

	private void initPanels() {
		table = new GamesTable(day, month, year);
	}

	private void layoutPanels() {
		setLayout(new BorderLayout());
		add(table, BorderLayout.CENTER);
	}
}