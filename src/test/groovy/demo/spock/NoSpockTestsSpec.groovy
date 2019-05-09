package demo.spock

import spock.lang.Specification

class NoSpockTestsSpec extends Specification {

    def "it is not a test"() {
        println "it is not a test #1"
    }

    def "it is dummy test"() {
        given:
        println "it is dummy test"
    }
}
