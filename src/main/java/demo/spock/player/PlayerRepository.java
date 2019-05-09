package demo.spock.player;

import java.util.List;

public interface PlayerRepository {
    List<Player> findAll();
    Player findOne(Long id);
    Player save(Player player);
}
