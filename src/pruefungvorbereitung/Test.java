package pruefungvorbereitung;
import static gdi.MakeItSimple.*;
/**
 *
 * @author pi
 */
public class Test 
{
    
    public static void main(String args[])
    {
        // Folienbeispiele
        char i = '\n';
        short d = 12;
        
        
        return;
        
        println(11/4);
        println(-11/4);
        println(-11/-4);
        println(11/-4);
        
        println(11%4);
        println(11%-4);
        println(-11%4);
        println(-11%-4);
        
        println(3>2);
        println(3>=3);
        println(4!=5);
        println(4==5);
        println(5<=4);
        
        println("Die Rechnung ergibt den Wert" + 42);
        println(3 + " Test " + 4);
        println("Test " + 3 + 4);
        println(3 + 4 + " Test");
        
        println("a".charAt(0));
        //println("".charAt(3));
        println(("abc" + "123").charAt(4));
        
        println("a".length());
        println(("abc" + "123").length());
        println("".length());
        println("ab\"c\'d\"ef".length());
        
        println("Test7".equals("Test7"));
        println("Test7".equals("Test8"));
        println(("T"+"est7").equals("Test"+"7"));
        println("Test7".equals("T"+"e"+"s"+"t"+7));
        
        int a,b = 1;
        a = b++;
        println("a: "+a+" b: "+b);
        a = b = 1;
        a = ++b;
        println("a: "+a+" b: "+b);
        
        
        String [ ] as = { "array", "of", "String" };
        int i = 0;
        while ( i < as.length )
            print( as[i++] + ", " );
        println();
        
        int [] factorial = { 1, 1, 2, 6, 24, 120, 720, 5040 };
        i = 0;
        while ( i < factorial.length )
            print( factorial[i++] + ", ");
        println();
        
        println( as[1] );
        
        int [ ] ia1 = new int[3], ia2 = new int[3];
        i = 0;
        while ( i < ia2.length )
            ia2[i] = 6-i++;
        
        printArray(ia2);
        
        i = 0;
        while ( i < ia1.length && i < ia2.length )
            ia1[i] = ia2[i++];
        
        printArray(ia1);
        
        ia1[1] = 12;
        
        printArray(ia1);
        printArray(ia2);
        
        int [] y = new int[100], x = new int[10];
        println( y.length );
        y = x;
        println( y.length );
        
    }
    
    public static void mainPdfAuslesen(String args[])
    {
        Object file = openInputFile("gdipdf.txt");
        String line;
        int pdfs = 0;
        
        while(!isEndOfInputFile(file))
        {
            line = readLine(file);
            
            if (line.indexOf(".pdf") > 0 && line.indexOf("B-GDI/U") == -1)
            {
                println(line);
                pdfs++;
            }
        }
        
        println("PDFs: "+pdfs);
        
        closeInputFile(file);
    }

    public static void main9(String args[])
    {
        // Aufgabe 9
        Ober o = new Ober();
        Ober x = new Unter();
        
        o.m(3);
        //x.m(true);
        o.m("Hallo");
    }

    public static void main8(String args[])
    {
        // Aufgabe 8
        autoren(5,1,4,5,6,5);
    }
    
    public static void autoren(int number, int... autoren)
    {
        println(number);
        printArray(autoren);
    }

    public static void main7(String args[])
    {
        // Aufgabe 7
        int i = 42, j;
        String s = "Hello", t;
        boolean p = true, q;
        
        Object file = openOutputFile("ausgelagert.txt");
        println(file,i);
        println(file,s);
        println(file,p);
        closeOutputFile(file);
        
        file = openInputFile("ausgelagert.txt");
        j = readInt(file);
        readLine(file);
        t = readLine(file);
        q = readLine(file).equals("true");
        
        println(j);
        println(t);
        println(q);
        
        closeInputFile(file);
    }

    public static void main6(String args[])
    {
        // Aufgabe 6
        Grundfarben farben = Grundfarben.BLAU;
        
        // valueOf(String)
        println(farben.valueOf("GRÜN"));
        println();
        
        println(farben.toString());
        println();
        
        // values()
        for (Grundfarben farbe: Grundfarben.values())
            println(farbe);
        println();
    }

    public static void main5(String args[])
    {
        // Aufgabe 5
        if (isTrue(true) || isTrue(false))
        {
            println("short");
        }
        
        println();
        
        if (isTrue(true) | isTrue(false))
        {
            println("short");
        }
    }
    
    public static boolean isTrue(boolean a)
    {
        println(a);
        return a;
    }

    public static void main4(String args[])
    {
        // Aufgabe 4
        int i = 10;
        long x = 11L;
        float f;
        double d;
        
        f = (float) 12.5;
        println(f); // 12.5
        
        d = x;
        println(d); // 11.0
        
        i = (int) x;
        println(i); // 11
        
        d = i;
        println(d); // 11.0
        
        x = (long) f; 
        println(x); // 12
        
        x = (long) d;
        println(x); // 11
        
        
    }
    
    public static void main2(String args[])
    {
        // Aufgabe 2
        println(ifMethod(6));
        println(caseMethod(6));
    }
    
    public static String ifMethod(int number)
    {
        if (number==0 || number==2 || number==4 || number==8) return "gerade";
        if (number==3 || number==5 || number==7) return "mittendrin";
        if (number==1 || number==9) return "ungerade";
        if (number==6) return "sechs";
        return null;
    }
    
    public static String caseMethod(int number)
    {
        switch (number)
        {
            case 0: case 2: case 4: case 8:
                return "gerade";
            case 3: case 5: case 7:
                return "mittendrin";
            case 6:
                return "sechs";
            default:
                return null;
        }
    }
            
    public static void main1(String args[])
    {
        // Aufgabe 1
        int[] array = {10,20,30,40,50,60};
        int x;
        
        // a
        for (int i = array.length; i >= 0; i--)
        {
            println(array[i]);
        }
        
        printArray(array);
        
        // b
        for (int i = 0; i < (array.length/2); i++)
        {
            x = array[i];
            array[i] = array[array.length-i-1];
            array[array.length-i-1] = x;
        }
    
        printArray(array);
    }
    
    public static void printArray(int[] numbers)
    {
        for (int i = 0; i < numbers.length; i++)
        {
            print(numbers[i]);
            print("\t");
        }
        println("");
    }
}
