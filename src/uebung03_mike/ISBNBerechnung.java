package uebung03_mike;
import gdi.MakeItSimple;

public class ISBNBerechnung {

	public static void main(String[] args) {
		int[] number = new int[12];
		System.out.println("Bitte geben Sie die ISBN ohne Pr�fziffer und ohne Sonderzeichen/Leerzeichen ein:");
		String input = MakeItSimple.readLine();
		if(MakeItSimple.strLen(input) != 12) {
			System.out.println("Ung�ltige Eingabe!");
		}
		else {
			int i = 0; //Z�hlvariable
			int sum = 0;
			while(i < 12) {
				number[i] = (MakeItSimple.strCharAt(input,i)-48); //Offset
				System.out.println(number[i]);
				i++;
			}
			//"Mathematik kommt jetzt!"
			i = 0;
			
			while(i < 12) {
				if((i+1)%2 == 0)
					sum += (number[i]*3);
				else
					sum += number[i];
				i++;
			}
			System.out.println(sum);
			sum = sum%10;
			if(sum == 0)
				System.out.println("Die Pr�fziffer ist " + sum + ".");
			else
				System.out.println("Die Pr�fziffer ist " + (10-sum) + ".");
			
		}
	}

}
