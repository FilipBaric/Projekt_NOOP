package pckg.View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.drmilk.nbawrapper.domain.utils.scoreboard.GameDetails;
import pckg.Model.TableModel;

public class GamesTable extends JPanel{
	
	private JTable table;
	private TableModel model;
	private String day,month,year;
	
	private GameStatistics gameStatistic;
	
	private JTextField txtField;
	private JLabel label1;
	private JButton search;
	
	public GamesTable(String day, String month, String year) {
		this.day = day;
		this.month = month;
		this.year = year;
		model = new TableModel(day,month,year);
		table = new JTable(model);
	    setLayout(new BorderLayout());
	    Dimension dims = this.getPreferredSize();
	    dims.width = 680;
	    dims.height = 480;
	    this.setPreferredSize(dims);
	    setBorders();
	    init();
	    layoutComps();
	    table.setBounds(14,30,650,250);
	    add(table);
	    activate();
	}
	
	public void setTableData(List<GameDetails> list) {
		model.setTableModel(list);
	}	
    public void refreshTable(){
        model.fireTableDataChanged();
    }
    
    private void init() {
    	txtField = new JTextField();
    	search = new JButton("Search");
    	label1 = new JLabel("Enter game ID:");
    }
    
    private void layoutComps() {
    	setLayout(null);
    	
    	search.setBounds(580, 420, 89, 23);
    	txtField.setBounds(420, 420, 150,20);
    	label1.setBounds(400, 420, 100, 100);
    	add(search);
    	add(label1);
    	add(txtField);
    }
    private void setBorders(){
        Border inner = BorderFactory.createTitledBorder("Games");
        Border outer = BorderFactory.createEmptyBorder(10,7,10,10);
        Border fnlBr = BorderFactory.createCompoundBorder(outer, inner);
        setBorder(fnlBr);
    }
    
    private void activate() {
    	
    	search.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				gameStatistic = new GameStatistics(day, month, year, txtField.getText());
				gameStatistic.resultsInit();	
			}
		});
    	
    }
    
}