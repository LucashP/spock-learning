package demo.spock.feature.methods

import demo.spock.player.PlayerDTO
import spock.lang.Specification

class ExceptionsSpec extends Specification {

    def "should check if no exception is thrown"() {
        given:
        def stack = new Stack()
        stack.add(new PlayerDTO())

        when:
        stack.pop()

        then:
        notThrown(EmptyStackException)
    }

    def "should throw exception when we pop element from empty stack"() {
        given:
        def stack = new Stack()

        when:
        stack.pop()

        then:
        def ex = thrown(EmptyStackException)
        ex instanceof EmptyStackException
    }
}
