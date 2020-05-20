class PriorityQueue<Base>  
{  
    private class Node  
    {  
        private Base object;  
        private int  rank;  
        private Node left;  
        private Node right;  

        private Node(Base object, int rank)  
        {  
            this.object = object;  
            this.rank = rank;  
            left = null;  
            right = null;  
        }  
    }  

    private Node root;  //  Root node of the BST.  

    public PriorityQueue()
    {
        root = new Node(null, 10);
    }

    public Base dequeue()
    {
        if(isEmpty())
        {
            throw new IllegalStateException();
        }
        else
        {
            Node above = root;
            Node below = root.left;
            while (below.left != null)
            {
                above = below;
                below = below.left;
            }
            Node Final = below;
            above.left = below.right;
            return Final.object;
        }
    }

    public void enqueue(Base object, int rank)
    {
        if(rank < 0)
        {
            throw new IllegalArgumentException();
        }
        else
        {
            if (root == null)
            {
                root.right = new Node(object, rank);
            }
            else
            {
                Node subtree = root;
                while (true)
                {
                    if (rank <= subtree.rank)
                    {
                        if (subtree.left == null)
                        {
                            subtree.left = new Node(object, rank);
                            return;
                        }
                        else
                        {
                            subtree = subtree.left;
                        }
                    }
                    else if (rank > subtree.rank)

                        if (subtree.right == null)
                        {
                            subtree.right = new Node(object, rank);
                            return;
                        }
                        else
                        {
                            subtree = subtree.right;
                        }

                    else
                    {
                        subtree.rank = rank;
                        return;
                    }
                }
            }
        }
    }

    public boolean isEmpty()
    {
        return root.right == null && root.left == null;
    }
}
