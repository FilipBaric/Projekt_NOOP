package pckg.View;

import java.util.EventObject;

public class ScorePanelEvent extends EventObject{

	private String day, month, year;
	
	public ScorePanelEvent(Object source, String day, String month, String year) {
		super(source);
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
}
