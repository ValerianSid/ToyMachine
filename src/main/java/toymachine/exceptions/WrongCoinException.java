package toymachine.exceptions;

public class WrongCoinException extends Exception{

    public WrongCoinException() {
        super("Проверьте количество игрушек в автомате");
    }
}
