package uebung09;

import java.util.GregorianCalendar;

public class Date {
	
	public static final int YEAR;
	static {
		int currentYear = new GregorianCalendar().get(GregorianCalendar.YEAR);
		int currentMonth = new GregorianCalendar().get(GregorianCalendar.MONTH) + 1;
		if (currentMonth < 3)
			YEAR = currentYear;
		else
			YEAR = currentYear + 1;
	}
	
	private int day, month;
	
	Date(int day, int month) {
		this.day = day;
		this.month = month;
	}

	Date(Date existing) {
		this.day = existing.getDay();
		this.month = existing.getMonth();
	}
	
	void setDate(int day, int month) {
		this.day = day;
		this.month = month;
	}

	void addDays(int increment) {
		GregorianCalendar help = new GregorianCalendar(YEAR, month - 1, day);
		help.add(GregorianCalendar.DAY_OF_MONTH, increment);
		month = help.get(GregorianCalendar.MONTH) + 1;
		day = help.get(GregorianCalendar.DAY_OF_MONTH);
	}

	boolean isBefore(Date other) {
		GregorianCalendar thisDate = new GregorianCalendar(YEAR, month - 1, day);
		GregorianCalendar otherDate = new GregorianCalendar(YEAR, other.month - 1, other.day);
		return thisDate.before(otherDate);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Date other = (Date) obj;
		if (day != other.day)
			return false;
		if (month != other.month)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return day + "." + month + "." + YEAR;
	}

	int getDay() {
		return day;
	}

	int getMonth() {
		return month;
	}

}