package demo.spock

import spock.lang.Specification

class HelloWorldSpec extends Specification {

    def "should run first spock test"() {
        def word = "Hello World"

        expect:
        word.size() == 11
    }
}
