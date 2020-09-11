import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorUI extends JFrame implements ActionListener {

    Calculator calculator = new Calculator();
    JLabel displayLabel;

    public CalculatorUI() {

        super("Binary Calculator");


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
            calculator.addToMainNumber("0");
            displayLabel.setText(calculator.getMainNumber());
        });
        panel.add(button0, button0constraints);


        JButton button1 = new JButton("1");
        var button1constraints = new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0);
        button1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                calculator.addToMainNumber("1");
                displayLabel.setText(calculator.getMainNumber());

            }
        });
        panel.add(button1, button1constraints);


        JButton squaredButton = new JButton("x²");
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

        new CalculatorUI();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = displayLabel.getText();
        String prevText = calculator.getPrevNumber();

        if (((JButton) e.getSource()).getText().equals("=")) {

            if (calculator.getOperation().equals("+")) {

                calculator.addNumber(text);
                displayLabel.setText(calculator.getMainNumber());

            } else if (calculator.getOperation().equals("-")) {

                calculator.subtractNumber(text);
                displayLabel.setText(calculator.getMainNumber());

            } else if (calculator.getOperation().equals("x")) {

                calculator.multiplyNumber(text);
                displayLabel.setText(calculator.getMainNumber());

            } else if (calculator.getOperation().equals("÷")) {

                calculator.divideNumber(text);
                displayLabel.setText(calculator.getMainNumber());

                calculator.resetMainNumber();
            }

        } else if (((JButton) e.getSource()).getText().equals("C")) {
            calculator.resetMainNumber();
            calculator.resetPreviousNumber();

            displayLabel.setText("0");

        } else if (((JButton) e.getSource()).getText().equals("Toggle")) {

            calculator.toggleNumber(text);
            displayLabel.setText(calculator.getMainNumber());

        } else if (((JButton) e.getSource()).getText().equals("√")) {

            calculator.squareRootNumber(text);
            displayLabel.setText(calculator.getMainNumber());

        } else if (((JButton) e.getSource()).getText().equals("x²")) {

            calculator.squareNumber(text);
            displayLabel.setText(calculator.getMainNumber());

        } else {
            calculator.setOperation(((JButton) e.getSource()).getText());
            calculator.storeAndResetMainNumber();

            displayLabel.setText(calculator.getMainNumber());
            displayLabel.setText(calculator.operation);

        }
    }
}

