package demo.spock.player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerRepositoryImpl implements PlayerRepository {

    private Map<Long, Player> players = new HashMap<>();

    public List<Player> findAll() {
        throw new RuntimeException("Not implemented yet");
    }

    public Player findOne(Long id) {
        throw new RuntimeException("Not implemented yet");
    }

    public Player save(Player player) {
        long id = players.size();
        player.setId(id);
        players.put(id, player);
        return player;
    }
}
