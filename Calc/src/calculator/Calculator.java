package calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Calculator {
    private JPanel calculator;
    private JTextField textField;
    private JButton oneBtn;
    private JButton squareBtn;
    private JButton divideBtn;
    private JButton mulBtn;
    private JButton minusBtn;
    private JButton addBtn;
    private JButton equalBtn;
    private JButton powerBtn;
    private JButton clearBtn;
    private JButton sevenBtn;
    private JButton fourBtn;
    private JButton zeroBtn;
    private JButton logBtn;
    private JButton signBtn;
    private JButton eightBtn;
    private JButton fiveBtn;
    private JButton twoBtn;
    private JButton digitBtn;
    private JButton sqrBtn;
    private JButton percentageBtn;
    private JButton nineBtn;
    private JButton sixBtn;
    private JButton threeBtn;

    private double result = 0.0;
    private String operator = "";
    static double firstNumber = 0.0, secondNumber = 0.0;
    private boolean calculating = true;

    private boolean errorCase = false;

    private double signNumber = 0.0;

    /**
     * This is the base class for number buttons, it implements the action listener interface.
     */
    private class numberBtnClicked implements ActionListener{
        private String number = "";

        public String getNumber() {
            return number;
        }

        /**
         * This is the method inside the base class to set the number for each button.
         * @param number the number to be set for each button.
         */
        public void setNumber(String number) {
            this.number = number;
        }
        public numberBtnClicked() {

        }
        public numberBtnClicked(String number) {
            setNumber(number);
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if(calculating){
                textField.setText("");
                if ((Objects.equals(this.number, ".")) && Objects.equals(textField.getText(), "")) {
                    textField.setText("0" + textField.getText() + number);
                }
                else {
                    textField.setText(textField.getText() + number);
                }
                calculating = false;
            }
            else{

                textField.setText(textField.getText() + number);
            }
        }
    }
    private class zeroBtnClicked extends numberBtnClicked{
        public zeroBtnClicked() {
            setNumber("0");;
        }
    }
    private class oneBtnClicked extends numberBtnClicked{
        public oneBtnClicked() {
            setNumber("1");;
        }
    }
    private class twoBtnClicked extends numberBtnClicked{
        public twoBtnClicked() {
            setNumber("2");;
        }
    }
    private class threeBtnClicked extends numberBtnClicked{
        public threeBtnClicked() {
            setNumber("3");;
        }
    }
    private class fourBtnClicked extends numberBtnClicked{
        public fourBtnClicked() {
            setNumber("4");;
        }
    }
    private class fiveBtnClicked extends numberBtnClicked{
        public fiveBtnClicked() {
            setNumber("5");;
        }
    }
    private class sixBtnClicked extends numberBtnClicked{
        public sixBtnClicked() {
            setNumber("6");;
        }
    }
    private class sevenBtnClicked extends numberBtnClicked{
        public sevenBtnClicked() {
            setNumber("7");;
        }
    }
    private class eightBtnClicked extends numberBtnClicked{
        public eightBtnClicked() {
            setNumber("8");;
        }
    }
    private class nineBtnClicked extends numberBtnClicked{
        public nineBtnClicked() {
            setNumber("9");
        }
    }

    private class digitBtnClicked extends numberBtnClicked {
        public digitBtnClicked() {
            setNumber(".");
        }
    }

    /**
     * This is the constructor for Calculator class, it contains the construction of buttons and actionListeners.
     * @author Xingjian Bi
     * @version 1.0
     */
    public Calculator() {
        clearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("0");
                calculating = true;
            }
        });
        zeroBtnClicked zeroBtnClicked = new zeroBtnClicked();
        oneBtnClicked oneBtnClicked = new oneBtnClicked();
        twoBtnClicked twoBtnClicked = new twoBtnClicked();
        threeBtnClicked threeBtnClicked = new threeBtnClicked();
        fourBtnClicked fourBtnClicked = new fourBtnClicked();
        fiveBtnClicked fiveBtnClicked = new fiveBtnClicked();
        sixBtnClicked sixBtnClicked = new sixBtnClicked();
        sevenBtnClicked sevenBtnClicked = new sevenBtnClicked();
        eightBtnClicked eightBtnClicked = new eightBtnClicked();
        nineBtnClicked nineBtnClicked = new nineBtnClicked();
        digitBtnClicked digitBtnClicked = new digitBtnClicked();
        zeroBtn.addActionListener(zeroBtnClicked);
        oneBtn.addActionListener(oneBtnClicked);
        twoBtn.addActionListener(twoBtnClicked);
        threeBtn.addActionListener(threeBtnClicked);
        fourBtn.addActionListener(fourBtnClicked);
        fiveBtn.addActionListener(fiveBtnClicked);
        sixBtn.addActionListener(sixBtnClicked);
        sevenBtn.addActionListener(sevenBtnClicked);
        eightBtn.addActionListener(eightBtnClicked);
        nineBtn.addActionListener(nineBtnClicked);
        digitBtn.addActionListener(digitBtnClicked);

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstNumber = Double.parseDouble(textField.getText());
                operator = "+";
                textField.setText("");
            }
        });

        minusBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstNumber = Double.parseDouble(textField.getText());
                operator = "-";
                textField.setText("");
            }
        });

        mulBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstNumber = Double.parseDouble(textField.getText());
                operator = "*";
                textField.setText("");
            }
        });

        divideBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstNumber = Double.parseDouble(textField.getText());
                operator = "/";
                textField.setText("");
            }
        });

        squareBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstNumber = Double.parseDouble(textField.getText());
                result = firstNumber * firstNumber;
                operator = "x^2";
                if ((int) result - result == 0) {
                    textField.setText("" + (int) result);
                }
                else{
                    textField.setText("" + result);
                }
            }
        });

        powerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstNumber = Double.parseDouble(textField.getText());
                operator = "x^y";
                textField.setText("");
            }
        });

        logBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstNumber = Double.parseDouble(textField.getText());
                if (firstNumber < 0) {
                    textField.setText("ERROR");
                }
                else {
                    result = Math.log(firstNumber);
                    operator = "ln";
                    if ((int) result - result == 0) {
                        textField.setText("" + (int) result);
                    }
                    else{
                        textField.setText("" + result);
                    }
                }

            }
        });

        sqrBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstNumber = Double.parseDouble(textField.getText());
                if (firstNumber < 0) {
                    textField.setText("ERROR");
                }
                else{
                    result = Math.sqrt(firstNumber);
                    operator = "sqr";
                    if ((int) result - result == 0) {
                        textField.setText("" + (int) result);
                    }
                    else{
                        textField.setText("" + result);
                    }
                }
            }
        });

        signBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signNumber = Double.parseDouble(textField.getText());
                if ((int) signNumber == 0){
                    result = signNumber;
                }
                else {
                    result = signNumber * (-1.0);
                }
