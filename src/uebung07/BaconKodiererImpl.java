package uebung07;
import static gdi.MakeItSimple.*;

import java.util.Locale;

public class BaconKodiererImpl implements BaconKodierer 
{
    //                  A       B       C           D       E       F           G       H       I       J           K       L       M       N           O       P       Q       R           S       T       U       V           W    X          Y       Z        
    String[] codes = {"kkkkk", "kkkkg", "kkkgk", "kkkgg", "kkgkk", "kkgkg", "kkggk","kkggg", "kgkkk", "kgkkk", "kgkkg", "kgkgk", "kgkgg", "kggkk", "kggkg", "kgggk", "kgggg", "gkkkk", "gkkkg", "gkkgk", "gkkgg", "gkkgg", "gkgkk", "gkgkg", "gkggk", "gkggg"};
        
    /**
     * F�hrt das Testprogramm aus.
     */
    public static void main(String args[])
    {
        BaconKodiererImpl kodierer = new BaconKodiererImpl();
        
        boolean exit = false;
        
//        kodierer.bahnhof();
//        kodierer.tests(); exit = true;
        
        while (!exit)
        {
            println("---------------------------------");
            println("-           Hauptmen�           -");
            println("---------------------------------");
            println("- Bitte w�hlen:                 -");
            println("- 1 = Botschaft verstecken      -");
            println("- 2 = Botschaft sichtbar machen -");
            println("- 3 = Demo                      -");
            println("- 4 = Programm beenden          -");
            println("---------------------------------");
            print(  "Ihre Eingabe: ");
            int auswahl = readInt(); readLine();
            
            if (auswahl == 3)
            {
                kodierer.bahnhof();
            }
            else if (auswahl == 2)
            {
                print("Versteckte Botschaft eingeben:\t");
                String botschaft = readLine();
                println("Inhalt: \t\t\t"+kodierer.zeigeNachricht(botschaft));
            }
            else if (auswahl == 1)
            {
                print("Botschaft:\t\t\t");
                String botschaft = readLine();
                print("Medium:\t\t\t\t");
                String medium = readLine();
                println("Inhalt: \t\t\t"+kodierer.versteckeNachricht(botschaft, medium));
            }
            else
            {
                println("Programm beendet");
                exit = true;
            }
        }
    }
    
    
    /**
     * Allgemeine Testmethode
     */
    public void tests()
    {        
        String cleaned = reinigeNachricht("Hallo sehr sch�ne Welt!");
    
        String encoded = kodiereNachricht(cleaned);
        
        String decoded = dekodiereNachricht(encoded);
        
        String versteckteNachricht = versteckeNachricht("Hallo Welt!", "Es ist traurig zu denken, die Natur spricht und keiner h�rt zu.");
        
        String nachricht = zeigeNachricht(versteckteNachricht);
        
        println("String "+cleaned+" enkodiert: "+encoded + " dekodiert: "+decoded);
        
        println("Verstecke \"Hallo Welt!\" im Medium \"Es ist traurig zu denken, die Natur spricht und keiner h�rt zu.\": "+ versteckteNachricht);
    
        println("Nachricht \""+versteckteNachricht+"\" dekodieren: "+nachricht);
        
        nachricht = "MeiN nAme ist jUan saNcHez ViLla-LoboS RamIreZ, ObERstEr meTAllURgE aM Hofe K�Nig karl V. von SpanIen; ICh wURDE 896 vor christuS iN �gyptEn geboreN UNd BIn unsTERbLIcH seIt 846 Vor Christus.";
        println("Testausgabe: "+zeigeNachricht(nachricht));
        
        
        nachricht = "MeiN nAme ist jUan saNcHez ViLla-LoboS RamIreZ, ObERstEr meTAllURgE aM Hofe K�Nig karl V. von SpanIen; ICh wURDE 896 vor christuS iN �gyptEn geboreN UNd BIn unsTERbLIcH seIt 846 Vor christus.";
        println("Testausgabe: "+zeigeNachricht(nachricht));
        
        encoded = "gkkgkgkkkkkkgkkkkgkgkkgkgkkgkkkggkkgkkggkggkkgkkkggkkggkgkggkkkgggkkkkkkgkkkgkkkgkkggkkggggkkkkkkkkkkgkggkkkkgkkkkkkkgggkggkkkkgggkggkgkkgkgkkkkkkkkkk";
        decoded = dekodiereNachricht(encoded);
        println("encoded: "+encoded+" decoded: "+decoded);
    }
    
    
    /**
     * Bahnhofsnachricht Testmethode
     */
    public void bahnhof()
    {
        String nachricht = "Treffen uns um drei Uhr am Bahnhof!";
        String medium = "Mein Name ist Juan Sanchez Villa-Lobos Ramirez, oberster Metallurge am Hofe K�nig Karl V. von Spanien; ich wurde 896 vor Christus in �gypten geboren und bin unsterblich seit 846 vor Christus.";
        
        
        BaconKodiererImpl kodierer = new BaconKodiererImpl();
        
        String versteckteNachricht = kodierer.versteckeNachricht(nachricht, medium);
        
        String decodierteNachricht = kodierer.zeigeNachricht(versteckteNachricht);
        
        println("Ausgangsnachricht:\t"+nachricht);
        println("Medium:\t\t\t"+medium);
        println("Versteckt:\t\t"+ versteckteNachricht);
    
        println("Nachricht:\t\t"+ decodierteNachricht);
    }
    
    
    public String reinigeNachricht(String nachricht) 
    {
        if (nachricht == null)
        {
            throw new gdi.MakeItSimple.GDIException("Bitte Nachricht angeben");
        }
        
        String clean = "";
        
        nachricht = toUpper(nachricht);
        
        // Umlaute ersetzen
        nachricht = nachricht.replace("�", "OE");
        nachricht = nachricht.replace("�", "AE");
        nachricht = nachricht.replace("�", "UE");
        nachricht = nachricht.replace("�", "SS");
        
        // Alles was nicht A-Z ist entfernen
        for (int i = 0; i < nachricht.length(); i++)
        {
            char zeichen = nachricht.charAt(i);
            if (zeichen >= 'A' && zeichen <= 'Z') // A-Z
                clean += zeichen;
        }
        
        return clean;
    }

    
    public String kodiereNachricht(String gereinigteNachricht) 
    {
        if (gereinigteNachricht == null || gereinigteNachricht == "")
        {
            throw new gdi.MakeItSimple.GDIException("Bitte Nachricht angeben");
        }
        
        String encoded = "";
        
        // Nachricht durchlaufen
        for (int i = 0; i < gereinigteNachricht.length(); i++)
        {
            char zeichen = gereinigteNachricht.charAt(i);
            if (zeichen >= 'A' && zeichen <= 'Z') // G�ltiges Zeichen
            {
                encoded += charToCode(zeichen);
            }
            else
            {
                throw new gdi.MakeItSimple.GDIException("Ung�ltige Zeichen vorhanden");
            }
        }
        
        return encoded;
    }
    

