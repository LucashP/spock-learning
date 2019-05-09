package demo.spock.message;

import java.util.List;

public interface Subscriber {
    void receive(String message);

    boolean verify();

    Message find(Long id);

    List<Message> list();
}