//                operator = "sign";
                if ((int) result - result == 0) {
                    textField.setText("" + (int) result);
                }
                else{
                    textField.setText("" + result);
                }
            }
        });

        percentageBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstNumber = Double.parseDouble(textField.getText());
                result = firstNumber / 100;
                operator = "percentage";
                if ((int) result - result == 0) {
                    textField.setText("" + (int) result);
                }
                else{
                    textField.setText("" + result);
                }
            }
        });

        equalBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                secondNumber = Double.parseDouble(textField.getText());
                switch(operator) {
                    case "+":
                        result = firstNumber + secondNumber;
                        break;
                    case "-":
                        result = firstNumber - secondNumber;
                        break;
                    case "*":
                        result = firstNumber * secondNumber;
                        break;
                    case "/":
                        if (secondNumber == 0) {
                            errorCase = true;
                            break;
                        }
                        result = firstNumber / secondNumber;
                        break;
                    case "x^2":
                        result = secondNumber * secondNumber;
                        break;
                    case "x^y":
                        result = Math.pow(firstNumber, secondNumber);
                        break;
                    case "ln":
                        result = Math.log(secondNumber);
                        break;
                    case "sqrt":
                        result = Math.sqrt(secondNumber);
                        break;
                    case "percentage":
                        result = secondNumber / 100;
                        break;
                    default: result = 0;
                }
                if (errorCase) {
                    textField.setText("ERROR");
                    errorCase = false;
                }
                else if ((int) result - result == 0) {
                    textField.setText("" + (int) result);
                }
                else {
                    textField.setText("" + result);
                }
            }
        });
    }

    public void test( String button){
        switch (button){
            case "0": zeroBtn.doClick();break;
            case "1": oneBtn.doClick();break;
            case "2": twoBtn.doClick();break;
            case "3": threeBtn.doClick();break;
            case "4": fourBtn.doClick();break;
            case "5": fiveBtn.doClick();break;
            case "6": sixBtn.doClick();break;
            case "7": sevenBtn.doClick();break;
            case "8": eightBtn.doClick();break;
            case "9": nineBtn.doClick();break;
            case "%": percentageBtn.doClick();break;
            case "-/+": signBtn.doClick();break;
            case "AC": clearBtn.doClick();break;
            case "*2": squareBtn.doClick();break;
            case "sqr": sqrBtn.doClick();break;
            case "log": logBtn.doClick();break;
            case ".": digitBtn.doClick();break;
            case "+": addBtn.doClick();break;
            case "-": minusBtn.doClick();break;
            case "*": mulBtn.doClick();break;
            case "/": divideBtn.doClick();break;
            case "**": powerBtn.doClick();break;
            case "=": equalBtn.doClick();break;
            case "txt": System.out.println("The result is: " + textField.getText());break;
            default:System.out.println("invalid input");break;
        }
    }

    /**
     * This is the main function for calculator program, it sets the frame and the calculator.
     * @param args It contains the supplied command-line arguments as an array of String objects
     * @author Xingjian Bi
     * @version 1.0
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(new Calculator().calculator);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
