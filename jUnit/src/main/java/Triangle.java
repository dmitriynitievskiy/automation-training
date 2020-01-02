public class Triangle {
    private static final String ILLEGAL_LENGTH_OF_SIDE = "The side can't be less than or equals zero";

    public boolean isTriangleExist(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException(ILLEGAL_LENGTH_OF_SIDE);
        }
        return a + b > c && a + c > b && b + c > a;
    }
}
