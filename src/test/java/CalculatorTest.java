import org.example.Main;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    @Before
    public void setup() {
        // No need to create an instance, static methods will be tested
    }

    @Test
    public void should_return_correct_power_result() {
        double base = 2.0;
        double exponent = 3.0;
        double expectedResult = 8.0;
        double actualResult = Main.power(base, exponent);
        Assert.assertEquals("Power result is incorrect", expectedResult, actualResult, 0.000001);
    }

    @Test
    public void should_fail_when_power_result_is_incorrect() {
        double base = 2.0;
        double exponent = 3.0;
        double incorrectResult = 10.0;
        double actualResult = Main.power(base, exponent);
        Assert.assertNotEquals("Test failed: The power result should not match", incorrectResult, actualResult);
    }

    @Test
    public void should_return_correct_square_root() {
        double number = 9.0;
        double expectedResult = 3.0;
        double actualResult = Main.squareRoot(number);
        Assert.assertEquals("Square root result is incorrect", expectedResult, actualResult, 0.000001);
    }

    @Test
    public void should_fail_when_square_root_result_is_incorrect() {
        double number = 9.0;
        double incorrectResult = 4.0;
        double actualResult = Main.squareRoot(number);
        Assert.assertNotEquals("Test failed: The square root result should not match", incorrectResult, actualResult);
    }

    @Test
    public void should_return_correct_factorial_result() {
        int number = 5;
        long expectedResult = 120;
        long actualResult = Main.factorial(number);
        Assert.assertEquals("Factorial result is incorrect", expectedResult, actualResult);
    }

    @Test
    public void should_fail_when_factorial_result_is_incorrect() {
        int number = 5;
        long incorrectResult = 150;
        long actualResult = Main.factorial(number);
        Assert.assertNotEquals("Test failed: The factorial result should not match", incorrectResult, actualResult);
    }

    @Test
    public void should_return_correct_natural_logarithm() {
        double number = Math.E; // Using Euler's number, the natural log of e is 1
        double expectedResult = 1.0;
        double actualResult = Main.naturalLogarithm(number);
        Assert.assertEquals("Natural logarithm result is incorrect", expectedResult, actualResult, 0.000001);
    }

    @Test
    public void should_fail_when_natural_logarithm_result_is_incorrect() {
        double number = Math.E;
        double incorrectResult = 2.0;
        double actualResult = Main.naturalLogarithm(number);
        Assert.assertNotEquals("Test failed: The natural logarithm result should not match", incorrectResult, actualResult);
    }

    @Test
    public void should_return_NaN_for_square_root_of_negative_number() {
        double number = -9.0;
        double result = Main.squareRoot(number);
        Assert.assertTrue("Square root of negative number should return NaN", Double.isNaN(result));
    }

    @Test
    public void should_return_NaN_for_logarithm_of_non_positive_number() {
        double number = 0.0;
        double result = Main.naturalLogarithm(number);
        Assert.assertTrue("Logarithm of non-positive number should return NaN", Double.isNaN(result));
    }
}
