package demo.spock.helper.methods

import demo.spock.calculator.Calculator
import spock.lang.Specification

class GroovyTruthSpec extends Specification {

    def calculator = new Calculator()

    def "should check default assertions"() {
        when:
        def nullObject = null
        def zeroNumber = 0
        def emptyString = ""

        then:
        verifyAll {
//            emptyString
//            nullObject
//            zeroNumber
            emptyString == "" //concrete check
            nullObject == null //concrete check
            zeroNumber == 0
        }
    }
}
