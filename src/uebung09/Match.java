package uebung09;

public class Match {

	private Apartment apartment;
	private Date date;

	Match(Apartment apartment, Date date) {
		this.apartment = apartment;
		this.date = date;
	}
	
	@Override
	public String toString() {
		return apartment + "\n  frei ab: " + date;
	}

	Apartment getApartment() {
		return apartment;
	}

	Date getDate() {
		return date;
	}

}
