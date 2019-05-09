package demo.spock.message;

import java.util.List;

public class Publisher {
    private List<Subscriber> subscribers;
    private int messageCount = 0;

    public Publisher(List<Subscriber> subscribers) {
        this.subscribers = subscribers;
    }

    public void send(String message) {
        subscribers.forEach(subscriber -> subscriber.receive(message));
        messageCount++;
    }

    public boolean verify() {
        return subscribers.get(0).verify();
    }

    public Message find(Long id) {
        return subscribers.get(0).find(id);
    }

    public List<Message> list() {
        return subscribers.get(0).list();
    }

    public List<Subscriber> getSubscribers() {
        return subscribers;
    }
}
