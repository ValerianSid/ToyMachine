package toymachine.exceptions;

public class ProblemWithToysException extends Exception {

    public ProblemWithToysException() {
        super("Проверьте количество игрушек");
    }
}
