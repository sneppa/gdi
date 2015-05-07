package uebung04;
import static gdi.MakeItSimple.*;

public class ISBNToolkit {
    public static void main(String args[])
    {        
        println("Tests Prüfziffer errechnen:");
        println("Prüfziffer für 978345550236: " + computeCheckDigitForISBN13("978345550236")); // 7
        println("Prüfziffer für 400243235453: " + computeCheckDigitForISBN13("400243235453")); // 5
        println("Prüfziffer für 978344215147: " + computeCheckDigitForISBN13("978344215147")); // 9
        println("Prüfziffer für 978382180818: " + computeCheckDigitForISBN13("978382180818")); // 5
        println("Prüfziffer für 978315000001: " + computeCheckDigitForISBN13("978315000001")); // 4
        println("");
        println("Tests Prüfziffer errechnen:");
        println("Ist 9783455502367 korrekt: " + isISBN13Valid("9783455502367")); // true
        println("Ist 4002432354535 korrekt: " + isISBN13Valid("4002432354535")); // true
        println("Ist 5783442151479 korrekt: " + isISBN13Valid("5783442151479")); // false
        println("Ist 9783821808185 korrekt: " + isISBN13Valid("9783821808185")); // true
        println("Ist 5783150000014 korrekt: " + isISBN13Valid("5783150000014")); // false
    }
    
    public static int computeCheckDigitForISBN13( String isbn13 )
    {
        int pruefZiffer = 0;
        
        isbn13 = removeSpaceChars(isbn13);
            
        if (isbn13.length() != 12)
        {
            throw new GDIException("Ungültige ISBN");
        }
        else
        {
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
                    pruefZiffer += zahl;
                }
                zaehler--;
            }
            
            pruefZiffer = (10 - (pruefZiffer % 10)) % 10;
        }
        
        return pruefZiffer;
    }
    
    public static boolean isISBN13Valid( String isbn13 )
    {
        isbn13 = removeSpaceChars(isbn13);
    
        if (isbn13.length() != 13)
        {
            return false;
        }
        else if (isbn13.charAt(12) - '0' != computeCheckDigitForISBN13(isbn13.substring(0,12)))
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    public static String removeSpaceChars(String isbn13)
    {
        String newisbn13 = "";
        char zeichen;
        
        for (int i = 0; i < isbn13.length(); i++)
        {
            zeichen = isbn13.charAt(i);
            if (zeichen != ' ' && zeichen != '-')
            {
                newisbn13 += zeichen;
            }
        }
        
        return newisbn13;
    }
}
