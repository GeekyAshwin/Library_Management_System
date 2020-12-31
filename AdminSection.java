package library.management.systems;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class AdminSection implements ActionListener {
    JFrame frame;
    JLabel titlelabel,l1,l2;
    JTextField t1;
    JPasswordField p1;
    Font font1,font2,font3;
    Container c;
    JButton button1,button2,button3,button4;
    AdminSection(){
        frame=new JFrame("Admin Section");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setBounds(100,100,800,600);
        frame.setResizable(false);

        c=frame.getContentPane();
        c.setLayout(null);

        font1=new Font("Arial",Font.BOLD,30);
        font2=new Font("Arial",Font.PLAIN,35);
        font3=new Font("Arial",Font.PLAIN,26);


        titlelabel=new JLabel("Admin Section");
        titlelabel.setBounds(280,20,400,50);
        titlelabel.setFont(font1);
        c.add(titlelabel);



        button1=new JButton("Add Librarian");
        button1.setFont(font3);
        button1.setBounds(280,100,240,60);
        button1.setBackground(Color.BLACK);
        button1.setForeground(Color.WHITE);
        button1.addActionListener(this);
        c.add(button1);


        button2=new JButton("View Librarian");
        button2.setFont(font3);
        button2.setBounds(280,170,240,60);
        button2.setBackground(Color.BLACK);
        button2.setForeground(Color.WHITE);
        button2.addActionListener(this);
        c.add(button2);

        button3=new JButton("Delete Librarian");
        button3.setFont(font3);
        button3.setBounds(280,240,240,60);
        button3.setBackground(Color.BLACK);
        button3.setForeground(Color.WHITE);
        button3.addActionListener(this);
        c.add(button3);


        button4=new JButton("Logout");
        button4.setFont(font3);
        button4.setBounds(280,310,240,60);
        button4.setBackground(Color.BLACK);
        button4.setForeground(Color.WHITE);
        button4.addActionListener(this);
        c.add(button4);

        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource()==button1)
        {
            new AddLibrarian().setVisible(true);
            frame.setVisible(false);
        }
        if (ae.getSource()==button2)
        {
            new ViewLibrarian().setVisible(true);
            frame.setVisible(false);
        }
        if (ae.getSource()==button3)
        {
           new ViewLibrarian().setVisible(true);
           new DeleteLibrarian().setVisible(true);

        }
        if (ae.getSource()==button4)
        {
            frame.setVisible(false);
            new FirstActivity().setVisible(true);
        }
    }

    public static void main(String[] args) {
        AdminSection adminSection=new AdminSection();
    }

    public void setVisible(boolean b) {

    }
}
