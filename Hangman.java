import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by miteyan on 20/12/2015.
 */
public abstract class Hangman {

    public Hangman(int guesses){
        this.maxGuesses = guesses;
        playGame();
    }

    private RandomWord randomWord = new RandomWord();
    private TextUI ui= TextUI.getInstance();
    private UserInput uInput = UserInput.getInstance();

    private int guessesHad = 0;
    private int maxGuesses;
    private int  totalLettersFound = 0;
    private int currentLettersFound = 0;

    private String wordBeingGuessed = randomWord.getRandWord(); //Word being guessed as string
    private char[] word = wordBeingGuessed.toCharArray();  // Random word stored as a char array for each letter
    private int wordLength = word.length;           //length of the word being guessed
    private char[] lettersFound = new char[wordLength]; //False is letter not found, true if found
    private String fullGuess = null;                   // if full word guessed
    private char letterGuess;               // if guessed a letter
    private boolean finished = false; //if true game is won
    private ArrayList<Character> incorrectGuesses= new ArrayList<Character>();




    public void playGame() {//play game whilst word not guessed
        guessesHad = 0;
        while(!finished) {
            ui.showGallows(guessesHad,maxGuesses);
            checkGuess();
            ui.printGuesses(guessesHad);
            ui.printGuess(lettersFound);
            ui.printIncorrect(incorrectGuesses);
        }
    }
        // set letters found from the word to be true if found


    public void setLettersFound(char letterGuessed) {

        for(int i = 0; i<wordLength; i++) {
            if(letterGuessed == word[i]){  //letter is in the word
                lettersFound[i]=letterGuessed;
                currentLettersFound +=1;
            }else if (!Character.isLetter(lettersFound[i])) {   //letter is not in the word, set to blank
                lettersFound[i]='_';
            }
        }

        if (totalLettersFound ==currentLettersFound) {
            System.out.println("Incorrect letter guess");
            guessesHad++;

            if(!incorrectGuesses.contains(letterGuessed)) {//add to array of already guessed words
                incorrectGuesses.add(letterGuessed);
            }
        }else{
            totalLettersFound=currentLettersFound;
        }//increment incorrect guesses
    }



        //setter for correctGuess,true if full guess equals the word.
    public void isFullGuessCorrect(String fullGuess) {
        if( (fullGuess.toLowerCase()).equals(wordBeingGuessed) ) {
            finished = true;  //game over
            ui.printWon();

        }else if (!fullGuess.equals(wordBeingGuessed)){
            guessesHad++;
            System.out.println("Incorrect Word Guess");
        }
    }




        //set users guess to be a full word or just char and checks if it is the word
    public void checkGuess() {
        ui.enterGuess();

        fullGuess = uInput.aWord();

        if (fullGuess.length()==1){
            letterGuess= Character.toLowerCase(fullGuess.charAt(0));
            setLettersFound(letterGuess);
            fullGuess=null;
        } else {
            isFullGuessCorrect(fullGuess);
        }
        if (guessesHad == maxGuesses) {
//            ui.printLoss();
            finished = true;
            ui.deadman();
            ui.printLoss();
        }
    }
}
