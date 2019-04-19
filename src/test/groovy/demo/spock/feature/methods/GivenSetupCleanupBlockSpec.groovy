package demo.spock.feature.methods

import demo.spock.calculator.Calculator
import spock.lang.Specification

class GivenSetupCleanupBlockSpec extends Specification {

    def calculator = new Calculator()

    def setup() {
        println "setup specification"
    }

    def cleanup() {
        println "cleanup specification"
    }

    def "should check 'setup' block behaviour"() {
        setup:
        println "setup method in test"
        def a = 1
        def b = 3

        expect:
        calculator.plus(a, b) == 4
    }

    def "should check 'given' block behaviour"() {
        given:
        println "given method in test"
        def a = 1
        def b = 3

        expect:
        calculator.plus(a, b) == 4
    }

    def "should check 'given' if given block is optional"() {
        println "method in test"

        def a = 1
        def b = 3

        expect:
        calculator.plus(a, b) == 4

        cleanup:
        println "cleanup block in test"
    }
}
