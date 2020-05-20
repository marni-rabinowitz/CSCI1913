import java.util.Random;
public class ShuffleTree<Value>
{
    private class Node
    {
        private String key;    
        private Value value;  
        private Node  left;   //  Left subtree, whose KEY's are less than KEY.
        private Node  right;  //  Right subtree, whose KEY's are greater than KEY.

        private Node(String key, Value value)
        {
            this.key   = key;
            this.value = value;
            this.left  = null;
            this.right = null;
        }
    }
    private String[] keys;
    private Value[] values;
    private int count;
    private Node root;
    private Random generator;

    public ShuffleTree(int size)
    {
        if(size < 0)
        {
            throw new IllegalArgumentException();
        }
        else
        {
            keys = new String[size];
            values = (Value[]) new Object[size];
            count = 0;
            root = null;
            generator = new Random();
        }
    }

    private void flush()
    {
        int i = 0; 
        int k = 0;
        //shuffle
        while(i < count-2)
        {
            int j = generator.nextInt(count-i);
            String temp = keys[i+j];
            keys[i+j] = keys[i];
            keys[i] = temp;
            i++;
        }
        while(k < count-2)
        {
            int h = generator.nextInt(count-k);
            Value temp2 = values[k+h];
            values[k+h] = values[k];
            values[k] = temp2;
            k++;
        }
        //add key value pairs to bst
        for(int p = 0; p < count; p++)
        {
            add(keys[p], values[p]);
        }
        //make arrays null
        for(int o = 0; o < count; o++)
        {
            keys[o] = null;
            values[o] = null;
        }
        count = 0;
    }

    public void add(String key, Value value) 
    {
        if (root == null)
        {
            root = new Node(key, value);
        }
        else
        {
            Node subtree = root;
            while (true)
            {
                int test = key.compareTo(subtree.key);
                if (test < 0)
                {
                    if (subtree.left == null)
                    {
                        subtree.left = new Node(key, value);
                        return;
                    }
                    else
                    {
                        subtree = subtree.left;
                    }
                }
                else if (test > 0)
                {
                    if (subtree.right == null)
                    {
                        subtree.right = new Node(key, value);
                        return;
                    }
                    else
                    {
                        subtree = subtree.right;
                    }
                }
                else
                {
                    throw new IllegalStateException();
                }
            }
        }
    }

    public Value get(String key)
    {
        if(keys != null  && values != null)
        {
            flush();
        }
        Node subtree = root;
        while (subtree != null)
        {
            int test = key.compareTo(subtree.key);
            if (test < 0)
            {
                subtree = subtree.left;
            }
            else if (test > 0)
            {
                subtree = subtree.right;
            }
            else if(test == 0)
            {
                return subtree.value;
            }
        }
        throw new IllegalArgumentException("No such key.");
    }

    public int height()
    {
        if(keys != null && values != null)
        {
            flush();
        }
        return heighting(root);
    }

    //  HEIGHTING. Do all the work for HEIGHT. It's a postorder traversal.
    private int heighting(Node root)
    {
        if (root == null)
        {
            return 0;
        }
        else
        {
            int left  = heighting(root.left);
            int right = heighting(root.right);
            if (left > right)
            {
                return left + 1;
            }
            else
            {
                return right + 1;
            }
        }
    }

    public void put(String key, Value value)
    {
        if(key == null)
        {
            throw new IllegalArgumentException();
        }
        if(keys.length == count && values.length == count)
        {
            flush();
        }
        if(count < keys.length && count < values.length)
        {
            keys[count] = key;
            values[count] = value;
            count++;
        }
    }
}
