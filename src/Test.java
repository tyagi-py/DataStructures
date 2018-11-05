import OOPs.Fraction;

public class Test {




    public static void main(String args[]) throws Exception {
        Fraction f=new Fraction(18,6);
        Fraction f2=new Fraction(18,4);
        Fraction f1=Fraction.multiply(f,f2);
        Fraction f3=Fraction.add(f,f2);
        f1.getFraction();
        f3.getFraction();

    }
}
