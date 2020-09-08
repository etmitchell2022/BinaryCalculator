public class Calculator {

    String mainNumber="0";
    String prevNumber;
    String operation;


    public Calculator(){
        this("0");
    }

    public Calculator(String mainNumber){
        this.mainNumber = mainNumber;
    }


    public String addNumber(String toAdd) {
        int mainNumberInteger = Integer.parseInt(prevNumber,2);
        int newNumberInteger = Integer.parseInt(toAdd,2);
        int result = mainNumberInteger + newNumberInteger;

        mainNumber = Integer.toString(result);
        return mainNumber;
    }

    public String subtractNumber(String toSubtract) {
        int mainNumberInteger = Integer.parseInt(prevNumber, 2);
        int newNumberInteger = Integer.parseInt(toSubtract, 2);
        int result = mainNumberInteger - newNumberInteger;

        mainNumber = Integer.toString(result);
        return mainNumber;
    }

    public String multiplyNumber(String toMultiply) {
        int mainNumberInteger = Integer.parseInt(prevNumber, 2);
        int newNumberInteger = Integer.parseInt(toMultiply, 2);
        int result = mainNumberInteger * newNumberInteger;

        mainNumber = Integer.toString(result);
        return mainNumber;
    }

    public String divideNumber(String toDivide) {
        int mainNumberInteger = Integer.parseInt(prevNumber, 2);
        int newNumberInteger = Integer.parseInt(toDivide, 2);
        if (newNumberInteger != 0) {
            String result = Integer.toString(mainNumberInteger / newNumberInteger);
            String remainder = Integer.toString(mainNumberInteger % newNumberInteger);
            mainNumber = result + "R" + remainder;
            return mainNumber;
        }else{
            mainNumber = "Error: cannot divide by 0";
            return mainNumber;
        }
    }
/*
    public String squareNumber(String mainNumber) {
        int mainNumberInteger = Integer.parseInt(mainNumber, 10);
        if (mainNumberInteger != 0){
            String result = Integer.toString

        }else{

        }

    }
*/
    public void setOperation(String operation){
        this.operation = operation;
    }

    public String getOperation(){
        return operation;
    }

    public void setPrevNumber(String prevNumber){
        this.prevNumber = prevNumber;
    }

    public String getPrevNumber(){
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

    public void resetPreviousNumber(){
        prevNumber = "0";
    }

    public void storeAndResetMainNumber() {
        prevNumber = mainNumber;
        resetMainNumber();
    }
}
