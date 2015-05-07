package uebung05;
import static gdi.MakeItSimple.*;

public class LinesOfCode 
{
    public static void main(String args[])
    {
        print("Bitte Pfad zur Datei eingeben: ");
        String path = readLine();
        //String path = "C:\\Users\\pi\\Documents\\NetBeansProjects\\GDI\\src\\uebung05\\StringSplitting.java";
        
        print("Das Programm enthält " + countLines(path) + " Zeilen.");
    }
    
    public static int countLines(String filename)
    {
        // Überprüfen ob Datei geöffnet werden kann und lesbar ist
        if (isFilePresent(filename) && isFileReadable(filename))
        {
            int lines = 0;
            String line = "";
            Object file = openInputFile(filename);
            
            // Alle Zeilen der Datei durchgehen
            while (!isEndOfInputFile(file))
            {
                // Zeile lesen
                line = readLine(file);
                
                if (isCodeLine(line))
                {
                    lines++;
                }
            }
            
            closeInputFile(file);
            return lines;
        }
        else
        {
            // Datei konnte nicht geöffnet/gelesen werden
            throw new gdi.MakeItSimple.GDIException("Datei nicht lesbar.");
        }
    }
    
    public static boolean isCodeLine(String line)
    {
        int i = 0;
        // Zeile leer -> kein Code
        if (line.equals(""))
            return false;
        
        // Zeichen der Zeile durchgehen
        while (i < line.length())
        {
            char zeichen = line.charAt(i);
            
            // Zechen ist kein Leerzeichen / Tabulator
            if (zeichen != ' ' && zeichen != '\t')
            {
                if (zeichen == '/')
                    return false; // Kommentar -> kein Code
                else
                    return true; // Kein Kommentar -> ist Code
            }
            i++;
        }
        
        // Zeile besteht nur aus Leerzeichen/Tabulatoren -> kein Code
        return false;
    }
}
