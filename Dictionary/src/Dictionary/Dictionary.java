package Dictionary;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Dictionary {
    public JPanel dictionary;
    public JButton CLEARButton;
    public JButton REMOVEButton;
    public JTextArea TextArea;
    public JButton FINDButton;
    public JButton IMPORTButton;
    public JTextField TextFreqWord1;
    public JTextField TextFreqWord2;
    public JTextField TextFreqWord3;
    public JTextField TextFilePath;
    public JButton ADDButton;
    public JTextField TextWord;
    public JTextField TextFrequency;
    public JButton EXPORTButton;

    public String word = "";
    public String findWord = "";
    public String freq = "1";
    public String meaning = "";

    public String removeWord = "";

    int wordFreqCounter = 0;

    public boolean hasError = false;

    public boolean hasWord = false;

    ArrayList<String> errorMessages = new ArrayList<>();

    ArrayList<String[]> storage = new ArrayList<>();


    /**
     * This is the constructor for Dictionary class, it contains the construction of actionListeners.
     * @author Xingjian Bi
     * @version 1.0
     */
    public Dictionary() {
        CLEARButton.addActionListener(e -> {
            TextWord.setText("");
            TextFrequency.setText("");
            TextFreqWord1.setText("");
            TextFreqWord2.setText("");
            TextFreqWord3.setText("");
            TextArea.setText("");
            TextFilePath.setText("");
        });


        /**
         * This is the ADDButton implementation, it will raise InvalidWordError, WordDuplicatedError, InvalidFrequencyError
         * @author Xingjian Bi
         * @version 1.0
         */
        ADDButton.addActionListener(e -> {
            word = TextWord.getText();
            if ("".equals(word)) {
                throw new InvalidWordError(this);
            }
            for (char ch : word.toCharArray()) {
                if (!Character.isLetter(ch)) {
                    throw new InvalidWordError(this); // if there's an error, it will go to catch block.
                }
            }
            for(String[] element : storage) {
                if (word.equals(element[0])) {
                    throw new WordDuplicatedError(this);
                }
            }
//            }
//            catch (InvalidWordError ee) {
//                hasError = true;
//                String a = TextArea.getText();
//                if ("".equals(TextArea.getText())) {
//                    TextArea.setText(TextArea.getText() + ee.getMessage());
//                }
//                else {
//                    TextArea.setText(TextArea.getText() + "\n" + ee.getMessage());
//                }
//                System.out.println(ee.getMessage());
//            }
//            catch (InvalidWordError ee) {
//                throw new InvalidWordError(this);
//            }
//            catch (WordDuplicatedError ee) {
//                hasError = true;
//                String a = TextArea.getText();
//                if ("".equals(TextArea.getText())) {
//                    TextArea.setText(TextArea.getText() + ee.getMessage());
//                }
//                else {
//                    TextArea.setText(TextArea.getText() + "\n" + ee.getMessage());
//                }
//                System.out.println(ee.getMessage());
////                System.exit(0);
//
//            }
//            catch (WordDuplicatedError ee) {
//                throw new WordDuplicatedError(this);
//            }

            freq = TextFrequency.getText();
            if ("".equals(TextFrequency.getText())) {
                freq = "1";
            }
//            try {
                if (!(freq.chars().allMatch( Character::isDigit )) || Integer.parseInt(freq) < 0) {
                    throw new InvalidFrequencyError(this);
                }
//            }
//            catch (InvalidFrequencyError ee) {
//                throw new InvalidFrequencyError(this);
//                    hasError = true;
//                    if ("".equals(TextArea.getText())) {
//                        TextArea.setText(TextArea.getText() + ee.getMessage());
//                    }
//                    else {
//                        TextArea.setText(TextArea.getText() + "\n" + ee.getMessage());
//                    }
//                    System.out.println(ee.getMessage() + "1");
//                System.exit(0);
//                }

            meaning = TextArea.getText();
//            System.out.println(meaning);

            String[] element = {word, freq, meaning};
            storage.add(element);

//            for (int i = 0; i < storage.size(); i++) {
//                String[] myString = storage.get(i);
//                for (int j = 0; j < myString.length; j++) {
//                    System.out.println(myString[j]);
//                }
////                System.out.println("");
//            }

            word = "";
            freq = "1";
            meaning = "";

            // clear the console:
            TextWord.setText("");
            TextFrequency.setText("");
            TextFreqWord1.setText("");
            TextFreqWord2.setText("");
            TextFreqWord3.setText("");
            if (!hasError) {
                TextArea.setText("");
            }
        });

        FINDButton.addActionListener(e -> {
            TextArea.setText("");
            findWord = TextWord.getText();
            String[] foundWords = {"", "", ""};
            String[] foundMeanings = {"", "", ""};
            // TODO
            Collections.sort(storage, Comparator.comparing(a -> Integer.parseInt(a[1])));
            Collections.reverse(storage);
            for (String[] element : storage) {
                if (element[0].startsWith(findWord)) {
                    if (wordFreqCounter < 3) {
                        foundWords[wordFreqCounter] = element[0];
                        foundMeanings[wordFreqCounter] = element[2];
                        wordFreqCounter += 1;
                    }
                    else {
                        break;
                    }
                }
            }

            if ("".equals(foundWords[0]) && "".equals(foundWords[1]) & "".equals(foundWords[2]) ) {
                throw new WordNotFoundError(this);
            }

            TextFreqWord1.setText(foundWords[0]);
            TextArea.setText(TextArea.getText() + foundMeanings[0] + "\n");
            TextFreqWord2.setText(foundWords[1]);
            TextArea.setText(TextArea.getText() + foundMeanings[1] + "\n");
            TextFreqWord3.setText(foundWords[2]);
            TextArea.setText(TextArea.getText() + foundMeanings[2] + "\n");


            findWord = "";
            wordFreqCounter = 0;
        });

        REMOVEButton.addActionListener(e -> {
//            try{
            removeWord = TextWord.getText();
            for (String[] element : storage) {
                if (removeWord.equals(element[0])) {
                    hasWord = true;
                    storage.remove(element);
//                    for (int i = 0; i < storage.size(); i++) {
//                        String[] myString = storage.get(i);
//                        for (int j = 0; j < myString.length; j++) {
//                            System.out.println(myString[j]);
//                        }
//                    }
                    return;
                }
            }
            TextArea.setText("removed");

            if (!hasWord) {
                throw new WordNotFoundError(this);
            }
//            }
//            catch (WordNotFoundError ee) {
//                hasError = true;
//                String a = TextArea.getText();
//                if ("".equals(TextArea.getText())) {
//                    TextArea.setText(TextArea.getText() + ee.getMessage());
//                }
//                else {
//                    TextArea.setText(TextArea.getText() + "\n" + ee.getMessage());
//                }
//                System.out.println(ee.getMessage());
//            }
            TextWord.setText("");
            hasWord = false;
        });

        EXPORTButton.addActionListener(e -> {
            PrintWriter outputStream = null;
            try {
                String fileName = "src/Dictionary/" + TextFilePath.getText();
                File file = new File(fileName);
//                if (file.isDirectory() || !(file.exists())) {
//                    System.out.println("good");
//                    throw new FileNotFoundException();
//                }
                Collections.sort(storage, Comparator.comparing(a -> Integer.parseInt(a[1])));
                Collections.reverse(storage);
                outputStream = new PrintWriter(new FileOutputStream(fileName));
                for (int i = 0; i < storage.size(); i++) {
                    String[] myString = storage.get(i);
                    for (int j = 0; j < myString.length; j++) {
                        outputStream.println(myString[j]);
                    }
                    outputStream.println("");
                }
                TextFilePath.setText("");
                TextArea.setText("File exported");
            } catch (Exception ee) {
//                hasError = true;
//                String a = TextArea.getText();
//                if ("".equals(TextArea.getText())) {
//                    TextArea.setText(TextArea.getText() + ee.getMessage());
//                }
//                else {
//                    TextArea.setText(TextArea.getText() + "\n" + ee.getMessage());
//                }
                throw new FileNotFoundException(this);
//                System.out.println(ee.getMessage());
            }
            finally {
                if (outputStream != null) {
                    outputStream.close();
                }
            }
        });

        IMPORTButton.addActionListener(e -> {
            BufferedReader inputStream = null;
            String[] wordsTOImport = {"", "", ""};
            try {
                String fileName = "src/Dictionary/" + TextFilePath.getText();
//                File file = new File(fileName);
//                if (file.isDirectory() || !(file.exists())) {
//                    System.out.println("good");
//                    throw new FileNotFoundException(this);
//                }
                int counter = 1;
                inputStream = new BufferedReader(new FileReader(fileName));
                String strLine;
                while ((strLine = inputStream.readLine()) != null) {
                    if (strLine.equals("")) {
                        continue;
                    }
                    if (counter % 3 == 1) {
                        wordsTOImport[0] = strLine;
                        counter += 1;
                    }
                    else if (counter % 3 ==2) {
                        wordsTOImport[1] = strLine;
                        counter += 1;
                    }
                    else {
                        wordsTOImport[2] = strLine;
                        counter += 1;
                        String[] add = {wordsTOImport[0], wordsTOImport[1], wordsTOImport[2]};
                        storage.add(add);
                    }
                }
                TextFilePath.setText("");
                TextArea.setText("File Imported");
//                for (int i = 0; i < storage.size(); i++) {
//                    String[] myString = storage.get(i);
//                    for (int j = 0; j < myString.length; j++) {
//                        System.out.println(myString[j]);
//                    }
//                    System.out.println("");
//                }

            } catch (Exception ee) {
//                hasError = true;
//                String a = TextArea.getText();
//                if ("".equals(TextArea.getText())) {
//                    TextArea.setText(TextArea.getText() + ee.getMessage());
//                } else {
//                    TextArea.setText(TextArea.getText() + "\n" + ee.getMessage());
//                }
//                System.out.println(ee.getMessage());
                throw new FileNotFoundException(this);

            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }

            }
        });


    }

    /**
     * This is the main function for the Dictionary project.
     * @param args
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Dictionary");
        frame.setContentPane(new Dictionary().dictionary);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
