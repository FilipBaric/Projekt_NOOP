package pckg.View;

import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import pckg.Model.TableModel;


public class ScorePanel extends JPanel{

	private JButton submit;
	private JTextField day, month, year;
	private ScorePanelListener listener;
	
	public ScorePanel() {
		
		Dimension dim = getPreferredSize();
		dim.width = 380;
		dim.height = 380;
		setPreferredSize(dim);
		setBorders();
		initComps();
		layoutComps();
		activate();
	}
	
	 private void setBorders(){
	        Border inner = BorderFactory.createTitledBorder("Search Games");
	        Border outer = BorderFactory.createEmptyBorder(10,7,10,10);
	        Border fnlBr = BorderFactory.createCompoundBorder(outer, inner);
	        setBorder(fnlBr);
	    }
	 
	 private void initComps() {

		 submit = new JButton("Search");
		 day = new JTextField();
		 month = new JTextField();
		 year = new JTextField();
	 }
	 
	 private void layoutComps() {
		 setLayout(null);
		 
		 JLabel dayLabel = new JLabel("Day");
		 JLabel monthLabel = new JLabel("Month");
		 JLabel yearLabel = new JLabel("Year");
		 
		 submit.setBounds(70, 170, 89, 23);
		 day.setBounds(90, 121, 50, 20);
		 dayLabel.setBounds(90, 102, 50, 20);
		 month.setBounds(150,121,50,20);
		 monthLabel.setBounds(150, 102,50,20);
		 year.setBounds(210,121,70,20);
		 yearLabel.setBounds(210, 102, 50, 20);
		 
		 add(submit);
		 add(day);
		 add(dayLabel);
		 add(month);
		 add(monthLabel);
		 add(year);
		 add(yearLabel);
	 }

	 public void setListener(ScorePanelListener listener) {
		this.listener = listener;
	}

	private void activate() {
		 
		 submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String varDay = day.getText();
				String varMonth = month.getText();
				String varYear = year.getText();
				
				ScorePanelEvent spe = new ScorePanelEvent(this, varDay, varMonth, varYear);
				
				spe.setDay(varDay);
				spe.setMonth(varMonth);
				spe.setYear(varYear);
				
				if (listener != null) {
					listener.scorePanelEventOccured(spe);
				}
			}
		});
	 }
	 
}
