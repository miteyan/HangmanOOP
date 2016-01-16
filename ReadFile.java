

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by miteyan on 19/12/2015.
 */
public class ReadFile {

    public List<String> arrayfromfile(String file){
        List<String> words = new ArrayList<>();
        try {

            BufferedReader br = new BufferedReader(new FileReader(file));
//composite pattern - add functionality at runtime
            String str;

            while((str=br.readLine() )!=null) words.add(str);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }

}
