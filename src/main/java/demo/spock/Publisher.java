package demo.spock;

import java.util.ArrayList;
import java.util.List;

public class Publisher {
    private List<Subscriber> subscribers = new ArrayList<>();
    private int messageCount = 0;

    public void send(String message) {
        subscribers.forEach(subscriber -> subscriber.receive(message));
        messageCount++;
    }

    public List<Subscriber> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(List<Subscriber> subscribers) {
        this.subscribers = subscribers;
    }

    public int getMessageCount() {
        return messageCount;
    }

    public void setMessageCount(int messageCount) {
        this.messageCount = messageCount;
    }
}
