package uebung03;
import static gdi.MakeItSimple.*;        

public class ISBNBerechnung 
{
    public static void main(String[] args)
    {
        print("Bitte geben Sie eine ISBN-13 ohne Prüfziffer, Trennstriche und Leerzeichen ein: ");
        String isbn13 = readLine();
                
        if (isbn13.length() != 12)
        {
            println("Ungültige länge, bitte 12 Ziffern eingeben!");
        }
        else
        {
            int pruefZiffer = 0;
            int zaehler = 12;
            while (zaehler > 0)
            {
                int zahl = isbn13.charAt(zaehler-1) - '0';

                if (zaehler % 2 == 0)
                {
                    pruefZiffer += zahl*3;
                }
                else
                {
                    pruefZiffer += zahl%10;
                }
                zaehler--;
            }
            
            pruefZiffer = (pruefZiffer % 10);
            
            if (pruefZiffer > 0)
            {
                pruefZiffer = 10 - pruefZiffer;
            }

            println("Die Prüfziffer ist: "+pruefZiffer);
            
            /*
            
            Geprüfte Ziffern:
            978345550236 - 7
            400243235453 - 5
            978344215147 - 9
            978382180818 - 5
            978315000001 - 4
            
            */
        }
        
    }
}
