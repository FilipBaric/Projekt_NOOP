package pckg.Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

import com.drmilk.nbawrapper.domain.League;
import com.drmilk.nbawrapper.domain.utils.player.Internal;
import com.drmilk.nbawrapper.domain.utils.scoreboard.GameDetails;
import com.drmilk.nbawrapper.domain.utils.scoreboard.Scoreboard;
import com.drmilk.nbawrapper.exception.ScoreboardNotFoundException;

import pckg.Controller.Controller;

/**
 * Ova klasa se koristi kako bi se napravio model tablice.
 * 
 * @author filip
 *
 */

public class TableModel extends AbstractTableModel{

	String[] colNames = {"Game ID"};
	private List<GameDetails> list;
	
	public TableModel(String day, String month, String  year) {
		try {
			Scoreboard score = League.getScoreboard(day,month,year);
			list = score.getGames();
		} catch (ScoreboardNotFoundException e) {
			System.out.println("No games found on that date!");
		}
		
	}

	public void setTableModel(List<GameDetails> list) {
		this.list = list;
	}

	@Override
	public String getColumnName(int column) {
	    return colNames[column];
	}
	
	@Override
	public int getRowCount() {
		return list.size();
	}


	@Override
	public int getColumnCount() {
		return colNames.length;
	}


	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {		
		GameDetails gameDetail = list.get(rowIndex);
		switch (columnIndex) {
		case 0: return gameDetail.getGameId();
		}
		return null;
	}
}
