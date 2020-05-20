public class FamilyTree
{
    private class Node
    {
        private String name;
        private Node mother;
        private Node father;
        public Node(String name, Node mother, Node father)
        {
            this.name = name;
            this.mother = mother;
            this.father = father;
        }
    }
    private Node root;

    public FamilyTree(String ego)
    {
        root = new Node(ego, null, null);
    }

    private Node Find(String name)
    {
        return find(name, root);
    }

    private Node find(String name, Node root)
    {
        if(root == null)
        {
            return null;
        } 
        else if (root.name.equals(name))
        {
            return root;
        }
        else 
        {
            Node f = find(name, root.father); 
            Node m = find(name, root.mother);
            if(m != null)
            {
                return m;
            }
            else
            {
                return f;
            }
        }
    }

    public void addParents(String ego, String father, String mother) throws IllegalArgumentException
    {
        Node n = Find(ego);
        if(n == null)
        {
            throw new IllegalArgumentException("No such node.");
        }
        else
        {
            n.father = new Node(father, null, null);
            n.mother = new Node(mother, null, null);
        }
    }

    public boolean isDescendant(String ego, String ancestor)
    {
        if(Find(ego) == null|| Find(ancestor) == null)
        {
            return false;
        }
        else
        {
            return isDescendant(Find(ego), Find(ancestor));
        }
    }

    private boolean isDescendant(Node root, Node ancestor)
    {
        if(root == null)
        {
            return false;
        }
        else if (find(ancestor.name, root) != null)
        {
            return true;
        } 
        else 
        {
            boolean f = isDescendant(root.father, ancestor);
            boolean m = isDescendant(root.mother, ancestor);
            return m || f;
        }
    }
}
