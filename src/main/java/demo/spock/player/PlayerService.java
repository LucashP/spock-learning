package demo.spock.player;

import demo.spock.bonus.BonusService;
import demo.spock.session.SessionService;

import java.util.List;

public class PlayerService {

    private final PlayerRepository playerRepository;
    private final SessionService sessionService;
    private final BonusService bonusService;

    public PlayerService(PlayerRepository playerRepository, SessionService sessionService, BonusService bonusService) {
        this.playerRepository = playerRepository;
        this.sessionService = sessionService;
        this.bonusService = bonusService;
    }

    public void login(Long playerId) {
        Player player = playerRepository.findOne(playerId);
        if (bonusService.checkIfBonusAreAvailableForPlayer(player.getId())) {
            bonusService.addBonusForPlayer(player.getId());
        }
        sessionService.login(player.getId());
    }

    public Player save(Player player) {
        return playerRepository.save(player);
    }

    public List<Player> findAll() {
        return playerRepository.findAll();
    }
}
