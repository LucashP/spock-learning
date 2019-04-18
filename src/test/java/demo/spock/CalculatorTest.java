package demo.spock;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    public void plus() {
        //given
        int a = 1;
        int b = 5;

        //when
        int result = calculator.plus(a, b);

        //then
        assertEquals(result, 6);
    }

    @Test
    public void minus() {
        //given
        int a = 1;
        int b = 5;

        //when
        int result = calculator.minus(a, b);

        //then
        assertEquals(result, -4);
    }
}