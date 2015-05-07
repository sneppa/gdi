package uebung08;
import static gdi.MakeItSimple.*;

public class Start 
{
    public static void main(String[] args)
    {
        String file = "labyrinth1.txt"; //readLine();
        
        Labyrinth lab = new LabyrinthImpl();
        lab.readFromFile(file);
        
//        println("Number of Columns:\t"+lab.numberOfColumns());
//        println("Number of Rows:\t\t"+lab.numberOfRows());
//        
//        println(lab);
        
        lab.findWay();
        
        println(lab);
    }
}
