package demo.spock

import demo.spock.calculator.Calculator
import spock.lang.Specification

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

    def minus() {
        given:
        def a = 1
        def b = 5

        when:
        def result = calculator.minus(a, b)

        then:
        result == -4
    }
}