import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @Test
    public void testAddNumber() {
        Calculator calculator = new Calculator();
        calculator.setPrevNumber("1");
        String actual = calculator.addNumber("1");
        Assertions.assertEquals("10", actual);
    }

    @Test
    public void testSubtractNumber() {
        Calculator calculator = new Calculator();
        calculator.setPrevNumber("1");
        String actual = calculator.subtractNumber("1");
        Assertions.assertEquals("0", actual);
    }

    @Test
    public void testMultiplyNumber() {
        Calculator calculator = new Calculator();
        calculator.setPrevNumber("10");
        String actual = calculator.multiplyNumber("10");
        Assertions.assertEquals("100", actual);
    }

    @Test
    public void testDivideNumber() {
        Calculator calculator = new Calculator();
        calculator.setPrevNumber("100");
        String actual = calculator.divideNumber("10");
        Assertions.assertEquals("10", actual);
    }

    @Test
    public void testSquareRoot() {
        Calculator calculator = new Calculator();
        calculator.setPrevNumber("100");
        String actual = calculator.squareRootNumber("100");
        System.out.println(actual);
        Assertions.assertEquals("10", actual);
    }

    @Test
    public void testSquareNumber() {
        Calculator calculator = new Calculator();
        calculator.setPrevNumber("");
        String actual = calculator.squareRootNumber("");
        System.out.println(actual);
        Assertions.assertEquals("", actual);

    }
}