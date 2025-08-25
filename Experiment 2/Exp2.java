class PowerCalculator {
    public double fastPow(double base, int exponent) {
        long exp = exponent; 
        if (exp < 0) {
            base = 1 / base;
            exp = -exp;
        }
        return compute(base, exp);
    }

    private double compute(double base, long exp) {
        if (exp == 0) return 1;
        if (exp == 1) return base;

        double half = compute(base, exp / 2);
        if (exp % 2 == 0)
            return half * half;
        else
            return base * half * half;
    }
}

public class Exp2 {
    public static void main(String[] args) {
        PowerCalculator pc = new PowerCalculator();

        System.out.println(pc.fastPow(3, 5));   
        System.out.println(pc.fastPow(5, -3));  
        System.out.println(pc.fastPow(2.5, 4));  
        System.out.println(pc.fastPow(10, 0));   
    }
}
