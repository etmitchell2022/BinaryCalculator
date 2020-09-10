import java.sql.SQLOutput;

public class Calculator {

    String mainNumber;
    String prevNumber;
    String operation;
    boolean isBinary = true;

    public Calculator() {
        this("0");
    }

    public Calculator(String mainNumber) {
        this.mainNumber = mainNumber;
    }

    public String addNumber(String toAdd) {
        int mainNumberInteger = Integer.parseInt(prevNumber, 2);
        int newNumberInteger = Integer.parseInt(toAdd, 2);
        int result = mainNumberInteger + newNumberInteger;

        mainNumber = Integer.toBinaryString(result);
        return mainNumber;
    }

    public String subtractNumber(String toSubtract) {
        int mainNumberInteger = Integer.parseInt(prevNumber, 2);
        int newNumberInteger = Integer.parseInt(toSubtract, 2);
        int result = mainNumberInteger - newNumberInteger;

        mainNumber = Integer.toBinaryString(result);
        return mainNumber;
    }

    public String multiplyNumber(String toMultiply) {
        int mainNumberInteger = Integer.parseInt(prevNumber, 2);
        int newNumberInteger = Integer.parseInt(toMultiply, 2);
        int result = mainNumberInteger * newNumberInteger;

        mainNumber = Integer.toBinaryString(result);
        return mainNumber;
    }

    public String divideNumber(String toDivide) {
        int mainNumberInteger = Integer.parseInt(prevNumber, 2);
        int newNumberInteger = Integer.parseInt(toDivide, 2);
        if (newNumberInteger != 0) {
            String result = Integer.toBinaryString(mainNumberInteger / newNumberInteger);
            String remainder = Integer.toBinaryString(mainNumberInteger % newNumberInteger);
            mainNumber = result; //+ "R" + remainder;
            return mainNumber;
        } else {
            mainNumber = "Error: cannot divide by 0";
            return mainNumber;
        }
    }

    public String squareNumber(String toSquare) {
        int mainNumberInteger = Integer.parseInt(toSquare, 2);
        mainNumber = Integer.toBinaryString(mainNumberInteger * mainNumberInteger);
        return mainNumber;
    }

    public String squareRootNumber(String toSquareRoot) {
        int mainNumberInteger = Integer.parseInt(toSquareRoot, 2);
        mainNumber = Integer.toBinaryString((int) Math.sqrt(mainNumberInteger));
        return mainNumber;
    }

    public String toggleNumber(String toToggle) {
        if(isBinary) {
            mainNumber = Integer.toString(Integer.parseInt(toToggle, 2)); // binary to decimal
            isBinary = false;
        }else {
            mainNumber = Integer.toBinaryString(Integer.parseInt(toToggle, 10));
            isBinary = true;
        }
        return mainNumber;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }

    public void setPrevNumber(String prevNumber) {
        this.prevNumber = prevNumber;
    }

    public String getPrevNumber() {
        return prevNumber;
    }


    public String addToMainNumber(String toAdd) {
        mainNumber += toAdd;
        return mainNumber;
    }


    public String getMainNumber() {
        return mainNumber;
    }

    public void resetMainNumber() {
        mainNumber = "0";
    }

    public void resetPreviousNumber() {
        prevNumber = "0";
    }

    public void storeAndResetMainNumber() {
        prevNumber = mainNumber;
        resetMainNumber();
    }
}
