package demo.spock.bonus;

public interface BonusService {

    boolean checkIfBonusAreAvailableForPlayer(Long id);

    BonusDTO addBonusForPlayer(Long playerId);
}
