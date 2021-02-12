package ChemistryCalculator.frontend;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;


public class HistoryFrame extends JFrame {
    private final JPanel mainPanel = new JPanel();
    private final JScrollPane mainScrollPane = new JScrollPane();
    private final JTextArea HistoryTextArea = new JTextArea();

    public HistoryFrame() throws IOException {
        initComponents();
        setComponentLayout();
    }

    private void setComponentLayout() {
        //mainpanel Layout
        GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                .addContainerGap(23, Short.MAX_VALUE)
                                .addComponent(mainScrollPane, GroupLayout.PREFERRED_SIZE, 670, GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20))
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(mainScrollPane, GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
        );

        //adding ainPanel to the frame
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }


    private void initComponents() throws IOException {
        mainPanel.setBackground(Color.white);
        mainScrollPane.setBorder(null);


        HistoryTextArea.setFont(new Font("Segoe UI", 0, 15));
        HistoryTextArea.setLineWrap(true);

        //collecting all the content from history.txt file
        String filePath = FileSystemView.getFileSystemView().getDefaultDirectory().getPath() + File.separator
                + "Chemistry Calculator" + File.separator
                + "history.txt";

        //sorting by date & time
        ArrayList<String> temp =new ArrayList<>();
        Files.lines(Paths.get(filePath)).forEach(line ->temp.add(line));
        for(int i=temp.size()-1;i>=0;i--) {
            HistoryTextArea.append(temp.get(i) +"\n");
        }

        HistoryTextArea.setWrapStyleWord(true);
        HistoryTextArea.setBorder(null);
        HistoryTextArea.setMargin(new Insets(3, 5, 3, 3));
        mainScrollPane.setViewportView(HistoryTextArea);


        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setBounds(100, 100, 750, 500);
        setIconImage(new ImageIcon(getClass().getResource("/ChemistryCalculator/icons/icons8_biohazard_120px.png")).getImage());
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Equation Balance - History");
    }


}
