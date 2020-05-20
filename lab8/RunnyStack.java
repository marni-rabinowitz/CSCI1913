public class RunnyStack<Base>
{
    private class Run
    {
        private Base base;
        private int length;
        private Run next;
        public Run(Base base, int length, Run next)
        {
            this.base = base;
            this.length = length;
            this.next = next;
        }
    }
    private Run top;
    private int length;
    private int runs;
    public RunnyStack()
    {
        top = null;
        length = 0;
        runs = 0;
    }

    public int depth()
    {
        return length;
    }

    public boolean isEmpty()
    {
        return top == null;
    }

    public Base peek()
    {
        if(isEmpty())
        {
            throw new IllegalStateException();
        }
        else
        {
            return top.base;
        }
    }

    public void pop()
    {
        if(isEmpty())
        {
            throw new IllegalStateException();
        }
        else
        {
            top.length--;
            if(top.length == 0)
            {
                top = top.next;
                runs--;
            }
        }
        length--;
    }

    public void push(Base base)
    {
        if(isEmpty())
        {
            top = new Run(base, 1, top);
            runs++;
        }
        else
        {
            if(top != null && isEqual(base, top.base))
            {
                top.length++;
            }
            else
            {
                top = new Run(base, 1, top);
                runs++;
            }
        }
        length++;
    }

    public int runs()
    {
        return runs;
    }

    private boolean isEqual(Base b1, Base b2)
    {
        boolean x = false;
        if(b1 == null || b2 == null)
        {
            x = (b1 == b2);
        }
        else if(b1 != null && b2 != null)
        {
            x = (b1.equals(b2));
        }
        return x;
    }
}
