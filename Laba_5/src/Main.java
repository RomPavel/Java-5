import com.sun.corba.se.impl.orbutil.DenseIntMapImpl;

import java.util.*;
import java.lang.*;

class Main
{
    public static void main(String args[])
    {
        try
        {
            Rational first = new Rational();
            Rational second = new Rational(-4,-12);
            Rational third = new Rational("(-5,2)");

            System.out.println("Constructor without arguments: "+first.toString());
            System.out.println("Constructor with arguments (-4,-12): "+second.toString());
            System.out.println("Constructor by String '(-5,2)': "+third.toString());
            System.out.println();
            System.out.println("Plus: "+third.plus(second));
            System.out.println("Minus: "+third.minus(second));
            System.out.println("Multiply: "+third.multiply(second));
            System.out.println("Devide: "+third.devide(second));

            Rational[] arr = {first, second, third};


            Rational.setComparator(compareBy.denominator);
            Arrays.sort(arr);

            System.out.println();
            System.out.println("Array Sorted by denominators");
            for(Rational item1: arr)
            {
                for(Object obj1:item1)
                    System.out.print(obj1+" ");
                System.out.println();
            }

            Rational.setComparator(compareBy.numinator);
            Arrays.sort(arr);
            System.out.println();
            System.out.println("Array Sorted by numinators");
            for(Rational item2: arr)
            {
                for(Object obj2:item2)
                    System.out.print(obj2+" ");
                System.out.println();
            }

            Rational forth = new Rational("0,1");

            System.out.println(first.devide(forth));
        }

        catch(IllegalArgumentException e)
        {
            e.printStackTrace();
        }
        catch(DenominatorExepction e) {
            System.out.println(e.GetString());
        }

    }
}

