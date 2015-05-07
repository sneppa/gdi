package uebung09;
import static gdi.MakeItSimple.*;

public class MatcherImplementation implements Matcher{

	public static void main(String[] args) {
		MatcherImplementation matcher = new MatcherImplementation();
		Apartment[] apartments = matcher.readApartments("apartments.txt");
		
		// hier muss die Abfrage des gewünschten Zeitraums und 
		// der gewünschten Übernachtungen erfolgen
		Date firstDay, lastDay;
		int day, month, amountDays;
		println("Bitte geben sie den Tag des Anfangsdatums an:");
		day = readInt(); readLine();
		println("Bitte geben sie den Monat des Anfangsdatums an:");
		month = readInt(); readLine();
		firstDay = new Date(day, month);
		println("Bitte geben sie den Tag des Enddatums an:");
		day = readInt(); readLine();
		println("Bitte geben sie den Monat des Enddatums an:");
		month = readInt(); readLine();
		lastDay = new Date(day, month);
		println("Bitte geben sie die gewünschte Dauer des Besuchs an:");
		amountDays = readInt();
		
		Match[] matches = matcher.determineAvailableApartments(apartments,firstDay,lastDay,amountDays);
		for (int i = 0; i < matches.length; i++)
			println(matches[i].toString());
	}

	@Override
	public Apartment[] readApartments(String filename) {
		Object file = openInputFile(filename);
		String name, description;
		int[] date = new int[4];
		int amount = readInt(file); readLine(file);
		println(amount);
		int amountDates;
		Apartment[] apartments = new Apartment[amount];
		
		for(int i = 0; i < amount; i++) {
			name = readLine(file);	//Initialize apartment
			description = readLine(file);
			apartments[i] = new ApartmentImplementation(name, description);
			
			//Initialize reservations for apartment
			amountDates = readInt(file); readLine(file);
			for(int k = 0; k < amountDates; k++) {
				date[0] = readInt(file); date[1] = readInt(file);
				readChar(file);
				date[2] = readInt(file); date[3] = readInt(file);
				if(!isEndOfInputFile(file))
					readLine(file);
				apartments[i].addOccupation(new Date(date[0],date[1]), new Date(date[2],date[3]));
			}
		}
		closeInputFile(file);
		return apartments;
	}

	@Override
	public Match[] determineAvailableApartments(Apartment[] apartments,
			Date firstPossibleArrivalDay, Date lastPossibleDepartureDay,
			int numberOfNights) {
		
		//Get every apartment and every possible time frame for occupation. Put matches into matchList.
		MyLinkedList matchList = new MyLinkedList();
		Date startDay = new Date(1,1);
		Date endDay = new Date(1,1);
		for(Apartment apartment : apartments) {
			startDay.setDate(firstPossibleArrivalDay.getDay(), firstPossibleArrivalDay.getMonth());
			endDay.setDate(firstPossibleArrivalDay.getDay(), firstPossibleArrivalDay.getMonth());
			endDay.addDays(numberOfNights);
			while(endDay.isBefore(lastPossibleDepartureDay)) {
				if(apartment.isAvailable(startDay, endDay))
					matchList.addLast(new ListNode(new Match(apartment,new Date(startDay.getDay(),startDay.getMonth())), null));
				startDay.addDays(1);
				endDay.addDays(1);
			}
		}
		
		Match[] matchArray = new Match[matchList.size()];
		for(int i = 0; i < matchList.size(); i++)
			matchArray[i] = (Match) matchList.getAt(i).getContent();
		
		return matchArray;
	}

}
