package demo.spock.extensions

import spock.lang.Ignore
import spock.lang.IgnoreRest
import spock.lang.Specification
import spock.lang.Timeout

class ExtensionsSpec extends Specification {

    def "should be ignored #1"() {
        expect:
        1 == 1
        println "should be ignored #1"
    }

    @Ignore
    def "should be ignored #2"() {
        expect:
        1 == 1
        println "should be ignored #2"
    }

    def "should be ignored #3"() {
        expect:
        1 == 1
        println "should be ignored #3"
    }

    def "should be ignored #4"() {
        expect:
        1 == 1
        println "should be ignored #4"
    }

    @IgnoreRest
    @Timeout(value = 3)
    def "should works"() {
        expect:
        1 == 1
        println "should works"
    }
}
