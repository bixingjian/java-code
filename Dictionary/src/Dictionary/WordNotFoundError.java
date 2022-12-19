package Dictionary;

public class WordNotFoundError extends RuntimeException{
    public WordNotFoundError(Dictionary dictionary) {
        dictionary.hasError = true;
        if ("".equals(dictionary.TextArea.getText())) {
            dictionary.TextArea.setText(dictionary.TextArea.getText() + "Word not found!!");
        }
        else {
            dictionary.TextArea.setText(dictionary.TextArea.getText() + "\n" + "Word not found!!");
        }
//        System.exit(0);

    }
}
