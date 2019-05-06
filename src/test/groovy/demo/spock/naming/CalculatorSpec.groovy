package demo.spock.naming

import demo.spock.calculator.Calculator
import spock.lang.Specification
import spock.lang.Unroll

import static org.junit.Assert.assertEquals

class CalculatorSpec extends Specification {

    def calculator = new Calculator()

    def "plus"() {
        given:
        def a = 1
        def b = 5

        when:
        def result = calculator.plus(a, b)

        then:
        assertEquals(result, 6)
        result == 6
    }

    @Unroll("minus override [a=#a,b=#b]")
    def minus() {
        when:
        def result = calculator.minus(a, b)

        then:
        result == -4

        where:
        a | b
        1 | 5
        2 | 6
    }
}