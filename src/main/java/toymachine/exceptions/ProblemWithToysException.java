package toymachine.exceptions;

public class ProblemWithToysException extends Exception {

    public ProblemWithToysException(String name) {
        super("Проверьте количество игрушек");
    }
}
