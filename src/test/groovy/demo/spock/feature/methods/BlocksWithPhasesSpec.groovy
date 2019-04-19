package demo.spock.feature.methods

import demo.spock.calculator.Calculator
import spock.lang.Specification

class BlocksWithPhasesSpec extends Specification {

    def calculator = new Calculator()

    def "should show connection between blocks and phases"() {
        given: 'setup'
        def i = 1

        when: 'stimulus'
        def result = calculator.plus(i, 1)

        then: 'response'
        result == i + 1

        expect: 'stimulus and response'
        Math.pow(j, 2) == j * j

        cleanup: 'cleanup'
        where: 'all phases'
        j << [1, 2, 3]
    }
}
