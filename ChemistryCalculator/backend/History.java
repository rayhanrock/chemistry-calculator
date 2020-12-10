package ChemistryCalculator.backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public interface History {

    //if there is no file named history.txt , a new file will be created. if already available the line will be added which is passed in.
     default void add(String line) throws FileNotFoundException {
        String txtFile = "history.txt";
        File history = new File(txtFile);

        PrintWriter writer;
        if (history.exists() && !history.isDirectory()) {
            writer = new PrintWriter(new FileOutputStream(new File(txtFile), true));
        } else {
            writer = new PrintWriter(history);
        }

        writer.println(line);
        writer.flush();
        writer.close();
    }
}
