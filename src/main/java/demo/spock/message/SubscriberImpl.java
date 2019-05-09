package demo.spock.message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubscriberImpl implements Subscriber {

    private Map<Long, Message> messages = new HashMap<>();

    @Override
    public void receive(String message) {
        System.out.println("Message is receive");
        messages.put((long) messages.size(), new Message(message));
    }

    @Override
    public boolean verify() {
        System.out.println("Verify");
        return false;
    }

    @Override
    public Message find(Long id) {
        return messages.get(id);
    }

    @Override
    public List<Message> list() {
        return new ArrayList<>(messages.values());
    }
}
