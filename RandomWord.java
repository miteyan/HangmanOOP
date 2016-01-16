import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by miteyan on 20/12/2015.
 */
public class RandomWord {
    private UserInput user;
    private String dictionary;


    private final String filename = "/Users/miteyan/uk/ac/cam/mp781/oopjava/Hangman/src/words.txt";
    private Random rand;
    private ReadFile rf = new ReadFile();

    public  String getRandWord(){
        List<String> array = rf.arrayfromfile(filename);
        Random rand = new Random();
        String word="12345678910";

        while(word.length()>10) {
            word = array.get(rand.nextInt(array.size()));
        }
        return word;
    }

}
