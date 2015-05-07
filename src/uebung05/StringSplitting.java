package uebung05;
import static gdi.MakeItSimple.*;

public class StringSplitting 
{
   public static void main(String args[])
   {
       boolean weiter = true;
       String original;
       char delimiter;
       
       while (weiter)
       {
           print("Bitte String eingeben, der geteilt werden soll (Abbruch mit leerer Eingabe):");
           original = readLine();
           
           if (original.length() == 0)
           {
               println("Eingabe abgebrochen");
               weiter = false;
           }
           else
           {
               print("Bitte geben Sie das Trennzeichen ein:");
               delimiter = readChar();
               readLine();
               
               String[] splittedString = strSplit(original, delimiter);
               
               for (int i = 0; i < splittedString.length; i++)
               {
                    println((i+1) + ". String: " + splittedString[i]);
               }
           }
       }
   }
   
   public static String[] strSplit(String original, char delimiter)
   {
       int count = 0, i = 0;
       
       if (original.length() == 0)
       {
           return new String[1];
       }       
       
       // Feststellen der Arraylänge
       while (i < original.length())
       {
           if (original.charAt(i) == delimiter) 
               count++;
           i++;
       }
       String[] values = new String[count+1];
       
       // Array mit den Strings füllen
       i = 0;
       count = 0;
       values[0] = "";
       while (i < original.length())
       {
           char mchar = original.charAt(i);
           if (mchar == delimiter)
           {
               count++;
               values[count] = "";
           }
           else
               values[count] += mchar;
           i++;
       }
       
       return values;
   }        
}

