package demo.spock.player;

import demo.spock.bonus.BonusService;
import demo.spock.session.SessionService;

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
        PlayerDTO playerDTO = playerRepository.findOne(playerId);
        if (bonusService.checkIfBonusAreAvailableForPlayer(playerDTO.getId())) {
            bonusService.addBonusForPlayer(playerDTO.getId());
        }
        sessionService.login(playerDTO.getId());
    }
}
