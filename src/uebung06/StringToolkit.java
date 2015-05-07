package uebung06;

public interface StringToolkit {
	
	/**
	 * Diese Funktion akzeptiert einen String original als Parameter und liefert 
	 * einen neuen String als Ergebnis, in dem alle Buchstaben des ursprünglichen 
	 * Strings in Großbuchstaben umgewandelt enthalten sind. 
	 * Gewandelt werden die Buchstaben a bis z und die Umlaute ä, ö und ü. 
	 * Beispiel: "Viel Erfolg bei der Aufgabe!" wird umgewandelt in 
	 * "VIEL ERFOLG BEI DER AUFGABE!".
	 */
	String toUpper(String original);
	
	/**
	 * Diese Funktion durchsucht den String-Parameter original nach einem Teil-String 
	 * search und gibt dessen Position innerhalb von original zurückgeben 
	 * (0 gilt dabei als erste Position). 
	 * Falls search nicht auffindbar ist, wird -1 zurückgegeben. 
	 * Sollte der String mehr als einmal innerhalb von original vorkommen, 
	 * wird die Position des ersten Treffers zurückgeliefert. 
	 * Beispiel: In "Hello, world! This world is cool!" soll das Wort "world" 
	 * aufgespürt werden; Ergebnis ist die Position 7.
	 * @return Position des ersten Treffers oder -1, falls nicht vorhanden
	 */
	int indexOf(String original, String search);

}