package demo.spock.feature.methods

import demo.spock.player.Player
import spock.lang.Specification

class AssertionsPositionSpec extends Specification {

    def "should show requirements for checking assertions - 'expect' and 'then' blocks with automatic assertions"() {
        given:
        def stack1 = new Stack()
        def stack2 = new Stack()

        when:
        stack2.push(new Player())

        then:
        stack2.size() == 1

        expect:
        stack1.empty()
    }

    def "should show requirements for checking assertions"() {
        given:
        def stack = new Stack()
        !stack.empty()

        expect:
        1 == 1
    }

    def "should show requirements for checking assertions - assertion in 'given' block"() {
        given:
        def stack = new Stack()
        assert stack.empty()

        expect:
        1 == 1
    }

    def "should show requirements for checking assertions - assertion in 'when' block"() { // wrong convention
        given:
        def stack = new Stack()

        when:
        stack.push(new Player())
        assert !stack.empty()

        then:
        1 == 1
    }
}
