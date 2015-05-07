package uebung03_mike;
import gdi.MakeItSimple;


public class SucheMaximum {

	public static void main(String[] args) {
		
		boolean abort = false;
		int max = 0;
		int current;
		
		while(!abort) {
			System.out.println("Bitte geben Sie die n�chste Zahl ein " +
					"(oder eine negative Zahl zum Beenden):");
			current = MakeItSimple.readInt();
			if(current < 0)
				abort = true;
			else if(current > max)
				max = current;
		}
		System.out.println("Das Maximum der eingegebenen Zahlen war: " + max);
	}

}
