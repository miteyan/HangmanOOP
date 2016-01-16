import java.util.Scanner;

/**
 * Created by miteyan on 20/12/2015.
 */
public class UserInput {
    private static UserInput instance = null;
    private Scanner input;
// singleton - only one instance needed

    private UserInput() {
        input = new Scanner(System.in);
    }

    public static UserInput getInstance() {
        if (instance == null) {
            instance = new UserInput();
        }
        return instance;
    }

    public String aWord() {
        return input.nextLine();
    }

    public char getDifficulty() {
        char d = input.nextLine().charAt(0);
        while (d != 'e' && d != 'm' && d != 'h'){
            System.out.println("Choose appropriate difficulty");
            d = input.nextLine().charAt(0);
        }
        return  d;
    }

}
