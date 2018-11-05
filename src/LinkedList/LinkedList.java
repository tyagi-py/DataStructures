package LinkedList;

public class LinkedList<T> {

    Node head;
    static  int size;

    public void insertAtBeginning(T data){
        if(head==null) head = new Node(data);
        else{
            Node temp = new Node(data);
            temp.nextNode =head;
            head =temp;
        }
        size++;
    }
    public void insertAtEnd(T data){

        if(head==null) head = new Node(data);

        else {
            Node t = head;

            while (t.nextNode != null) {
                t = t.nextNode;
            }
            Node newNode = new Node(data);
            t.nextNode = newNode;
        }
    }

    public void insertBefore(T key,T data){
        Node t=head;
        Node ex=t;
        while(t!=null&&t.data!=key){
            ex=t;
            t=t.nextNode;
        }
        if(t==null) try {
            throw new Exception("key not found");
        } catch (Exception e) {
            e.printStackTrace();
        }
        else{

            Node temp= new Node(data);
            temp.nextNode=ex.nextNode;
            ex.nextNode=temp;
        }
    }
    public void insertAfter(T key,T data){
        Node t=head;

        while(t!=null&&t.data!=key){

            t=t.nextNode;
        }
        if(t==null) try {
            throw new Exception("key not found");
        } catch (Exception e) {
            e.printStackTrace();
        }
        else{
            Node temp= new Node(data);
            temp.nextNode=t.nextNode;
            t.nextNode=temp;

        }
    }


    public void delete(T d){

    }
    public void display(){
        Node t=head;
        while (t!=null){
            System.out.println(t.data);
            t=t.nextNode;
        }

    }
    public boolean find(T key){
        Node t=head;

        while(t!=null&&t.data!=key){
            t=t.nextNode;
        }


        //if(t!=null&&t.data==key)
        if(t != null)
            return true;
        else
            return false;


    }
    public void delete(){
        head=head.nextNode;
        size++;
    }

}
