package OOPs;

import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;

public class Fraction {
    private int numerator,denominator;

    public Fraction(int numerator, int denominator) throws Exception {
        if (denominator == 0) throw new Exception("Denominator can't be zero");
        else {
            int gcd = getGcd(numerator,denominator);
            this.numerator = numerator/gcd;
            this.denominator = denominator/gcd;
        }
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public int getGcd(int n, int d){
        while(n!=0&&d!=0){
            if(n>d) n=n%d;
            else d=d%n;
        }
        if(n==0)return d;
        else return n;
    }

    static public Fraction add(Fraction f1, Fraction f2) throws Exception {
        return new Fraction(f1.getNumerator()*f2.getDenominator()+f2.getNumerator()*f1.getDenominator(),
                f1.getDenominator()*f2.getDenominator());
    }
    static public Fraction multiply(Fraction f1, Fraction f2) throws Exception {
        return new Fraction(f1.getNumerator()*f2.getNumerator(),
                f1.getDenominator()*f2.getDenominator());
    }
    public void getFraction(){
        System.out.println(numerator+"/"+denominator);
    }



}
