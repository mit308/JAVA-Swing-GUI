package swingDemo;

import com.toedter.calendar.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class MainForm implements ActionListener {

    char[] password_txt, re_password_txt;
    String password_txt_s, re_password_txt_s;

    JFrame frame = new JFrame();
    JPanel panel = new JPanel();

    JLabel label = new JLabel("First Name");
    JTextField textField = new JTextField(30);

    JLabel l_name = new JLabel("Last Name");
    JTextField lastname = new JTextField(30);

    JLabel dob = new JLabel("Date of Birth");
    JDatechooser calendar = new JDateChooser();

    JTextField email = new JTextField();
    JLabel email_id = new JLabel("Email ID");

    JLabel phone = new JLabel("Phone Number");
    JTextField number = new JTextField(10);

    JLabel pass_word = new JLabel("Enter Password");
    JPasswordField password = new JPasswordField(15);

    JLabel re_password = new JLabel("Re-enter Password");
    JPasswordField re_pass_word = new JPasswordField(15);

    JButton submit = new JButton("Submit");
    JButton clear = new JButton("Clear");

    JTextArea area = new JTextArea();

    JLabel message = new JLabel();
    Scanner sc = new Scanner(System.in);




    MainForm() {


        frame.setSize(400, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(panel);
        panel.setLayout(null);

        label.setBounds(10, 20, 80, 25);
        panel.add(label);


        textField.setBounds(130, 20, 165, 25);
        panel.add(textField);


        l_name.setBounds(10, 50, 80, 25);
        panel.add(l_name);

        lastname.setBounds(130, 45, 165, 25);
        panel.add(lastname);


        dob.setBounds(10, 75, 80, 25);
        panel.add(dob);

        calendar.setBounds(130, 75, 165, 25);
        panel.add(calendar);

        email_id.setBounds(10, 100, 80, 25);
        panel.add(email_id);

        email.setBounds(130, 100, 165, 25);
        panel.add(email);

        phone.setBounds(10, 125, 100, 25);
        panel.add(phone);

        number.setBounds(130, 125, 165, 25);
        panel.add(number);

        pass_word.setBounds(10, 150, 100, 25);
        panel.add(pass_word);

        password.setBounds(130, 150, 165, 25);
        panel.add(password);

        re_password.setBounds(10, 175, 110, 25);
        panel.add(re_password);

        re_pass_word.setBounds(130, 175, 165, 25);
        panel.add(re_pass_word);

        submit.addActionListener(this);
        submit.setBounds(50, 220, 80, 25);
        panel.add(submit);

        clear.addActionListener(this);
        clear.setBounds(160, 220, 80, 25);
        panel.add(clear);

        area.setBounds(50, 270, 200, 250);
        area.setEditable(false);
        panel.add(area);

        message.setText("");
        panel.add(message);

        frame.setVisible(true);
    }
        public static void main(String args[]){
            MainForm obj = new MainForm();
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == clear){
            textField.setText("");
            lastname.setText("");
            email.setText("");
            number.setText("");
            password.setText("");
            re_pass_word.setText("");
            area.setText("");
            message.setText("");
            calendar.setDate(null);
        }
        if (e.getSource()== submit){
            password_txt = password.getPassword();
            password_txt_s = String.valueOf(password_txt);
            re_password_txt = re_pass_word.getPassword();
            re_password_txt_s = String.valueOf(re_password_txt);
            String phone_number = number.getText();


            if (textField.getText().isEmpty() || lastname.getText().isEmpty() || email.getText().isEmpty()||
                    number.getText().isEmpty() || password_txt_s == "" || re_password_txt_s == "" || calendar.getDate()==null)
            {
                JOptionPane.showMessageDialog(null, "All fields are required", "Required", JOptionPane.INFORMATION_MESSAGE);
            }
            else {

                if (!Objects.equals(password_txt_s, re_password_txt_s))
                {
                    JOptionPane.showMessageDialog(null, "Password and re-entered password does not match", "Password Incorrect", JOptionPane.INFORMATION_MESSAGE);
                }
                if (!Objects.equals(phone_number, "")) {
                    try {
                        Long.parseLong(phone_number);
                        area.setText(textField.getText() + " " + lastname.getText() + "\n" + calendar.getDate() +"\n"+email.getText() + "\n" + number.getText()
                                + "\n" + password_txt_s + "\n" + re_password_txt_s);

                    } catch (NumberFormatException v) {
                        JOptionPane.showMessageDialog(null, "Enter a valid phone number", "Invalid Phone number", JOptionPane.INFORMATION_MESSAGE);
                    }
                }

            }


        }


    }
}
