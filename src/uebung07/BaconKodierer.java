package uebung07;

public interface BaconKodierer {
	
	/**
	 * Die Methode liefert einen String, in dem alle Zeichen der Nachricht, die keine 
	 * Buchstaben sind (also auch Leerzeichen und Satzzeichen) entfernt sowie alle 
	 * Kleinbuchstaben in Großbuchstaben umgewandelt und deutsche Sonderzeichen 
	 * (Ä, Ö, Ü, ß) entsprechend (durch AE, OE, UE, SS) ersetzt wurden.
	 * @throws GDIException falls der Parameter null ist
	 */
	String reinigeNachricht(String nachricht);
	
	/**
	 * Die Methode liefert einen String, der eine zuvor gereinigte Nachricht gemäß dem 
	 * Binärcode aus der Tabelle von Übungsblatt 7 kodiert.
	 * @throws GDIException falls der Parameter nicht kodierbare Zeichen bzw. 
	 * Nicht-Buchstaben enthält oder null ist
	 */
	String kodiereNachricht(String gereinigteNachricht);
	
	/**
	 * Die Methode erhält eine nach dem Muster der Methode #kodiereNachricht()
	 * kodierte Nachricht und liefert die ursprüngliche Nachricht zurück.
	 * Für unbekannte 5er-Blöcke wird das Zeichen '#' in das Ergebnis eingesetzt.
	 * Für die doppeldeutigen Codes I/J  und U/V wird jeweils der erste Buchstabe 
	 * in das Ergebnis eingesetzt.
	 * Ist die Länge des Binärcodes nicht durch 5 teilbar, werden die Zeichen des
	 * unvollständigen 5er-Blocks am Ende stillschweigend ignoriert.
	 * @throws GDIException falls der Parameter null ist
	 */
	String dekodiereNachricht(String binaerCode);
	
	/**
	 * Die Methode liefert einen String, in dem die angegebene Nachricht in
	 * dem ebenfalls angegebenen Trägermedium versteckt ist. Die ursprüngliche 
	 * Groß- und Kleinschreibung des genutzten Anteils des Trägermediums geht 
	 * dabei verloren, aber Leerzeichen und Satzzeichen (bzw. alle 
	 * Nicht-Buchstaben) des Trägermediums sowie das "ß" bleiben erhalten. 
	 * Nicht-Buchstaben des Trägermediums werden beim Chiffrieren übersprungen,
	 * die Chiffrierung durch Änderung der Groß- und Kleinschreibung wird beim 
	 * nächsten Buchstaben fortgeführt.
	 * @throws GDIException falls das Trägermedium zu kurz ist und der Binärcode 
	 * nicht vollständig in ihm untergebracht werden kann oder falls einer der
	 * Parameter null ist
	 */
	String versteckeNachricht(String nachricht, String traegerMedium);
	
	/**
	 * Die Methode analysiert die Groß- und Kleinschreibung des angegebenen 
	 * Steganogramms und liefert die darin kodierte Nachricht zurück.
	 * @throws GDIException falls der Parameter null ist
	 */
	String zeigeNachricht(String steganogramm);

}
