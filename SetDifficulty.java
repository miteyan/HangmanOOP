/**
 * Created by miteyan on 20/12/2015.
 */
public class SetDifficulty {

    private UserInput uInput = UserInput.getInstance();


    public Hangman getDifficulty() {
        System.out.print("Select difficulty Easy('e'), Medium('m'), Hard('h'): ");
        char d = uInput.getDifficulty();
        Hangman game = null;
        switch (d){
            case 'e':  return game = new Easy();
            case 'm':  return game = new Hard();
            case 'h':  return game = new Hard();
        }
            return game;
    }

}
