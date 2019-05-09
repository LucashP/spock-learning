package demo.spock.feature.methods

import demo.spock.player.Player
import org.junit.Assert
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
        //same as
        assert stack2.size() == 1
        Assert.assertEquals(1, stack2.size())

        expect:
        stack1.empty()
    }

    def "should show requirements for checking assertions"() {
        given:
        def stack = new Stack()
        !stack.empty() // for spock it is not assertion

        expect:
        1 == 1
    }

    def "should show requirements for checking assertions - explicit assertion in 'given' block"() { // try to avoid
        given:
        def stack = new Stack()

        assert stack.empty()
        Assert.assertEquals(0, stack.size())

        expect:
        1 == 1
    }

    def "should show requirements for checking assertions - explicit assertion in 'when' block"() { // wrong convention
        given:
        def stack = new Stack()

        when:
        stack.push(new Player())
        assert !stack.empty()

        then:
        1 == 1
    }
}
