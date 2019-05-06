package demo.spock.interactions.stub

import demo.spock.Publisher
import demo.spock.Subscriber
import spock.lang.Specification

class PublisherSpec extends Specification {

    def subscriber1 = Mock(Subscriber)
    def subscriber2 = Mock(Subscriber)

    def publisher = new Publisher()

    def setup() {
        publisher.subscribers << subscriber1 // << is a Groovy shorthand for List.add()
        publisher.subscribers << subscriber2
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
//        1 * subscriber1.receive("hello")        // exactly one call
//        0 * subscriber1.receive("hello")        // zero calls
//        (1..3) * subscriber1.receive("hello")   // between one and three calls (inclusive)
//        (1.._) * subscriber1.receive("hello")   // at least one call
//        (_..3) * subscriber1.receive("hello")   // at most three calls
//        _ * subscriber1.receive("hello")        // any number of calls, including zero
//                                                // (rarely needed; see 'Strict Mocking')
        2 * _.receive("hello")                    // a call to any mock object
    }

}
