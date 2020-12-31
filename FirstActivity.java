package library.management.systems;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class FirstActivity implements ActionListener
{
    JFrame frame;
    JLabel label1;
    Font font1,font2;
    Container c;
    JButton button1,button2;
    FirstActivity(){
        frame=new JFrame("Library Management System");
        frame.setBounds(100,100,800,600);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        c=frame.getContentPane();
        c.setLayout(null);

        font1=new Font("Arial",Font.BOLD,30);
        font2=new Font("Arial",Font.PLAIN,25);


        label1=new JLabel("Library Management System");
        label1.setBounds(180,20,450,35);
        label1.setFont(font1);
        c.add(label1);

        button1=new JButton("Admin Login");
        button1.setFont(font2);
        button1.setBounds(130,460,210,60);
        button1.setBackground(Color.BLACK);
        button1.setForeground(Color.WHITE);
        button1.addActionListener(this);
        c.add(button1);


        button2=new JButton("Librarian Login");
        button2.setFont(font2);
        button2.setBounds(420,460,210,60);
        button2.setBackground(Color.BLACK);
        button2.setForeground(Color.WHITE);
        button2.addActionListener(this);
        c.add(button2);

        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==button1)
        {
            frame.setVisible(false);
            new AdminLogin().setVisible(true);
        }
        if(ae.getSource()==button2)
        {
            frame.setVisible(false);
            new LibrarianLogin().setVisible(true);
        }
    }

    public static void main(String[] args) {
        FirstActivity firstActivity = new FirstActivity();
    }

    public void setVisible(boolean b) {

    }
}