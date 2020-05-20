
public class Poly
{
    public class Term
    {
        private int coef;
        private int expo;
        private Term next;

        public Term(int coef, int expo, Term next)
        {
            this.coef = coef;
            this.expo = expo;
            this.next = next;
        }
    }
    private Term first;
    private Term last;

    public Poly()
    {
        first = new Term(1, Integer.MAX_VALUE, null);
        last = first;
        last.next = null;
    }

    public boolean isZero()
    {
        return (first.next == null && last.next == null);
    }

    public Poly minus()
    {
        Poly result = new Poly();
        Term temp = first.next;
        while(temp != null)
        {
            int neg = -(temp.coef);
            result.plus(neg, temp.expo);
            temp = temp.next;
        }
        return result;
    }

    public Poly plus(Poly that)
    {
        Poly result = new Poly();
        Term left = first.next;
        Term right = that.first.next;
        while((left != null) && (right != null))
        {
            if(left.expo > right.expo)
            {
                result.plus(left.coef, left.expo);
                left = left.next;
            }
            else if(right.expo > left.expo)
            {
                result.plus(right.coef, right.expo);
                right = right.next;
            }
            else
            {
                int sum = left.coef + right.coef;
                if(sum != 0)
                {
                    result.plus(sum, left.expo);
                }
                left = left.next;
                right = right.next;
            }
        }
        if(left != null)
        {
            result.last.next = left;
        }
        else if(right != null)
        {
            result.last.next = right;
        }
        return result;
    }

    public Poly plus(int coef, int expo) 
    {
        if(coef == 0 || expo < 0 || expo >= last.expo)
        {
            throw new IllegalArgumentException();
        }
        else
        { 
            Term p = new Term(coef, expo, null);
            last.next = p;
            last = p;
        }
        return this;
    }

    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        Term current = first.next;
        if(isZero())
        {
            return "0";
        }
        builder.append(current.coef);
        builder.append("x^");
        builder.append(current.expo);
        current = current.next;
        while(current != null)
        {
            if(current.coef < 0)
            {
                builder.append("-" + Math.abs(current.coef));
            }
            else
            {
                builder.append("+" + Math.abs(current.coef));
            }
            builder.append("x^");
            builder.append(current.expo);
            current = current.next;
        }
        return builder.toString();
    }
}
