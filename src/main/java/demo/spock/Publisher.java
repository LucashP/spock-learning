package demo.spock;

import java.util.ArrayList;
import java.util.List;

class Publisher {
    List<Subscriber> subscribers = new ArrayList<>();
    int messageCount = 0;

    void send(String message) {
        subscribers.forEach(subscriber -> subscriber.receive(message));
        messageCount++;
    }
}

interface Subscriber {
    void receive(String message);
}
