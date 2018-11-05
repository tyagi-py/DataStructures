import OOPs.Fraction;
import OOPs.DynamicArray;
public class Test {

    public static void main(String args[]) throws Exception {
       /* Fraction f=new Fraction(18,6);
        Fraction f2=new Fraction(18,4);
        Fraction f1=Fraction.multiply(f,f2);
        Fraction f3=Fraction.add(f,f2);
        f1.getFraction();
        f3.getFraction();*/

       DynamicArray array = new DynamicArray();
       array.add(12);
       array.add(13);
       array.add(11);
       array.add(12);
       /*System.out.println(array.size());
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
       array.add(152);*/
       System.out.println(array.size());
       for(int i=0;i<array.size();i++){
           System.out.println(array.get(i));

       }
       System.out.println("\n\n\n\n"+array.get(3));

    }
}
