package demo.spock.fixture.methods.junit

import demo.spock.calculator.Calculator
import org.junit.After

class FixtureMethodsWithSpec extends BaseWithSpec {

    def calculator = new Calculator()

    def setupSpec() {
        println "calculator setupSpec" // runs once -  before the first feature method
    }

    def setup() {
        println "calculator setup" // runs before every feature method
    }

    @After
    def completelyChangedNameMethod() {
        println "calculator cleanup" // runs after every feature method
    }

    def cleanupSpec() {
        println "calculator cleanupSpec" // runs once -  after the last feature method
    }

    def "should show fixture methods #1"() {
        expect:
        calculator

        println calculator
    }

    def "should show fixture methods #2"() {
        expect:
        calculator

        println calculator
    }
}
