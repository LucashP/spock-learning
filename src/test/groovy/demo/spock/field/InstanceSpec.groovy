package demo.spock.field

import demo.spock.calculator.Calculator
import spock.lang.Shared
import spock.lang.Specification

class InstanceSpec extends Specification {

    def calculator = new Calculator()
    def setupCalculator

    @Shared
    def sharedCalculator = new Calculator()
    static staticCalculator = new Calculator()

    def setup() {
        setupCalculator = new Calculator() // same as calculator
    }

    def "should check different instances of tested class #1"() {
        expect:
        calculator
        sharedCalculator
        staticCalculator

        println calculator
        println sharedCalculator
        println staticCalculator
        println setupCalculator
        println "######################################################"
    }

    def "should check different instances of tested class #2"() {
        expect:
        calculator
        sharedCalculator
        staticCalculator

        println calculator
        println sharedCalculator
        println staticCalculator
        println setupCalculator
        println "######################################################"
    }
}
