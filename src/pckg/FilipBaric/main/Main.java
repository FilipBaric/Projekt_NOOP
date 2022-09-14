package pckg.FilipBaric.main;

import javax.swing.SwingUtilities;

import pckg.View.Mainframe;

public class Main {
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new Mainframe();
			}
		});
	}

}
