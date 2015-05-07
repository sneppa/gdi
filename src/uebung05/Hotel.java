package uebung05;

/**
 * Das Interface 'Hotel' stellt alle Funktionalitäten zur Verfügung um Buchungs- und Bezahlvorgänge abzuwickeln
 * und um den Überblick über ausstehende Rechnungen und gebuchte Zimmer zu behalten.
 * @author Mike Hukiewitz u. Martin Weber
 *
 */
public interface Hotel {
	
	/**
	 * Trägt eine Buchung in die Buchungsdatenbank ein.
	 * @param zimmer Das Zimmer welches gebucht werden soll (Format: SSZZ | S = Stock, Z = Zimmer).
	 * @param datumVon Anreisedatum des Besuchers (Format: YYYYMMDD)
	 * @param datumBis Abreisedatum des Besuchers (Format: YYYYMMDD)
	 * @param name Der Name des Gastes der dieses Zimmer zahlt.
	 * @return Gibt true zurück falls erfolgreich, false wenn nicht (Zimmer nonexistent/Zimmer bereits belegt)
	 */
	boolean buchen(int zimmer, int datumVon, int datumBis, String name);
	
	/**
	 * Storniert sofort eine Buchung. Falls mehrere einzelne Buchungen innerhalb des Zeitraumes liegen werden alle storniert. 
	 * @param zimmer Betreffendes Zimmer (Format: SSZZ | S = Stock, Z = Zimmer).
	 * @param datumVon Anreisedatum des Besuchers (Format: YYYYMMDD)
	 * @param datumBis Abreisedatum des Besuchers (Format: YYYYMMDD)
	 */
	void stornieren(int zimmer, int datumVon, int datumBis);
	
	/**
	 * Gibt zurück, ob das betreffende Zimmer innerhalb des gesamten Zeitraums frei ist.
	 * @param zimmer Betreffende Zimmernummer (Format: SSZZ | S = Stock, Z = Zimmer).
	 * @param datumVon Anreisedatum des Besuchers (Format: YYYYMMDD)
	 * @param datumBis Abreisedatum des Besuchers (Format: YYYYMMDD)
	 * @return true wenn das Zimmer frei ist.
	 */
	boolean istFrei(int zimmer, int datumVon, int datumBis);
	
	/**
	 * Kalkuliert den Preis einer Buchung basierend auf Zimmernummer und Zeitraum der Buchung.
	 * @param zimmer Betreffendes Zimmer (Format: SSZZ | S = Stock, Z = Zimmer).
	 * @param datumVon Anreisedatum des Besuchers (Format: YYYYMMDD)
	 * @param datumBis Abreisedatum des Besuchers (Format: YYYYMMDD)
	 * @return Der Preis der Buchung in Euro.
	 */
	int preisKalkulieren(int zimmer, int datumVon, int datumBis);
	
	/**
	 * Gibt die Summer aller ausstehenden Beträge eines Gastes aus.
	 * @param name Der Name der Person, auf welche die Rechnungen laufen.
	 * @return Die Summe der ausstehenden Beträge in Euro.
	 */
	int ausstehenderBetrag(String name);
	
	/**
	 * Lässt einen Gast einen Betrag einzahlen um ausstehende Rechnungen zu begleichen. 
	 * @param name Der Name des Gastes auf den die Rechnungen laufen.
	 * @param betrag Der Betrag der eingezahlt wurde in Euro.
	 * @return Gibt zurück wie viel noch bezahlt werden muss. Ist diese Zahl negativ muss noch an den Gast zurückgezahlt werden.
	 */
	int rechnungBegleichen(String name, int betrag);

}
