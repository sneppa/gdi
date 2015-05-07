package uebung06;
import static gdi.MakeItSimple.*;

/**
 * StringToolkitImpl implementiert das Interface StringToolkit.
 * Kann einen String in Großbuchstaben umwandeln mit toUpper().
 * Kann einen Index eines String in einem String finden mit indexOf().
 */
public class StringToolkitImpl implements StringToolkit
{
    public int currentIndex = 0;
    public int charCount = 0;
    public int returnIndex = 0;
    
    public static void main(String args[])
    {
        StringToolkitImpl StringToolkitObj = new StringToolkitImpl();
        
        println("toUpper() Test:");
        println(StringToolkitObj.toUpper("dasisteinkleinerstring"));
        println(StringToolkitObj.toUpper("DASISTEINUPPERCASESTRING"));
        println(StringToolkitObj.toUpper("DasIstEinGemischterString"));
        println(StringToolkitObj.toUpper("UmlauteSindsährTollüberdemÖtztal"));
        println(StringToolkitObj.toUpper("String mit Leerzeichen"));
        
        println("indexOf() Test:");
        println("IndexOf(dasisthallsopallohshallo, hallo)"+StringToolkitObj.indexOf("dasisthallsopallohshallo", "hallo"));
        println("IndexOf(dasisthallsopallohshallo, Hallo)"+StringToolkitObj.indexOf("dasisthallsopallohshallo", "Hallo"));
        println("IndexOf(dasisthallsopallohshallo, das)"+StringToolkitObj.indexOf("dasisthallsopallohshallo", "das"));
        println("IndexOf(dasisthallsopallohshallo, opall)"+StringToolkitObj.indexOf("dasisthallsopallohshallo", "opall"));
        println("IndexOf(dasisthallsopallohshallo, h)"+StringToolkitObj.indexOf("dasisthallsopallohshallo", "h"));
    }
    
    public String toUpper(String original) 
    {
        // Nehme erstes Zeichen von String
        char letter = original.charAt(0);

        // a-z zu A-Z
        if(letter >= 'a' && letter <= 'z') {
            letter = (char) (letter - 'a' + 'A');
        }
        
        // ä-ü zu Ä-Ü
        if(letter >= 'ä' && letter <= 'ü') {
            letter = (char) (letter - 'ä' + 'Ä');
        }

        if(original.length() > 1) 
        {	
            // Weitere Zeichen vorhanden, reksursiv weiterverarbeiten ohne den ersten Char
            return letter + toUpper(original.substring(1, original.length()));
        }
        else
        {
            // LetztesZeichen oder nur ein Zeichen -> Rückgabe
            return (letter + "");
        }
    }
    
    public int indexOf(String original, String search)
    {
        currentIndex = 0;
        returnIndex = 0;
        charCount = 0;
        return indexOfRecursive(original, search);
    }
    
    /**
     * Hilfunktion für indexOf(), sollte nicht direkt aufgerufen werden, 
     * sondern nur indexOf(), da die Startwerte gesetzt werden muessen
     */
    public int indexOfRecursive(String original, String search)
    {
        if (currentIndex < original.length())
        {
            if (original.charAt(currentIndex) == search.charAt(charCount))
            {
                // Zeichen = Suchzeichen
                if (charCount == 0) // Index speichern, an dem der String beginnt
                    returnIndex = currentIndex;
                
                charCount++;
            }
            else if (returnIndex > 0)
            {
                // Zurücksetzen des return Index und dem charCounter, da String nicht mehr gleich
                returnIndex = 0;
                charCount = 0;
            }
            
            // Suchstring komplett, return Index
            if (charCount == search.length())
                return returnIndex;
            else
            {
                // Suchstring noch nicht komplett, also weiter
                currentIndex++;
                return indexOfRecursive(original, search);
            }
        }
        else
        {
            // String zuende -> nicht gefunden
            return -1;
        }
    }
}
