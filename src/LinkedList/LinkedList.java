package LinkedList;

public class LinkedList<T> {

    private Node<T> head;
    int size = 0;

    public Node<T> getHead() {
        return head;
    }

    public void insertAtBeginning(T data) {
        if (head == null) head = new Node<T>(data);
        else {
            Node<T> temp = new Node(data);
            temp.nextNode = head;
            head = temp;
        }
        size++;
    }

    public void insertAtEnd(T data) {

        if (head == null) head = new Node<T>(data);

        else {
            Node<T> t = head;

            while (t.nextNode != null) {
                t = t.nextNode;
            }
            Node<T> newNode = new Node<T>(data);
            t.nextNode = newNode;
        }
        size++;

    }

    public void insertBefore(T key, T data) {
        Node<T> t = head;
        Node<T> ex = t;
        while (t != null && t.data != key) {
            ex = t;
            t = t.nextNode;
        }
        if (t == null) try {
            throw new Exception("key not found");
        } catch (Exception e) {
            e.printStackTrace();
        }
        else {

            Node<T> temp = new Node(data);
            temp.nextNode = ex.nextNode;
            ex.nextNode = temp;
        }
        size++;

    }

    public void insertAfter(T key, T data) {
        Node<T> t = head;

        while (t != null && t.data != key) {

            t = t.nextNode;
        }
        if (t == null) try {
            throw new Exception("key not found");
        } catch (Exception e) {
            e.printStackTrace();
        }
        else {
            Node<T> temp = new Node<T>(data);
            temp.nextNode = t.nextNode;
            t.nextNode = temp;

        }
        size++;

    }

    public void insertAtPosition(int pos, T data) {
        if (pos > size) {
            try {
                throw new Exception("position not in list");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Node<T> t = head;
            while (pos > 2) {
                t = t.nextNode;
                pos--;
            }
            Node<T> temp = new Node<T>(data);
            temp.nextNode = t.nextNode;
            t.nextNode = temp;
        }
    }


    public void delete(T d) {
        Node<T> t = head;
        Node<T> prev = t;
        while (t != null && t.data != d) {
            prev = t;
            t = t.nextNode;
        }
        if (t == null) try {
            throw new Exception("Item not present");
        } catch (Exception e) {
            e.printStackTrace();
        }
        else {
            prev.nextNode = t.nextNode;
        }
        size--;

    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
        }
        Node<T> t = head;
        while (t != null) {
            System.out.println(t.data);
            t = t.nextNode;
        }

    }

    public boolean find(T key) {
        Node<T> t = head;

        while (t != null && t.data != key) {
            t = t.nextNode;
        }


        //if(t!=null&&t.data==key)
        if (t != null)
            return true;
        else
            return false;


    }

    public void delete() {
        head = head.nextNode;
        size--;
    }

    /*Here the questions start
     * ****************************************************************/
    public T midPoint() {
        Node<T> slow = head, fast = head;
        while (fast.nextNode != null) {
            slow = slow.nextNode;
            fast = fast.nextNode.nextNode;
        }
        return slow.data;


    }

    public static <T> LinkedList merge(LinkedList<T> l1, LinkedList<T> l2) {
        l1.display();
        l2.display();
        Node<T> h1 = l1.getHead();
        Node<T> h2 = l2.getHead();
        LinkedList<T> retlist =new LinkedList<T>();
        while (h1 != null && h2 != null) {
            if((Integer) h1.data > (Integer) h2.data){
                retlist.insertAtBeginning(h2.data);
            }
            else{
                retlist.insertAtBeginning(h1.data);

            }
        }

        return retlist;
    }
}
