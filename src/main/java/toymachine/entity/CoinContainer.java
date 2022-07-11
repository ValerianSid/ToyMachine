package toymachine.entity;

import toymachine.exceptions.WrongCoinException;

public class CoinContainer {
    private int coinnominal;

    public CoinContainer(int coinnominal) {
        this.coinnominal = coinnominal;
    }

    public int checkCoin() throws WrongCoinException {
        int numberOfTries;
        if (coinnominal % 50 == 0){
            numberOfTries = coinnominal / 50;
        }
        else {
            throw new WrongCoinException();
        }
        return numberOfTries;
    }
}
