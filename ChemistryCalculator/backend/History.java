package ChemistryCalculator.backend;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public interface History {
    default void add(String line) throws FileNotFoundException {


        String PATH = FileSystemView.getFileSystemView().getDefaultDirectory().getPath() + File.separator;
        String directoryName = PATH.concat("Chemistry Calculator");
        String txtFile = "history.txt";

        File directory = new File(directoryName);
        if (!directory.exists()){
            directory.mkdir();
        }

        File history = new File(directoryName,txtFile);

        PrintWriter writer;
        if (history.exists() && !history.isDirectory()) {
            writer = new PrintWriter(new FileOutputStream(new File(directoryName, txtFile), true));
        } else {
            writer = new PrintWriter(history);
        }

        writer.println(line);
        writer.flush();
        writer.close();
    }
}
