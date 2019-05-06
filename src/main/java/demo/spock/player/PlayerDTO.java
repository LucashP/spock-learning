package demo.spock.player;

import java.util.Objects;
import java.util.Set;

public class PlayerDTO {

    private Long id;
    private String name;
    private PlayerStatus status;
    private Set<CardDTO> cards;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerStatus getStatus() {
        return status;
    }

    public void setStatus(PlayerStatus status) {
        this.status = status;
    }

    public Set<CardDTO> getCards() {
        return cards;
    }

    public void setCards(Set<CardDTO> cards) {
        this.cards = cards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlayerDTO playerDTO = (PlayerDTO) o;

        if (!Objects.equals(id, playerDTO.id)) return false;
        if (!Objects.equals(name, playerDTO.name)) return false;
        if (status != playerDTO.status) return false;
        return Objects.equals(cards, playerDTO.cards);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (cards != null ? cards.hashCode() : 0);
        return result;
    }
}
