package demo.spock.feature.methods

import demo.spock.calculator.Calculator
import spock.lang.Specification

class WhereBlockSpec extends Specification {

    def calculator = new Calculator()

    def "should calculate correctly"() {
        when:
        def result1 = calculator.plus(a, b)
        def result2 = Math.max(a, b)

        then:
        expectedResult1 == result1
        expectedResult2 == result2

        where:
        a << [1, 10]
        b << [2, 3]
        expectedResult1 << [3, 13]
        expectedResult2 << [2, 10]
    }

    def "should calculate correctly - in table"() {
        when:
        def result1 = calculator.plus(a, b)
        def result2 = Math.max(a, b)

        then:
        expectedResult1 == result1
        expectedResult2 == result2

        where:
        a  | b || expectedResult1 | expectedResult2 //double pipes
        1  | 2 || 3               | 2
        10 | 3 || 13              | 10
    }
    
    def "should calculate correctly - in table, with params"(int a, int b, int expectedResult1, int expectedResult2) {
        when:
        def result1 = calculator.plus(a, b)
        def result2 = Math.max(a, b)

        then:
        expectedResult1 == result1
        expectedResult2 == result2

        where:
        a  | b || expectedResult1 | expectedResult2 //double pipes
        1  | 2 || 3               | 2
        10 | 3 || 13              | 10
    }

    def "should calculate correctly with Math.pow"() {
        when:
        def result = Math.pow(a, 2)

        then:
        result == a * a

        where:
        a << [1, 3, 4, 5]
    }

    def "should calculate correctly with Math.pow with table"() {
        when:
        def result = Math.pow(a, 2)

        then:
        result == a * a

        where:
        a | _
        1 | _
        2 | _
        5 | _
    }
}
