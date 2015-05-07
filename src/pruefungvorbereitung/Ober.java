package pruefungvorbereitung;
import static gdi.MakeItSimple.*;

class Ober {
    
    Ober(String name)
    {
        println("param");
    }
    
    Ober()
    {
        println("noparam");
    }
     void m(long l) { println(1); }
     void m(String s) { println(2); }
    
}
