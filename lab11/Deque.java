public class Deque<Base>
{
    public class Node
    {
        private Base object;
        private Node previous;
        private Node next;
        public Node(Base object, Node previous, Node next)
        {
            this.object = object;
            this.previous = previous;
            this.next = next;
        }
    }
    private Node head;

    /**
     * Constructor for objects of class LinkedQueue
     */
    public Deque()
    {
        head = new Node(null, null, null);
        head.previous = head;
        head.next = head;
    }

    public boolean isEmpty()
    {
        return (head.previous == head && head.next == head);
    }

    public void enqueueFront(Base object)
    {
        Node q = new Node(object, head, head.next);
        head.next.previous= q;
        head.next = q;
    }

    public void enqueueRear(Base object)
    {
        Node q = new Node(object, head.previous, head);
        head.previous.next = q;
        head.previous = q;
    }

    public Base dequeueFront()
    {
        if(isEmpty())
        {
            throw new IllegalStateException();
        }
        Base x = head.next.object;
        Node current = head.next;
        current.previous.next = current.next;
        current.next.previous = current.previous;
        return x;
    }

    public Base dequeueRear()
    {
        if(isEmpty())
        {
            throw new IllegalStateException();
        }
        Base x = head.previous.object;
        Node current = head.previous;
        current.next.previous = current.previous;
        current.previous.next = current.next;
        return x;
    }
}
