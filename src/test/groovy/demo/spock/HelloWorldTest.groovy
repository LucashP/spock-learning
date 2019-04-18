package demo.spock

import spock.lang.Specification

class HelloWorldTest extends Specification {

    def "should run first spock test"() {
        def word = "Hello World"

        expect:
        word.size() == 11
    }
}
