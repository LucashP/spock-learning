package demo.spock.method.unrolling

import demo.spock.calculator.Calculator
import spock.lang.Specification
import spock.lang.Unroll

class UnrollSpec extends Specification {

    def calculator = new Calculator()

    @Unroll
    def "should calculate correctly [a=#a, b=#b]"() {
        when:
        def result1 = calculator.plus(a, b)
        def result2 = Math.max(a, b)

        then:
        expectedResult1 == result1
        expectedResult2 == result2

        where:
        a  | b || expectedResult1 | expectedResult2
        1  | 2 || 3               | 2
        10 | 3 || 13              | 10
    }

    @Unroll
    def "should calculate correctly [a=#a, b=#b] with params"(int a, int b, int expectedResult1, int expectedResult2) {
        when:
        def result1 = calculator.plus(a, b)
        def result2 = Math.max(a, b)

        then:
        expectedResult1 == result1
        expectedResult2 == result2

        where:
        a  | b || expectedResult1 | expectedResult2
        1  | 2 || 3               | 2
        10 | 3 || 13              | 10
    }

    @Unroll
    def "should calculate correctly with Math.pow [a=#a]"() {
        when:
        def result = Math.pow(a, 2)

        then:
        result == a * a

        where:
        a << [1, 3, 4, 5]
    }
}
