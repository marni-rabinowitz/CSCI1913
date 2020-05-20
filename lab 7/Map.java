public class Map<Key, Value>
{
    private Key[] keys;
    private Value[] values;
    private int count;

    public Map(int length)
    {
        if(length < 0)
        {
            throw new IllegalArgumentException();
        }
        count = 0;
        keys = (Key[]) new Object[length];
        values = (Value[]) new Object[length];
    }

    public Value get(Key key) throws IllegalArgumentException
    {
        int index;
        for(index = 0; index < keys.length; index++)
        {
            if(isEqual(keys[index], key))
            {
                return values[index];
            }
        }   
        throw new IllegalArgumentException();
    }

    private boolean isEqual(Key leftKey, Key rightKey)
    {
        boolean x = false;
        if(leftKey == null || rightKey == null)
        {
            x = (leftKey == rightKey);
        }
        else if(leftKey != null && rightKey != null)
        {
            x = (leftKey.equals(rightKey));
        }
        return x;
    }

    public boolean isIn(Key key)
    {
        for(int i = 0; i < keys.length; i++)
        {
            if(isEqual(keys[i], key))
            {
                return true;
            }
        }
        return false;
    }

    public void put(Key key, Value value) throws IllegalStateException
    {
        //System.out.println(count);
        int index;
        if((count > keys.length) && (count > values.length))
        {
           
            throw new IllegalStateException();
        }
        else
        {
            for(index = 0; index < count; index++)
            {
                if(isEqual(keys[index], key))
                {
                    //System.out.println("key: " + keys[index] + " value: " + values[index]);
                    values[index] = value;
                    return;
                }
            }
            if(count < keys.length && count < values.length)
            {
                keys[count] = key;
                values[count] = value;
                count++;
            }
            else
            {
                throw new IllegalStateException();
            }
        }

    }

    private int where(Key key)
    {
        for(int i = 0; i < keys.length; i++)
        {
            if(isEqual(keys[i], key))
            {
                return i;
            }
        }
        return -1;
    }
}
