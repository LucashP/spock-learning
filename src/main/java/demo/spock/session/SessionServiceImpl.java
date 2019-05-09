package demo.spock.session;

import java.util.UUID;

public class SessionServiceImpl implements SessionService {

    public String login(Long playerId) {
        return "SESSIONID = " + UUID.randomUUID().toString();
    }
}
