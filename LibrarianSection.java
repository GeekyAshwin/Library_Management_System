package library.management.systems;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class LibrarianSection implements ActionListener {
    JFrame frame;
    JLabel titlelabel,l1,l2;
    JTextField t1;
    JPasswordField p1;
    Font font1,font2,font3;
    Container c;
    JButton button1,button2,button3,button4,button5,button6;
    LibrarianSection(){
        frame=new JFrame("Librarian Management System");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setBounds(100,100,800,600);
        frame.setResizable(false);

        c=frame.getContentPane();
        c.setLayout(null);

        font1=new Font("Arial",Font.BOLD,30);
        font2=new Font("Arial",Font.PLAIN,35);
        font3=new Font("Arial",Font.PLAIN,26);


        titlelabel=new JLabel("Librarian Section");
        titlelabel.setBounds(280,20,400,50);
        titlelabel.setFont(font1);
        c.add(titlelabel);



        button1=new JButton("Add Books");
        button1.setFont(font3);
        button1.setBounds(280,100,250,60);
        button1.setBackground(Color.BLACK);
        button1.setForeground(Color.WHITE);
        button1.addActionListener(this);
        c.add(button1);


        button2=new JButton("View Books");
        button2.setFont(font3);
        button2.setBounds(280,170,250,60);
        button2.setBackground(Color.BLACK);
        button2.setForeground(Color.WHITE);
        button2.addActionListener(this);
        c.add(button2);

        button3=new JButton("Issue Books");
        button3.setFont(font3);
        button3.setBounds(280,240,250,60);
        button3.setBackground(Color.BLACK);
        button3.setForeground(Color.WHITE);
        button3.addActionListener(this);
        c.add(button3);


        button4=new JButton("View Issued Books");
        button4.setFont(font3);
        button4.setBounds(280,310,250,60);
        button4.setBackground(Color.BLACK);
        button4.setForeground(Color.WHITE);
        button4.addActionListener(this);
        c.add(button4);

        button5=new JButton("Return Book");
        button5.setFont(font3);
        button5.setBounds(280,380,250,60);
        button5.setBackground(Color.BLACK);
        button5.setForeground(Color.WHITE);
        button5.addActionListener(this);
        c.add(button5);

        button6=new JButton("Logout");
        button6.setFont(font3);
        button6.setBounds(280,450,250,60);
        button6.setBackground(Color.BLACK);
        button6.setForeground(Color.WHITE);
        button6.addActionListener(this);
        c.add(button6);

        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource()==button1)
        {
            new AddBooks().setVisible(true);
            frame.setVisible(false);
        }
        if (ae.getSource()==button2)
        {
            new ViewBooks().setVisible(true);
            frame.setVisible(false);
        }
        if (ae.getSource()==button3)
        {
            new IssueBooks().setVisible(true);
            frame.setVisible(false);
        }
        if (ae.getSource()==button4)
        {
            frame.setVisible(false);
            new ViewissuedBooks().setVisible(true);
        }
        if (ae.getSource()==button5)
        {
            frame.setVisible(false);
            new ReturnBooks().setVisible(true);
        }
        if (ae.getSource()==button6)
        {
            frame.setVisible(false);
            new FirstActivity().setVisible(true);
        }
    }

    public static void main(String[] args) {
        LibrarianSection librarianSection=new LibrarianSection();
    }

    public void setVisible(boolean b) {

    }
}
