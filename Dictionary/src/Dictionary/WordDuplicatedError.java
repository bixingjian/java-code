package Dictionary;

public class WordDuplicatedError extends RuntimeException{
    public WordDuplicatedError(Dictionary dictionary) {
        dictionary.hasError = true;
        if ("".equals(dictionary.TextArea.getText())) {
            dictionary.TextArea.setText(dictionary.TextArea.getText() + "Word duplicated!!");
        }
        else {
            dictionary.TextArea.setText(dictionary.TextArea.getText() + "\n" + "Word duplicated!!");
        }
//        System.exit(0);
    }
}
