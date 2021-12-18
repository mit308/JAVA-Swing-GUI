package swingDemo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Calculator implements ActionListener{

    JFrame frame;
    JTextField text;
    JButton[] numberButtons = new JButton[10];
    JButton[] actionButtons = new JButton[5];
    JButton addButton, subButton, mulButton, divButton, eqlButton;
    JButton clcButton = new JButton("Clear");
    //JButton delButton = new JButton("Del");

    JPanel panel, panel1, panel2;

    Font myFont = new Font("Ink Free", Font.BOLD, 25);
    long num1 = 0, num2 = 0;
    double result = 0;
    char operator;

    Calculator()
    {
            frame = new JFrame("Basic Calculator");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 400);
            frame.setLayout(null);

            text = new JTextField();
            text.setBounds(10, 10, 260, 40);
            text.setFont(myFont);
            text.setEditable(false);

            addButton = new JButton("+");
            subButton = new JButton("-");
            mulButton = new JButton("*");
            divButton = new JButton("/");
            eqlButton = new JButton("=");

            actionButtons[0] = addButton;
            actionButtons[1] = subButton;
            actionButtons[2] = mulButton;
            actionButtons[3] = divButton;
            actionButtons[4] = eqlButton;

            for(int i = 0; i<5; i++)
            {
                actionButtons[i].addActionListener(this);
                clcButton.addActionListener(this);
                actionButtons[i].setFont(myFont);
                actionButtons[i].setFocusable(false);
            }
            for(int i = 0; i<10; i++)
            {
                numberButtons[i] = new JButton(String.valueOf(i));
                numberButtons[i].addActionListener(this);
                numberButtons[i].setFont(myFont);
                numberButtons[i].setFocusable(false);
            }
            clcButton.setBounds(100, 300, 100, 50);
            clcButton.setFont(myFont);
            panel = new JPanel();
            panel.setBounds(10, 60, 200, 200);
            panel.setLayout(new GridLayout(4, 3, 10, 10));
            //panel.setBackground(Color.BLACK);

            panel.add(numberButtons[7]);
            panel.add(numberButtons[8]);
            panel.add(numberButtons[9]);
            panel.add(numberButtons[4]);
            panel.add(numberButtons[5]);
            panel.add(numberButtons[6]);
            panel.add(numberButtons[1]);
            panel.add(numberButtons[2]);
            panel.add(numberButtons[3]);
            panel.add(numberButtons[0]);

            panel1 = new JPanel();
            panel1.setBounds(220, 60, 60, 250);
            //panel1.setBackground(Color.black);
            panel1.setLayout(new GridLayout(5, 1, 10, 10));
            panel1.add(actionButtons[0]);
            panel1.add(actionButtons[1]);
            panel1.add(actionButtons[2]);
            panel1.add(actionButtons[3]);
            panel1.add(actionButtons[4]);

            frame.add(panel1);
            frame.add(panel);
            frame.add(text);
            frame.add(clcButton);
            frame.setVisible(true);
    }

    public static void main(String[] args) {
	// write your code here
        Calculator calc = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i=0; i<10; i++)
        {
            if(e.getSource() == numberButtons[i])
            {
                text.setText(text.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource() == addButton)
        {
            num1 = Long.parseLong(text.getText());
            operator = '+';
            text.setText("");
        }
        if(e.getSource() == subButton)
        {
            num1 = Long.parseLong(text.getText());
            operator = '-';
            text.setText("");
        }
        if(e.getSource() == mulButton)
        {
            num1 = Long.parseLong(text.getText());
            operator = '*';
            text.setText("");
        }
        if(e.getSource() == divButton)
        {
            num1 = Long.parseLong(text.getText());
            operator = '/';
            text.setText("");
        }
        if(e.getSource() == eqlButton) {
            num2 = Long.parseLong(text.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            text.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == clcButton)
        {
            text.setText("");
        }

    }
}