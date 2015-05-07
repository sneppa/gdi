package uebung02;
import static gdi.MakeItSimple.*;

public class Easter 
{
    public static void main(String[] args) {
               
        calc(2014);
    }
    
    public static void calc(int y)
    {
        int g,c,h,i,j,l,day,month;
        
        g = y % 19;
        c = y / 100;
        h = (c - (c/4) - ((8*c+13)/25) + 19*g + 15)%30;
        i = h - (h/28) * (1 - (29/(h+1) * ((21-g)/11)));
        j = (y + (y+4) + i + 1 - c + (c/4)) % 7;
        l = i - j;
        month = 3 + ((l+40)/44);
        day = l + 28 - 31 * (month/4);
        
        println("Der Ostersonntag im Jahr " + y + " fällt auf den " + day + "." + month + "." + y + ".");        
    }
}
