package uebung04;
import static gdi.MakeItSimple.*;

public class Conversion 
{
	public static void main(String[] args) 
        {
            print("Bitte geben Sie eine Zahl ein: ");
            String zahl = readLine();
            println("Die eingegebene Zahl: "+parseInteger(zahl));
	}

	public static int parseInteger(String digits) 
        {
            int result = 0;
            for(int i = 0; i < strLen(digits); i++)
            {
                int number = (digits.charAt(i)-'0');
                if (number >= 0 && number <= 9)
                    result += Math.pow(10,strLen(digits)-i-1)*number;
                else
                    throw new gdi.MakeItSimple.GDIException("Eingegebener Wert \"" 
                              + digits + "\" nicht gültig.");
            }
            return result;
	}
}



