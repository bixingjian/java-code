package Dictionary;

public class InvalidFrequencyError extends RuntimeException{
    public InvalidFrequencyError(Dictionary dictionary) {
        dictionary.hasError = true;
        if ("".equals(dictionary.TextArea.getText())) {
            dictionary.TextArea.setText(dictionary.TextArea.getText() + "Invalid Frequency!!");
        }
        else {
            dictionary.TextArea.setText(dictionary.TextArea.getText() + "\n" + "Invalid Frequency!!");
        }
//        System.out.println("This is an Invalid Frequency!!");
    }
}
