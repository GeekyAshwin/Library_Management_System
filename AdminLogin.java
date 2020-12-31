package library.management.systems;

import javax.swing.*;
import java.awt.*;
import javax.swing.JOptionPane;
import java.awt.event.*;
import java.sql.ResultSet;


public class AdminLogin implements ActionListener {
    JFrame frame;
    JLabel titlelabel,l1,l2;
    JTextField t1;
    JPasswordField p1;
    Font font1,font2,font3;
    Container c;
    JButton button1,button2;
    AdminLogin(){
        frame=new JFrame("Library Management System");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setBounds(100,100,800,600);

        c=frame.getContentPane();
        c.setLayout(null);

        font1=new Font("Arial",Font.BOLD,30);
        font2=new Font("Arial",Font.PLAIN,35);
        font3=new Font("Arial",Font.PLAIN,26);


        titlelabel=new JLabel("Admin Login Form");
        titlelabel.setBounds(280,20,400,50);
        titlelabel.setFont(font1);
        c.add(titlelabel);

        l1=new JLabel("Name:");
        l1.setBounds(80,130,150,35);
        l1.setFont(font2);
        c.add(l1);


        l2=new JLabel("Password:");
        l2.setBounds(80,240,170,35);
        l2.setFont(font2);
        c.add(l2);

        t1=new JTextField();
        t1.setBounds(280,130,260,40);
        t1.setFont(font2);
        c.add(t1);

        p1=new JPasswordField();
        p1.setBounds(280,240,260,40);
        p1.setFont(font2);
        c.add(p1);


        button1=new JButton("Login");
        button1.setFont(font3);
        button1.setBounds(130,350,120,60);
        button1.setBackground(Color.BLACK);
        button1.setForeground(Color.WHITE);
        button1.addActionListener(this);
        c.add(button1);


        button2=new JButton("Back");
        button2.setFont(font3);
        button2.setBounds(420,350,120,60);
        button2.setBackground(Color.BLACK);
        button2.setForeground(Color.WHITE);
        button2.addActionListener(this);
        c.add(button2);

        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource()==button1)
        {
           String name=t1.getText();
           String password=p1.getText();
           Conn c=null;
           String query="select *from admin where Name = '"+name+"' and Password = '"+password+"'";
           try{
               c=new Conn();
               ResultSet rs=c.s.executeQuery(query);
               if (rs.next())
               {
                   new AdminSection().setVisible(true);
                   frame.setVisible(false);
               }
               else
               {
                   JOptionPane.showMessageDialog(null,"Invalid Entries");
               }
           }
           catch (Exception e){
               e.printStackTrace();
           }
        }
        if (ae.getSource()==button2)
        {
            frame.setVisible(false);
            new FirstActivity().setVisible(true);
        }
    }

    public static void main(String[] args) {
        AdminLogin adminLogin=new AdminLogin();
    }

    public void setVisible(boolean b) {

    }
}
