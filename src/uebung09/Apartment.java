package uebung09;

public interface Apartment {
	 
    /**
     * Der Ferienwohnung wird ein Belegungszeitraum hinzugefügt; die angegebenen
     * Datumsangaben sind der Anreise- bzw. Abreisetag. Es ist möglich, dass an
     * einem Tag jemand (morgens) abreist und ein Nachfolger (mittags) anreist.
     * 
     * Wird versucht, die Wohnung für einen Zeitraum zu belegen, in dem es bereits 
     * eine Belegung gibt, wird eine GDIException ausgelöst.
     */
    void addOccupation(Date fromIncluded, Date toIncluded);
 
    /**
     * Die Methode liefert genau dann true, wenn die Ferienwohnung im angegebenen
     * Zeitraum (Anreise- bis Abreisetag) verfügbar ist, sonst false.
     */
    boolean isAvailable(Date fromIncluded, Date toIncluded);
 
    /**
     * Liefert einen String mit dem Namen und der Beschreibung zur Wohnung.
     */
    String toString();
 
    /**
     * Liefert das erste Datum, an dem die Ferienwohnung zum ersten Mal nach dem
     * angegebenen Datum belegt ist. Gibt es keinen solchen Termin mehr, wird der
     * 31. Dezember geliefert (es ist keine Reservierung über die Jahresgrenze möglich!).
     */
    Date firstOccupiedDayAfter(Date firstDay);
 
    /**
     * Liefert den Namen der Ferienwohnung.
     */
    String getName();
     
    /**
     * Liefert eine kurze Beschreibung der Fereinwohnung.
     */
    String getDescription();
 
}