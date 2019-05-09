package demo.spock.bonus;

public class BonusServiceImpl implements BonusService {

    public boolean checkIfBonusAreAvailableForPlayer(Long id) {
        return true;
    }

    public BonusDTO addBonusForPlayer(Long playerId) {
        return new BonusDTO();
    }
}
