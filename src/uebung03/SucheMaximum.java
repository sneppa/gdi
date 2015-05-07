package uebung03;
import static gdi.MakeItSimple.*;

public class SucheMaximum 
{
    private static int maximum;
    
    public static void main(String[] args)
    {
        findMaximum();
    }
    
    public static void findMaximum()
    {
        int eingabe;
        
        print("Bitte geben Sie die nächste Zahl ein (oder eine negative Zahl zum Beenden):");
        eingabe = readInt();
        
        if (eingabe >= 0)
        {
            if (eingabe > maximum)
            {
                maximum = eingabe;
            }
            findMaximum();
        }
        else
        {   
            println("Das Maximum der eingegebenen Zahlen war:" + maximum);
        }      
    }
}