    public String dekodiereNachricht(String binaerCode) 
    {
        if (binaerCode == null || binaerCode == "")
        {
            throw new gdi.MakeItSimple.GDIException("Bitte Nachricht angeben");
        }
       
        int durchlaeufe = binaerCode.length()/5; // Durchl�ufe a 5 Paare berechnen
        String decoded = "";
        
        for (int i = 0; i < durchlaeufe; i++)
        {
            String code = "";
            if (binaerCode.length() >= 5)
            {
                // N�chstes 5er P�rchen auslesen
                for (int n = 0; n < 5; n++)
                {
                    code += strHead(binaerCode); // Erstes Zeichen
                    binaerCode = strRest(binaerCode); // Erstes Zeichen abschneiden
                }

                decoded += codeToChar(code); // 5er P�rchen zu char
            }
        }
        
        return decoded;
    }

    
    public String versteckeNachricht(String nachricht, String traegerMedium) 
    {
        if (nachricht == null || traegerMedium == null)
        {
            throw new gdi.MakeItSimple.GDIException("Bitte alle Parameter angeben");
        }
        String traegerMediumLower = toLower(traegerMedium); // LowerCase f�r Dechiffrierung
        String traegerMediumUpper = toUpper(traegerMedium); // UperCase f�r Dechiffrierung
        String cleaned = reinigeNachricht(nachricht);
        String encoded = kodiereNachricht(cleaned);
        
        if (encoded.length() > realeTraegerMediumLaenge(traegerMediumLower))
        {
            throw new gdi.MakeItSimple.GDIException("Tr�germedium nicht lang genug");
        }
        
        String hidden = "";
        int encodedIndex = 0;
        int i = 0;
        
        // Alle Tr�germediumzeichen durchgehen
        while (i < traegerMediumLower.length())
        {
            if (isCodeChar(traegerMediumLower.charAt(i)) && encodedIndex < encoded.length())
            {
                if (encoded.charAt(encodedIndex) == 'k')
                hidden += traegerMediumLower.charAt(i); // Kleinbuchstabe
                else
                hidden += traegerMediumUpper.charAt(i); // Gro�buchstabe

                encodedIndex++;
            }
            else // Zeichen nicht kodierbar oder kodierte Nachricht bereits abgearbeitet
            {
                hidden += traegerMedium.charAt(i);
            }
            i++;
        }
        
        return hidden;
    }

    
    public String zeigeNachricht(String steganogramm) 
    {
        String steganogrammLower = toLower(steganogramm); // Lower Case f�r Codierbarkeit
        String code = "";
        
        // Jeden Buchstaben des Stenogramms durchegehen
        for (int i = 0; i < steganogramm.length(); i++)
        {
            if (isCodeChar(steganogrammLower.charAt(i)))
            {
                if (isCharUpper(steganogramm.charAt(i)))
                    code += "g"; // Gro�buchstabe
                else
                    code += "k"; // Kleinbuchstabe
            }
        }
        
        return dekodiereNachricht(code);
    }
    
    
    /**
     * Wandelt einen char in den 5stelligen Code um
     * @param zeichen A-Z
     * @return String Zeichenkette 5stellig [k|g]
     */
    public String charToCode(char zeichen)
    {
        return codes[zeichen-'A'];
    }
    
    
    /**
     * Wandelt einen 5stelligen Code in einen Char um
     * @param code 5stellig [k|g]
     * @return char Zeichen
     */
    public char codeToChar(String code)
    {
        int i = 0;
        char zeichen = 'A';
        
        // Alle 26 Buchstaben des Alphabets durchgehen
        while (i < 26)
        {
            if (codes[i].equals(code))  // Code gefunden -> zur�ckgeben
            {
                zeichen += i; // A + aktuelles Zeichen
                return zeichen;
            }
            i++;
        }
        
        throw new gdi.MakeItSimple.GDIException("Unbekannter Code"); // Code nicht gefunden
    }
    
    
    /**
     * Gibt die reale L�nge des Tr�germediums aus, es werden nur a-z, �, �, � gez�hlt
     * @param traegerMedium
     * @return integer L�nge
     */
    public int realeTraegerMediumLaenge(String traegerMedium)
    {
        int length = 0;
        
        for (int i = 0; i < traegerMedium.length(); i++)
        {
            if (isCodeChar(traegerMedium.charAt(i)))
                length++;
        }
        
        return length;
    }
    
    
    /**
     * Pr�ft ob das Zeichen zum (de-)kodieren verwendet werden kann
     * @param zeichen: lowercase char
     * @return Zeichen verwendbar zum (de-)kodieren ja/nein
     */
    public boolean isCodeChar(char zeichen)
    {
        if (zeichen >= 'a' && zeichen <= 'z') // Zwischan a-z
            return true;
        else if (zeichen >= '�' && zeichen <= '�') // ist ein Umlaute
            return true;
        
        return false; // Kein codierbares Zeichen
    }
    
    
    /**
     * Pr�ft ob ein Zeichen von a-z,A-Z,�,�,�,�,�,� gro� geschrieben ist, oder klein
     * @param zeichen: a-z,A-Z,�,�,�,�,�,�
     * @return boolean: Gro� geschrieben ja/nein
     * @exception GDIException, wenn es kein Buchstabe a-z,A-Z,�,�,�,�,�,� ist
     */
    public boolean isCharUpper(char zeichen)
    {
        if ((zeichen >= 'a' && zeichen <= 'z') || (zeichen >= '�' && zeichen <= '�')) // ist Kleinbuchstabe
            return false;
        if ((zeichen >= 'A' && zeichen <= 'Z') || (zeichen >= '�' && zeichen <= '�')) // ist Gro�buchstabe
            return true;
    
        throw new gdi.MakeItSimple.GDIException("Nicht zugelassenes Zeichen"); // ist kein kodierbares Zeichen
    }
    
    
    /**
     * Wandelt einen String in Gro�buchstaben um ohne dabei ein � in SS zu verwandeln. �bernommen aus StringToolkitImpl.
     * @param original Der zu "vergr��ernde" String
     * @return Uppercase String.
     */
    public String toUpper(String original) 
    {
        // Nehme erstes Zeichen von String
        char letter = original.charAt(0);

        // a-z zu A-Z
        if(letter >= 'a' && letter <= 'z') {
            letter = (char) (letter - 'a' + 'A');
        }
        
        // �-� zu �-�
        if(letter >= '�' && letter <= '�') {
            letter = (char) (letter - '�' + '�');
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
    
    
    /**
     * Wandelt einen String in Kleinbuchstaben um. �bernommen aus StringToolkitImpl.
     * @param original Zu konvertierender String.
     * @return Lowercase String.
     */
    public String toLower(String original) 
    {
        // Nehme erstes Zeichen von String
        char letter = original.charAt(0);

        // A-Z zu a-z
        if(letter >= 'A' && letter <= 'Z') {
            letter = (char) (letter - 'A' + 'a');
        }
        
        // �-� zu �-�
        if(letter >= '�' && letter <= '�') {
            letter = (char) (letter - '�' + '�');
        }

        if(original.length() > 1) 
        {	
            // Weitere Zeichen vorhanden, reksursiv weiterverarbeiten ohne den ersten Char
            return letter + toLower(original.substring(1, original.length()));
        }
        else
        {
            // LetztesZeichen oder nur ein Zeichen -> Rückgabe
            return (letter + "");
        }
    }
}
