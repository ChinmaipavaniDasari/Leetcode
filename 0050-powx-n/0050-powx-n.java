class Solution {
    public double myPow(double x, int n) {
        long pow = n;  // use long to avoid overflow when n = -2^31
        if (pow < 0) {
            x = 1 / x;     // invert x if n is negative
            pow = -pow;
        }
        
        double res = 1.0;
        while (pow > 0) {
            if (pow % 2 == 1) {  // if pow is odd
                res *= x;
            }
            x *= x;       // square the base
            pow /= 2;     // halve the exponent
        }
        return res;
    }
}
