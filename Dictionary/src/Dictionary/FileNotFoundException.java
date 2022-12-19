package Dictionary;

public class FileNotFoundException extends RuntimeException{
    public FileNotFoundException(Dictionary dictionary) {
//        super("File not found or it is a dir, check again!!");
        dictionary.hasError = true;
        if ("".equals(dictionary.TextArea.getText())) {
            dictionary.TextArea.setText(dictionary.TextArea.getText() + "File not found!!");
        }
        else {
            dictionary.TextArea.setText(dictionary.TextArea.getText() + "\n" + "File not found!!");
        }
    }
}
