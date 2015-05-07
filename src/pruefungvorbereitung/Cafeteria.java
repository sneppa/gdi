
package pruefungvorbereitung;

public interface Cafeteria 
{
    // Aufgabe 3
    
    public void bezahlen(Karte kundenKarte);
    
    public Karte registrieren(String vorname, String nachname);
    
    public void aufladen(Karte kundenKarte, int betrag);
    
    public float betragAbfragen(Karte kundenKarte);
    
    public float zurueckGeben(Karte kundenKarte);
}
