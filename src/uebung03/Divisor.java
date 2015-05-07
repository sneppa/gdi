package uebung03;
import gdi.MakeItSimple;

public class Divisor {

	public static void main(String[] args) {
		System.out.println("Bitte geben Sie eine Zahl ein:");
		//Eingabe entgegennehmen
		int divident = MakeItSimple.readInt();
		int i;
		//Keine Zahlen unter 1 annehmen
		if(divident < 1)
			System.out.println("Eingabe ungültig");
		else {
			i = divident;
			System.out.print("Die Divisoren sind: ");
			//Durch jede natürliche Zahl von n bis 1 teilen
			while(i >= 1) {
				if(divident%i == 0)		//Kein Rest?
					System.out.print(i + " ");
				//Die nächste Zahl
				i--;
			}
		}
	}
}




