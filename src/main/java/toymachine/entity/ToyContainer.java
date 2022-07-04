package toymachine.entity;

import toymachine.exceptions.ProblemWithToysException;

public class ToyContainer {
    private int toyNumber;

    public ToyContainer(int toyNumber) {
        this.toyNumber = toyNumber;
    }

    public void checkToyNumber() throws ProblemWithToysException{
        if (toyNumber > 10 || toyNumber < 2){
            throw new ProblemWithToysException();
        }

    }

    public void setToyNumber() {
        this.toyNumber = toyNumber - 1;
    }


}
