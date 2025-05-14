public class ComplexNumber {
    private double real;
    private double imaginary;

    // Constructor
    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    // Getter for real part
    public double getReal() {
        return real;
    }

    // Getter for imaginary part
    public double getImaginary() {
        return imaginary;
    }

    // Addition
    public ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(this.real + other.real, this.imaginary + other.imaginary);
    }

    // Subtraction
    public ComplexNumber subtract(ComplexNumber other) {
        return new ComplexNumber(this.real - other.real, this.imaginary - other.imaginary);
    }

    // Multiplication
    public ComplexNumber multiply(ComplexNumber other) {
        double realPart = this.real * other.real - this.imaginary * other.imaginary;
        double imaginaryPart = this.real * other.imaginary + this.imaginary * other.real;
        return new ComplexNumber(realPart, imaginaryPart);
    }

    // Division
    public ComplexNumber divide(ComplexNumber other) {
        double denominator = other.real * other.real + other.imaginary * other.imaginary;
        if (denominator == 0) {
            throw new ArithmeticException("Division by zero");
        }
        double realPart = (this.real * other.real + this.imaginary * other.imaginary) / denominator;
        double imaginaryPart = (this.imaginary * other.real - this.real * other.imaginary) / denominator;
        return new ComplexNumber(realPart, imaginaryPart);
    }

    // Reciprocal (Mutual)
    public ComplexNumber reciprocal() {
        double denominator = real * real + imaginary * imaginary;
        if (denominator == 0) {
            throw new ArithmeticException("Reciprocal of zero is undefined");
        }
        return new ComplexNumber(real / denominator, -imaginary / denominator);
    }

    // String representation
    @Override
    public String toString() {
        return String.format("%.2f %s %.2fi", real, (imaginary >= 0 ? "+" : "-"), Math.abs(imaginary));
    }
}
