import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Objects;

public class CopyApp implements ActionListener {
    JFrame frame;
    JPanel panel;

    JProgressBar progress = new JProgressBar();
    JButton copy =new JButton("Copy");

    JLabel source = new JLabel("Source");
    JTextField source_txt = new JTextField();

    JLabel destination = new JLabel("Destination");
    JTextField destination_txt = new JTextField();



    CopyApp(){
        frame = new JFrame("Copy File Application");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        source.setBounds(20, 15, 80, 25);
        panel.add(source);
        source_txt.setBounds(20, 50, 165, 25);
        panel.add(source_txt);

        destination.setBounds(205, 15, 80, 25);
        panel.add(destination);
        destination_txt.setBounds(205, 50, 165, 25);
        panel.add(destination_txt);

        progress.setBounds(20, 100, 350, 25);
        progress.setValue(0);
        progress.setStringPainted(true);
        panel.add(progress);


        copy.setBounds(150, 150, 100, 25);
        copy.addActionListener(this);
        panel.add(copy);


        frame.add(panel);
        frame.setVisible(true);


    }

        public void bar(){
        int i=0;
        for(i=0; i<=100; i++)
        {

            progress.setValue(i);
            frame.setVisible(true);


            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

            progress.setString("File Copied");
    }

    public void copy_file(){
        FileInputStream source_ = null;
        FileOutputStream dest_ = null;

        File sc = new File(source_txt.getText());
        File dest = new File(destination_txt.getText());


        try {
             source_ = new FileInputStream(sc);
            dest_ = new FileOutputStream(dest);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(source_.available());
        } catch (IOException e) {
            e.printStackTrace();
        }
        int i = 0;
        try{
            while ((i = source_.read())!= -1)
            {
                dest_.write(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try{
                if (source_!= null)
                {
                    dest_.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try
            {
                if (dest_ != null)
                {
                    dest_.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    public static void main(String args[])
    {
        CopyApp obj = new CopyApp();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //frame.setVisible(true);
        if (ae.getSource() == copy)
        {
            if (!Objects.equals(source_txt.getText(), "") || !Objects.equals(destination_txt.getText(), "")) {
                    System.out.println(destination_txt.getText());
                    copy_file();
                    //panel.add(frame);
                    frame.setVisible(true);
                    bar();

                    //frame.setVisible(false);

                }
                else {
                    JOptionPane.showMessageDialog(null, "Required Field", "Prompt", JOptionPane.INFORMATION_MESSAGE);
                }

            }
            //frame.add(panel);


        }

    }

