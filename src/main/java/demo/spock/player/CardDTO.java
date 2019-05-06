package demo.spock.player;

import java.util.Objects;

public class CardDTO {

    private String cardNumber;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CardDTO cardDTO = (CardDTO) o;

        return Objects.equals(cardNumber, cardDTO.cardNumber);

    }

    @Override
    public int hashCode() {
        return cardNumber != null ? cardNumber.hashCode() : 0;
    }
}
