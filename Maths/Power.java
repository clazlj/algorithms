package Maths;

public class Power {
    public static void main(String[] args) {
        System.out.println(power(2, 3));

        System.out.println(power(-1, 3));

        System.out.println(power(3, -2));

    }

    private static double power(int a, int n) {
        if (n == 0) {
            return 1D;
        }
        if (n < 0) {
            return 1D / power(a, -n);
        }
        return a * power(a, n - 1);
    }
}
