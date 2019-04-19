package demo.spock.session;

import java.util.UUID;

public class SessionService {

    public String login(Long playerId) {
        return "SESSIONID = " + UUID.randomUUID().toString();
    }
}
