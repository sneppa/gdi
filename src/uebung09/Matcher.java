package uebung09;

public interface Matcher {

	/**
	 * Liest eine Reihe von Ferienwohnungen zusammen mit ihren Belegungen aus der
	 * angegebenen Datei. Das Format der Datei ist wie folgt:
	 * eine ganze Zahl, alleine in einer Zeile stehend: Anzahl der Appartments, die folgen
	 *   ein String, abgeschlossen mit dem Zeilenende: Name eines Appartments
	 *   ein String, abgeschlossen mit dem Zeilenende: Beschreibung eines Appartments
	 *   eine ganze Zahl, alleine in einer Zeile stehend: Anzahl der Belegungszeiträume, die folgen
	 *     Datumsangabe von-bis im Format <Tag> <Monat>-<Tag> <Monat>: Belegungszeitraum
	 */
	Apartment[] readApartments(String filename);

	/**
	 * Die Methode bestimmt diejenigen Ferienwohnungen, die im angegebenen Zeitraum für
	 * die gewünschte Anzahl von Übernachtungen zur Verfügung stehen. Diese Ferienwohnungen
	 * werden in einem passend dimensionierten Array als Ergebnis geliefert. Für jeden
	 * freien Zeitraum jeder Ferienwohnung wird nur der erste mögliche Anreisetag geliefert.
	 */
	Match[] determineAvailableApartments(Apartment[] apartments, Date firstPossibleArrivalDay, Date lastPossibleDepartureDay, int numberOfNights);

}
