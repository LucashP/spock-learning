package demo.spock.player;

import java.util.List;

public interface PlayerService {

    void login(Long playerId);

    Player save(Player player);

    List<Player> findAll();
}
