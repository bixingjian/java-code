package Dictionary;

public class InvalidWordError extends RuntimeException{
//    public InvalidWordError() {
//        super("This is an invalid word!!");
//    }
    public InvalidWordError(Dictionary dictionary) {
        dictionary.hasError = true;
        if ("".equals(dictionary.TextArea.getText())) {
            dictionary.TextArea.setText(dictionary.TextArea.getText() + "This is an invalid word!!");
        }
        else {
            dictionary.TextArea.setText(dictionary.TextArea.getText() + "\n" + "This is an invalid word!!");
        }
//        System.out.println("This is an invalid word!!");
//        System.exit(0);
    }

}
