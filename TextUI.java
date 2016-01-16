import java.util.ArrayList;

/**
 * Created by miteyan on 20/12/2015.
 */
public class TextUI {

    private static TextUI mTextUI = null;
// singleton - only one instance needed
    private TextUI(){}

    public static TextUI getInstance() {
        if(mTextUI==null){
            mTextUI = new TextUI();
        }
        return mTextUI;
    }

    public void printGuess(char[] guesses) {
        System.out.print("Letters found:     ");
        for (int i = 0 ; i < guesses.length ; i++){
            System.out.print(guesses[i] + " ");
        }
        System.out.println();
    }


    public void showGallows(int guessesHad,int maxGuesses) {
        System.out.println();
        float ratio = 6f/(float)maxGuesses;
        int position;
        // Calculates which stage to print depending on the guesses
        position = Math.round(guessesHad*ratio);
        switch (position){
            case 0: stage1(); return;
            case 1: stage2(); return;
            case 2: stage3(); return;
            case 3: stage4(); return;
            case 4: stage5(); return;
            case 5: stage6(); return;
            case 6: deadman();  return;
        }
    }
    public void printGuesses(int guessesHad){
        System.out.println("Guesses had: "+guessesHad);
    }


    public void deadman()
    {
        System.out.println("_____");
        System.out.println("|   |");
        System.out.println("|   o");
        System.out.println("|  /|\\");
        System.out.println("|  / \\");
    }

    public void stage1()
    {
        System.out.println("_____");
        System.out.println("|   |");
        System.out.println("|   ");
        System.out.println("|   ");
        System.out.println("|   ");
    }

    public void stage2()
    {
        System.out.println("_____");
        System.out.println("|   |");
        System.out.println("|   o");
        System.out.println("|    ");
        System.out.println("|    ");
    }

    public void stage3()
    {
        System.out.println("_____");
        System.out.println("|   |");
        System.out.println("|   o");
        System.out.println("|   | ");
        System.out.println("|    ");
    }

    public void stage4()
    {
        System.out.println("_____");
        System.out.println("|   |");
        System.out.println("|   o");
        System.out.println("|  /| ");
        System.out.println("|    ");
    }

    public void stage5()
    {
        System.out.println("_____");
        System.out.println("|   |");
        System.out.println("|   o");
        System.out.println("|  /|\\ ");
        System.out.println("|    ");
    }

    public void stage6()
    {
        System.out.println("_____");
        System.out.println("|   |");
        System.out.println("|   o");
        System.out.println("|  /|\\ ");
        System.out.println("|    \\");
    }

    public void enterGuess(){
        System.out.println();
        System.out.print("Enter Guess: ");
    }
    public void printWon() {
        System.out.println("You guessed correctly!");
    }
    public void printLoss() {
        System.out.println("You lost");
    }

    public void printDifficulty(){
        System.out.println("Enter number of guesses wanted: ");
    }
    public void printIncorrect(ArrayList<Character> list){
        System.out.println("Incorrect Guesses: " + list.toString());
    }

}
