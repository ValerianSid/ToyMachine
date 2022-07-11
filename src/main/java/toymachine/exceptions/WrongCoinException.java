package toymachine.exceptions;

public class WrongCoinException extends Exception{

    public WrongCoinException() {
        super("Заберите монеты и попробуйте снова");
    }
}
