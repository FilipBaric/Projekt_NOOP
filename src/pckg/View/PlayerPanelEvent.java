package pckg.View;

import java.util.EventObject;

public class PlayerPanelEvent extends EventObject{

	private String playerName;

	public PlayerPanelEvent(Object source, String playerName) {
		super(source);
		this.playerName = playerName;
	}
	
	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
}
