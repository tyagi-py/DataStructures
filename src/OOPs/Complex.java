package OOPs;

public class Complex {
    private int real;
    private int imaginary;

    public int getReal() {
        return real;
    }

    public int getImaginary() {
        return imaginary;
    }

    public Complex(int real, int imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    static public Complex add(Complex c1,Complex c2){
        return new Complex(c1.getReal()+c2.getReal(),c1.getImaginary()+c2.getImaginary());
    }
    static public Complex conjugate(Complex c1){
        return new Complex(c1.getReal(),-c1.getImaginary());
    }
}
