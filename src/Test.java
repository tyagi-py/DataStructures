import OOPs.Fraction;
import OOPs.DynamicArray;
import LinkedList.*;
public class Test {

    public static void main(String args[]) throws Exception {
       /* Fraction f=new Fraction(18,6);
        Fraction f2=new Fraction(18,4);
        Fraction f1=Fraction.multiply(f,f2);
        Fraction f3=Fraction.add(f,f2);
        f1.getFraction();
        f3.getFraction();*/

       /*DynamicArray array = new DynamicArray();
       array.add(12);
       array.add(13);
       array.add(11);
       array.add(12);
       System.out.println(array.size());
       array.add(122);
       array.add(122);
       array.add(142);
       array.add(152);
       array.add(152);
       array.add(152);
       array.add(152);
       array.add(152);
       array.add(152);
       array.add(152);
       array.add(152);
       array.add(152);
       array.add(152);
       array.add(152);
       array.add(152);
       System.out.println(array.size());
       for(int i=0;i<array.size();i++){
           System.out.println(array.get(i));

       }
       System.out.println("\n\n\n\n"+array.get(3));*/

       LinkedList<Integer> linkedList=new LinkedList<Integer>();
      /* linkedList.insertAtBeginning(12);
       linkedList.insertAtBeginning(11);
       linkedList.insertAtBeginning(13);*/
       linkedList.insertAtEnd(12);
       linkedList.insertAtEnd(11);
       linkedList.insertAtEnd(13);
       linkedList.insertAtBeginning(15);
       //linkedList.insertAfter(11,17);
       linkedList.insertBefore(11,17);
       //linkedList.delete(17);
       linkedList.display();
        System.out.println(linkedList.find(-1));

    }
}
