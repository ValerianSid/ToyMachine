package toymachine.exceptions;

public class ProblemWithToysException extends Exception {

    public ProblemWithToysException() {
        super("Заберите ваши монеты. Требуется проверка количество игрушек");
    }
}
