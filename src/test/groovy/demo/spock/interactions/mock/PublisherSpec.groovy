package demo.spock.interactions.mock

import demo.spock.message.Publisher
import demo.spock.message.Subscriber
import spock.lang.Specification

class PublisherSpec extends Specification {

    def subscriber1 = Mock(Subscriber)
    def subscriber2 = Mock(Subscriber)

    def publisher = new Publisher([subscriber1])

    def setup() {
        publisher.subscribers << subscriber2 // << is a Groovy shorthand for List.add()
    }

    def "should send messages to all subscribers"() {
        when:
        publisher.send("hello")

        then:
        1 * subscriber1.receive("hello")
        1 * subscriber2.receive("hello")
    }

    def "should send messages to subscriber1 (show combination of interactions)"() {
        when:
        publisher.send("hello")

        then:
        2 * _.receive("hello")                   // a call to any mock object

//        // Cardinality
//        1 * subscriber.receive("hello")        // exactly one call
//        0 * subscriber.receive("hello")        // zero calls
//        (1..3) * subscriber.receive("hello")   // between one and three calls (inclusive)
//        (1.._) * subscriber.receive("hello")   // at least one call
//        (_..3) * subscriber.receive("hello")   // at most three calls
//        _ * subscriber.receive("hello")        // any number of calls, including zero
//                                               // (rarely needed; see 'Strict Mocking')

//        // Target Constraint
//        1 * subscriber.receive("hello")        // a call to 'subscriber'
//        1 * _.receive("hello")                 // a call to any mock object

//        // Method Constraint
//        1 * subscriber.receive("hello")       // a method named 'receive'
//        1 * subscriber./r.*e/("hello")        // a method whose name matches the given regular expression
//                                              // (here: method name starts with 'r' and ends in 'e')

//        // Argument Constraints
//        1 * subscriber.receive("hello")        // an argument that is equal to the String "hello"
//        1 * subscriber.receive(!"hello")       // an argument that is unequal to the String "hello"
//        0 * subscriber.receive()               // the empty argument list (would never match in our example)
//        1 * subscriber.receive(_)              // any single argument (including null)
//        1 * subscriber.receive(*_)             // any argument list (including the empty argument list)
//        1 * subscriber.receive(!null)          // any non-null argument
//        1 * subscriber.receive(_ as String)    // any non-null argument that is-a String
//        1 * subscriber.receive(endsWith("lo")) // any non-null argument that is-a String
//        1 * subscriber.receive({ it.size() > 3 && it.contains('a') })
//                                                // an argument that satisfies the given predicate, meaning that
//                                                // code argument constraints need to return true of false
//                                                // depending on whether they match or not
//                                                // (here: message length is greater than 3 and contains the character a)
    }

    def "should send messages to all subscribers with null value"() {
        when:
        publisher.send(null)

        then:
        1 * subscriber1.receive(_)
//        0 * subscriber1.receive(_ as Object)
//        0 * subscriber1.receive()
//        0 * subscriber1.receive(!null)
    }
}
