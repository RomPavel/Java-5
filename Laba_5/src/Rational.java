import java.util.Iterator;
import java.util.StringTokenizer;

public class Rational implements Comparable <Rational>, Iterable<Object>
{
    int num;
    int denom;

    private static compareBy comparator = compareBy.numinator;
    public static void setComparator(compareBy comp)
    {
        comparator = comp;
    }

    Rational()
    {
        this.num=0;
        this.denom=1;
        this.reduce();

    }
    Rational(int num, int denom) throws DenominatorExepction
    {
        this.num=num;
        this.denom=denom;
        this.reduce();

        if(this.denom==0) throw new DenominatorExepction("Denominator = 0!");

    }
    Rational(String str) throws IllegalArgumentException
    {
        StringTokenizer st = new StringTokenizer(str, "(), ");
        this.num=Integer.parseInt(st.nextToken());
        this.denom=Integer.parseInt(st.nextToken());
        this.reduce();
    }
    @Override
    public String toString()
    {
        return "("+this.num+", "+this.denom+")";
    }


    @Override
    public int compareTo(Rational rt)
    {
        switch(comparator)
        {
            case numinator:
                return this.num>rt.num?1:this.num==rt.num?0:-1;

            case denominator:
                return this.denom>rt.denom?1:this.denom==rt.denom?0:-1;

        }
        return 0;
    }

    public Iterator<Object> iterator()
    {
        return new Iterator<Object>()
        {

            int iterator_idx = 0;

            public void reset()
            {
                iterator_idx = 0;
            }

            @Override
            public boolean hasNext()
            {
                return iterator_idx > 1 ? false: true;
            }

            @Override
            public Object next()
            {
                if ( iterator_idx == 0 )
                {
                    iterator_idx++;
                    return new Integer( num );
                }
                else if ( iterator_idx == 1 )
                {
                    iterator_idx++;
                    return new Integer( denom );
                }
                else
                {
                    reset();
                    return null;
                }
            }
        };
    }
    public void reduce()
    {
        for(int i=2; i<=Math.min(Math.abs(this.num),Math.abs( this.denom)); )
        {
            if(Math.abs(this.num%i)==0 && Math.abs(this.denom%i)==0) {this.num/=i; this.denom/=i;}
            else i++;
        }
        if(this.num<0&&this.denom<0) {this.num=-this.num; this.denom=-this.denom;}
    }

    public Rational plus(Rational a)
    {
        Rational c = new Rational();
        c.num=this.num*a.denom+a.num*this.denom;
        c.denom = this.denom*a.denom;
        c.reduce();
        return c;
    }
    public Rational minus(Rational a)
    {
        Rational c = new Rational();
        c.num=this.num*a.denom-a.num*this.denom;
        c.denom = this.denom*a.denom;
        c.reduce();
        return c;
    }
    public Rational multiply (Rational a)
    {
        Rational c = new Rational();
        c.num=this.num*a.num;
        c.denom = this.denom*a.denom;
        c.reduce();
        return c;
    }
    public Rational devide(Rational a) throws DenominatorExepction
    {
        Rational c = new Rational();
        c.num=this.num*a.denom;
        c.denom = this.denom*a.num;
        if(c.denom==0) throw new DenominatorExepction("Denominator = 0 in devide!");
        c.reduce();
        return c;
    }
}

