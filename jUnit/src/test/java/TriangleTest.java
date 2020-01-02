import org.junit.Test;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

public class TriangleTest {
    private final Triangle triangle = new Triangle();

    @Test(expected = IllegalArgumentException.class)
    public void allNegativeSidesTest(){
        triangle.isTriangleExist(-1.0,-3.0,-5.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void oneZeroSideTest() {
        triangle.isTriangleExist(0,3.0,4.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void allZeroSidesTest() {
        triangle.isTriangleExist(0, 0, 0);
    }

    @Test
    public void equilateralTriangleTest() {
        assertTrue(triangle.isTriangleExist(5.0,5.0,5.0));
    }

    @Test
    public void isoscelesTriangleTest() {
        assertTrue(triangle.isTriangleExist(3.0,3.0,5.0));
    }

    @Test
    public void rightTriangleTest() {
        assertTrue(triangle.isTriangleExist(3.0,4.0,5.0));
    }

    @Test
    public void sumOfTwoSidesEqualsThirdTest() {
        assertFalse(triangle.isTriangleExist(3.0,4.0,7.0));
    }

    @Test
    public void oneSideLargeThenSumOfTwoOthersTest() {
        assertFalse(triangle.isTriangleExist(4.0,5.0,9.2));
    }

    @Test
    public void oneOfTheSideIsMaxDoubleTest() {
        assertFalse(triangle.isTriangleExist(Double.MAX_VALUE, 4.0, 5.0));
    }

    @Test
    public void allSidesIsMaxDoubleTest() {
        assertTrue(triangle.isTriangleExist(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE));
    }
}