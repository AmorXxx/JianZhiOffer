public class Answer_12 {
    public double Power(double base, int exponent) {
        if (base == 0.0d){
            return 0;
        }
        double result = 1.0d;
        int e = exponent > 0 ? exponent : -exponent;
        for (int i = 0; i < e ; i++){
            result *= base;
        }
        return exponent > 0 ? result : 1/result;
    }
}
