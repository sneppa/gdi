package uebung06;

/**
 * TShirtVersand implementiert ein Management Tool für einen Webshop, welcher Kunden und Bestellungen verwalten soll. 'Kunden' und 'Bestellungen' sind abstrakte Datentypen, deren Felder mit diversen Zugriffsmethoden abgerufen oder modifiziert werden.
 * @author Mike Hukiewitz & Martin Weber
 *
 */
public interface TShirtVersand {
	
	final static String LIEFERART[] = {"Standardversand","Expressversand","Overnightversand"};
	
	/**
	 * Erstellt einen neuen Kundendatensatz. Jeder neue Datensatz wird mit einer fortlaufenden ID versehen. 
	 * @param name Der Name des Kunden.
	 * @param adresse Die Adresse in Form: "POSTLEITZAHL;STADT;STRAßE;HAUSNUMMER"
	 * @param eMail Die E-Mail Adresse des Kunden.
	 * @param bankverbindung Bankverbindung des Kunden in Form: "BLZ;KONTONUMMER"
	 * @return Gibt den neu erstellten Kundendatensatz zurück.
	 * @see kundeNachID
	 */
	Kunde neuerKunde(String name, String adresse, String eMail, String bankverbindung);
	
	/**
	 * Loggt eine neue Bestellung in einen Datensatz. Gespeichert werden noch das aktuelle Datum, eine fortlaufende BestellungsID, der Preis der sich aus den bestellten Artikeln berechnet und der aktuelle Status der Sendung (verschickt/nicht verschickt).
	 * @param empfaenger Der Kundendatensatz in dem alle Versandinformationen stehen.
	 * @param warenID Ein Array mit allen bestellten Waren in Form ihrer WarenIDs. Sind bestimmte Artikel mehrfach bestellt worden, so tauchen sie auch mehrfach im Array auf.
	 * @param lieferart 0 = Standardversand, 1 = Expressversand, 2 = Overnightversand
	 * @return Gibt den neu erstellten Bestellungsdatensatz zurück.
	 * @see bestellungNachID
	 */
	Bestellung neueBestellung(Kunde empfaenger, int[] warenID, int lieferart);
	
	/**
	 * Gibt das zur ID korrespondierende Kunden-Objekt zurück.
	 * @param id ID des Kundendatensatzes.
	 * @return Das Kunden-Objekt.
	 */
	Kunde kundeNachID(int id);
	
	/**
	 * Gibt das zur ID korrespondierende Bestellung-Objekt zurück.
	 * @param id ID des Bestellungsdatensatzes.
	 * @return Das Bestellung-Objekt
	 */
	Bestellung bestellungNachID(int id);
	
	/**
	 * Meldet dem System, dass die angegebene Bestellung verschickt wurde.
	 * @param bestellung Die betreffende Bestellung.
	 */
	void bestellungVersenden(Bestellung bestellung);
	
	/**
	 * Storniert eine Bestellung soweit sie noch nicht abgeschickt wurde.
	 * @param bestellung Der zu stornierende Bestellungsdatensatz.
	 * @throws BestellungNichtVorhandenEXCPT Falls eine ungültige Bestellung angegeben wurde.
	 * @throws BestellungVersandEXCPT Falls die Bestellung bereits versandt wurde.
	 */
	void stornieren(Bestellung bestellung);
	
	/**
	 * Öffnet eine neue Lastschrift an die vom Kunden angegebene Bankverbindung.
	 * @param bestellung Die Bestellung deren ausstehender Betrag beglichen werden soll.
	 * @throws BestellungNichtVorhandenEXCPT Falls eine ungültige Bestellung angegeben wurde.
	 */
	void rechnungBegleichen(Bestellung bestellung);
	
	/**
	 * Wenn ein Kunde Gebrauch von seinem Widerrufsrecht macht, wird die betreffende Bestellung entsprechend gekennzeichnet und alle Mittel in die Wege geleitet um das Geld wieder zurück zu überweisen.
	 * @param bestellung Die betreffende Bestellung
	 * @throws BestellungNichtVorhandenEXCPT Falls eine ungültige Bestellung angegeben wurde.
	 */
	void widerruf(Bestellung bestellung);
	

}
