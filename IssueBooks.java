package library.management.systems;

import org.jdatepicker.impl.JDatePickerImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;

public class IssueBooks implements ActionListener {
    JFrame frame;
    Container c;
    Font font1,font2,font3;
    JLabel label,l1,l2,l3,l4,l5,l6;
    JTextField t1,t2,t3,t4,t5,t6;

    JButton button1,button2;
    IssueBooks(){
        frame=new JFrame("Library Management System");
        frame.setBounds(100,100,800,600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

        c=frame.getContentPane();
        c.setLayout(null);

        font1=new Font("Arial",Font.BOLD,30);
        font2=new Font("Arial",Font.PLAIN,35);
        font3=new Font("Arial",Font.PLAIN,26);



        label=new JLabel("Issue Books");
        label.setBounds(280,20,400,50);
        label.setFont(font1);
        c.add(label);

        l1=new JLabel("Serial No.");
        l1.setBounds(65,100,130,45);
        l1.setFont(font3);
        c.add(l1);

        l2=new JLabel("Book Name:");
        l2.setBounds(65,170,150,45);
        l2.setFont(font3);
        c.add(l2);

        l3=new JLabel("Student_ID :");
        l3.setBounds(65,240,153,45);
        l3.setFont(font3);
        c.add(l3);

        l4=new JLabel("Student Name:");
        l4.setBounds(65,310,180,45);
        l4.setFont(font3);
        c.add(l4);

        l5=new JLabel("Contact no.");
        l5.setBounds(65,380,140,45);
        l5.setFont(font3);
        c.add(l5);

        l6=new JLabel("Date of Issue:");
        l6.setBounds(65,450,158,45);
        l6.setFont(font3);
        c.add(l6);




        t1=new JTextField();
        t1.setBounds(240,103,220,35);
        t1.setFont(font3);
        c.add(t1);

        t2=new JTextField();
        t2.setBounds(240,173,220,35);
        t2.setFont(font3);
        c.add(t2);

        t3=new JTextField();
        t3.setBounds(240,243,220,35);
        t3.setFont(font3);
        c.add(t3);

        t4=new JTextField();
        t4.setBounds(240,313,220,35);
        t4.setFont(font3);
        c.add(t4);

        t5=new JTextField();
        t5.setBounds(240,383,220,35);
        t5.setFont(font3);
        c.add(t5);

        t6=new JTextField();
        t6.setBounds(240,453,220,35);
        t6.setFont(font3);
        c.add(t6);






        button1=new JButton("Issue Book");
        button1.setFont(font3);
        button1.setBounds(540,350,200,55);
        button1.setBackground(Color.BLACK);
        button1.setForeground(Color.WHITE);
        button1.addActionListener(this);
        c.add(button1);


        button2=new JButton("Back");
        button2.setFont(font3);
        button2.setBounds(540,430,200,55);
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
            String sno=t1.getText();
            String book_name=t2.getText();
            String Student_ID=t3.getText();
            String student_name=t4.getText();
            String contact_no=t5.getText();
            String date_of_issue=t6.getText();

            Conn c=null;
            try{
                c=new Conn();
                String query="insert into issuedbooks values('"+sno+"','"+book_name+"','"+student_name+"','"+Student_ID+"','"+contact_no+"','"+date_of_issue+"')";
                JOptionPane.showConfirmDialog(frame,"Are you sure you want to issue the book?");
                c.s.executeUpdate(query);
                String query1="update books set Available=Available-1 where SerialNo='"+sno+"'";
                String query2="update books set Issued=Quantity-Available where SerialNo='"+sno+"'";
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(frame,"Book issued Successfully");
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        if (ae.getSource()==button2)
        {
            frame.setVisible(false);
            new LibrarianSection().setVisible(true);
        }
    }
    public static void main(String[] args)
    {
        IssueBooks issueBooks=new IssueBooks();
    }
    public void setVisible(boolean b){

    }
}
