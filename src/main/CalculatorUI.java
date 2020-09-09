import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorUI extends JFrame implements ActionListener {

    Calculator Calculator = new Calculator();
    JLabel displayLabel;

    public CalculatorUI() {

        super("Binary Calculator");

        //bigger fonts
        UIManager.put("Label.font", new FontUIResource(new Font("Dialog", Font.PLAIN, 15)));
        UIManager.put("Button.font", new FontUIResource(new Font("Dialog", Font.BOLD, 15)));

        JPanel panel = new JPanel();

        GridBagLayout gridBagLayout = new GridBagLayout();
        panel.setLayout(gridBagLayout);
        setContentPane(panel);

        displayLabel = new JLabel("");

        var displayLabelConstraints = new GridBagConstraints(0, 0, 2, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(20, 20, 20, 20), 0, 0);
        panel.add(displayLabel, displayLabelConstraints);


        JButton button0 = new JButton("0");
        var button0constraints = new GridBagConstraints(1, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0);
        button0.addActionListener(e -> {
            Calculator.addToMainNumber("0");
            displayLabel.setText(Calculator.getMainNumber());
        });
        panel.add(button0, button0constraints);



        JButton button1 = new JButton("1");
        var button1constraints = new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0);
        button1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Calculator.addToMainNumber("1");
                displayLabel.setText(Calculator.getMainNumber());

            }
        });
        panel.add(button1, button1constraints);

//would be cool to find a better symbol for this button
        JButton squaredButton = new JButton("x^2");
        var squaredButtonConstraints = new GridBagConstraints(0, 4, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0);
        squaredButton.addActionListener(this);
        panel.add(squaredButton, squaredButtonConstraints);

        JButton squarerootButton = new JButton("√");
        var squarerootButtonConstraints = new GridBagConstraints(1, 4, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0);
        squarerootButton.addActionListener(this);
        panel.add(squarerootButton, squarerootButtonConstraints);


        JButton plusButton = new JButton("+");
        var plusButtonConstraints = new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0);
        plusButton.addActionListener(this);
        panel.add(plusButton, plusButtonConstraints);


        JButton minusButton = new JButton("-");
        var minusButtonConstraints = new GridBagConstraints(1, 2, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0);
        minusButton.addActionListener(this);
        panel.add(minusButton, minusButtonConstraints);


        JButton multiplicationButton = new JButton("x");
        var multiplicationButtonConstraints = new GridBagConstraints(0, 3, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0);
        multiplicationButton.addActionListener(this);
        panel.add(multiplicationButton, multiplicationButtonConstraints);


        JButton divisionButton = new JButton("÷");
        var divisionButtonConstraints = new GridBagConstraints(1, 3, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0);
        divisionButton.addActionListener(this);
        panel.add(divisionButton, divisionButtonConstraints);


        JButton equalButton = new JButton("=");
        var equalButtonConstraints = new GridBagConstraints(2, 1, 1, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0);
        equalButton.addActionListener(this);
        panel.add(equalButton, equalButtonConstraints);


        JButton clearButton = new JButton("C");
        var clearButtonConstraints = new GridBagConstraints(2, 4, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0);
        clearButton.addActionListener(this);
        panel.add(clearButton, clearButtonConstraints);

        JButton toggleButton = new JButton("Toggle");
        var toggleButtonConstraints = new GridBagConstraints(2, 3, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0);
        toggleButton.addActionListener(this);
        panel.add(toggleButton, toggleButtonConstraints);




        setPreferredSize(new Dimension(600, 600));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);

    }

    public static void main(String[] args) {
        System.out.println("Running Binary Calculator");
        new CalculatorUI();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = displayLabel.getText();
        String prevText = Calculator.getPrevNumber();

        if (((JButton) e.getSource()).getText().equals("=")) {

            if(Calculator.getOperation().equals("+")){

                Calculator.addNumber(text);
                displayLabel.setText(Calculator.getMainNumber());

            }else if(Calculator.getOperation().equals("-")){

                Calculator.subtractNumber(text);
                displayLabel.setText(Calculator.getMainNumber());

            }else if(Calculator.getOperation().equals("x")){

                Calculator.multiplyNumber(text);
                displayLabel.setText(Calculator.getMainNumber());

            }else if(Calculator.getOperation().equals("÷")){

                Calculator.divideNumber(text);
                displayLabel.setText(Calculator.getMainNumber());

                Calculator.resetMainNumber();

            }//will need to add here






        }
        else if(((JButton) e.getSource()).getText().equals("C")) {
            Calculator.resetMainNumber();
            Calculator.resetPreviousNumber();

            displayLabel.setText("0");

        }
        else{
            Calculator.setOperation(((JButton) e.getSource()).getText());
            Calculator.storeAndResetMainNumber();

            displayLabel.setText(Calculator.getMainNumber());
            displayLabel.setText(Calculator.operation);

        }
    }
}
