import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    @Test
    void testAddNumber() {
        Calculator calculator = new Calculator();
        calculator.setPrevNumber("1");
        String actual = calculator.addNumber("1");
        Assertions.assertEquals("10", actual);
    }

    @Test
    void testSubtractNumber() {
        Calculator calculator = new Calculator();
        calculator.setPrevNumber("1");
        String actual = calculator.subtractNumber("1");
        Assertions.assertEquals("0", actual);
    }

    @Test
    void testMultiplyNumber() {
        Calculator calculator = new Calculator();
        calculator.setPrevNumber("10");
        String actual = calculator.multiplyNumber("10");
        Assertions.assertEquals("100", actual);
    }

    @Test
    void testDivideNumber() {
        Calculator calculator = new Calculator();
        calculator.setPrevNumber("100");
        String actual = calculator.divideNumber("10");
        Assertions.assertEquals("10", actual);
    }

    @Test
    void testSquareRoot() {
        Calculator calculator = new Calculator();
        calculator.setPrevNumber("100");
        String actual = calculator.squareRootNumber("100");
        Assertions.assertEquals("10", actual);
    }

    @Test
    void testSquareNumber() {
        Calculator calculator = new Calculator();
        calculator.setPrevNumber("10");
        String actual = calculator.squareNumber("10");
        Assertions.assertEquals("100", actual);

    }
}