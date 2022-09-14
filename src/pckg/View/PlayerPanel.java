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


public class PlayerPanel extends JPanel{

	private JTextField txtField;
	private JButton submit;
	private JLabel label;
	private PanelListener listener;
	
	public PlayerPanel() {
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
	        Border inner = BorderFactory.createTitledBorder("Search Player");
	        Border outer = BorderFactory.createEmptyBorder(10,10,10,7);
	        Border fnlBr = BorderFactory.createCompoundBorder(outer, inner);
	        setBorder(fnlBr);
	    }
	 
	 private void initComps() {
		 txtField = new JTextField(10);
		 submit = new JButton("Search");
		 label = new JLabel("Enter player name: ");
	 }
	
	 private void layoutComps() {
		setLayout(null);
		
		txtField.setBounds(130, 121, 200, 20);
		submit.setBounds(70, 170, 89, 23);
		label.setBounds(18,121,200,20);
		
		add(txtField);
		add(label);
		
		add(submit);
	 }
	 
	 
	 public void setPlayerPanelListener(PanelListener listener) {
		 this.listener = listener;
	 }
	 
	 private void activate() {

		 submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String playerName = txtField.getText();
				PlayerPanelEvent ppe = new PlayerPanelEvent(this, playerName);
				ppe.setPlayerName(playerName);
				if (listener != null) {
					listener.playerPanelEventOccured(ppe);
				}
			}
		});
		 
	 }
}
