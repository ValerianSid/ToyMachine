package toymachine.processmanager;

import toymachine.entity.CoinContainer;
import toymachine.entity.ToyContainer;
import toymachine.exceptions.ProblemWithToysException;
import toymachine.exceptions.WrongCoinException;
import toymachine.services.IOService;
import toymachine.services.IOServiceImpl;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ToyMachine {

        private CoinContainer coinContainer;
        private ToyContainer toyContainer;
        private IOService ioService;

    public ToyMachine() {
        this.coinContainer = new CoinContainer(700);
        this.toyContainer = new ToyContainer(3);
        this.ioService = new IOServiceImpl();
    }

    public void start(){
        int numberOfTries = checkCoin();
        playaGame(numberOfTries);

    }

    private void playaGame(int numberOfTries){
        int numberOfGame = readFromFile();
        for (int i = 1; i <= numberOfTries & checkToyNumber() == true; i++) {
                if (numberOfGame % 5 == 0) {
                    ioService.write("ПОБЕДА");
                    changeToyNumber();
                } else {
                    ioService.write("Проиграли");
                }
                numberOfGame = numberOfGame + 1;
                writeInFile(numberOfGame);
            }


    }

    private boolean checkToyNumber(){
        try {
            if(toyContainer.checkToyNumber()){
                return true;
            }
        } catch (ProblemWithToysException e) {
            ioService.write(e.getMessage());
        }
        return false;
    }

    private void changeToyNumber(){
        toyContainer.setToyNumber();
    }

    private int checkCoin(){
        int number = 0;
        try {
            number = coinContainer.checkCoin();
        } catch (WrongCoinException e) {
            ioService.write(e.getMessage());
        }
        return number;
    }

    private int readFromFile(){
        int numberOfGame = 0;
        try(FileReader reader = new FileReader("WinOrLose.txt"))
        {
            numberOfGame = Integer.valueOf(reader.read());
        }
        catch(IOException e){

            ioService.write(e.getMessage());
        }
        return numberOfGame;
    }

    private void writeInFile(int numberOfGame){
        try(FileWriter writer = new FileWriter("WinOrLose.txt", false))
        {
            writer.write(numberOfGame);

        }
        catch(IOException e){
            ioService.write(e.getMessage());
        }

    }
}
