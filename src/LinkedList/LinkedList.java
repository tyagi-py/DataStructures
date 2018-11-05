package LinkedList;

public class LinkedList<T> {

    private Node head;
    static  int size=0;

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
        size++;

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
        size++;

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
        size++;

    }

    public void insertAtPosition(int pos,T data){
        if(pos>size){
            try {
                throw new Exception("position not in list");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            Node t = head;
            while(pos>2){
                t=t.nextNode;
                pos--;
            }
            Node temp =new Node(data);
            temp.nextNode = t.nextNode;
            t.nextNode = temp;
        }
    }

    public <A> A midPoint(){
        Node slow=head,fast=head;
        while(fast!=null){
            slow=slow.nextNode;
            fast=fast.nextNode.nextNode;
        }
        return slow.data;

    }

    public void delete(T d){
        Node t=head;
        Node prev=t;
        while(t!=null&&t.data!=d){
            prev=t;
            t=t.nextNode;
        }
        if(t==null) try {
            throw new Exception("Item not present");
        } catch (Exception e) {
            e.printStackTrace();
        }
        else{
            prev.nextNode=t.nextNode;
        }
        size--;

    }

    public void display(){
        if(head==null){
            System.out.println("List is empty");
        }
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
        size--;
    }

}
