package uebung08;

public interface Labyrinth {
	
	static final char ENTRANCE_CHAR = 'E';
	static final char WALL_CHAR = '#';
	static final char WAY_CHAR = '·';
	static final char EMPTY = ' ';
	
	/**
	 * Die Methode liest ein Labyrinth aus der angegebenen Datei.
	 * Alls Labyrinthe sind rechteckig (alle Zeilen sind gleich lang),
	 * Wände sind mit einem WALL_CHAR gekennzeichnet, Wege dazwischen
	 * mit EMPTY. Der Eingang zum Labyrinth ist mit einem
	 * ENTRANCE_CHAR gekennzeichnet.
	 * Die weiteren Methoden des Interface' beziehen sich auf das 
	 * zuvor gelesene Labyrinth.
	 * Die Methode löst in allen Fehlerfällen eine MISException aus,
	 * siehe Übungsblatt.
	 */
	void readFromFile(String filename);
	
	/**
	 * Die Methode liefert die Anzahl von Zeilen im Labyrinth.
	 */
	int numberOfRows();
	
	/**
	 * Die Methode liefert die Anzahl von Spalten im Labyrinth.
	 */
	int numberOfColumns();
	
	/**
	 * Die Methode liefert diejenige Position am Rand des Labyrinths,
	 * die durch ein 'E' als Eingang gekennzeichnet ist.
	 * Die Methode löst eine MISException aus, wenn es nicht genau 
	 * einen Startpunkt im Labyrinth gibt.
	 */
	Position entrancePosition();
	
	/**
	 * Die Methode liefert diejenige Position am Rand des Labyrinths,
	 * die die durch einen Weg vom Eingang aus erreichbar ist. Wenn
	 * es mehrere Wege zu mehreren Ausgängen gibt, wird ein beliebiger
	 * dieser Ausgänge geliefert.
	 */
	Position exitPosition();
	
	/**
	 * Die Methode sucht ausgehend vom Startpunkt einen Weg durch
	 * das zuvor eingelesene Labyrinth. Wird ein Weg gefunden, dann wird 
	 * er ausgehend vom Startpunkt mit WAY_CHARs markiert; auch der
	 * ENTRANCE_CHAR wird ersetzt. Gibt es keinen Weg, wirft die Methode 
	 * eine MISException.
	 */
	void findWay();
	
	/**
	 * Die Methode liefert einen String, der das Labyrinth im augenblicklichen
	 * Zustand, d.h. so wie es geladen wurde oder (nach einem Aufruf von
	 * findWay) mit den markierten Wegen, enthält. Für den Ausdruck
	 * kann dieser String mittels eines einzelnen 'println'-Aufrufs auf der 
	 * Konsole ausgegeben werden.
	 */
	String toString();

}