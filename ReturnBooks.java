package library.management.systems;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ReturnBooks implements ActionListener {
    JFrame frame;
    Container c;
    Font font1,font2,font3;
    JLabel label,l1,l2,l3,l4;
    JTextField t1,t2,t3,t4;
    JButton button1,button2;
    ReturnBooks(){
        frame=new JFrame("Library Management System");
        frame.setBounds(100,100,800,600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

        c=frame.getContentPane();
        c.setLayout(null);

        font1=new Font("Arial",Font.BOLD,30);
        font2=new Font("Arial",Font.PLAIN,35);
        font3=new Font("Arial",Font.PLAIN,26);



        label=new JLabel("Return Book");
        label.setBounds(280,20,400,50);
        label.setFont(font1);
        c.add(label);

        l1=new JLabel("Serial No.");
        l1.setBounds(65,100,130,45);
        l1.setFont(font3);
        c.add(l1);

        l2=new JLabel("BookName:");
        l2.setBounds(65,170,135,45);
        l2.setFont(font3);
        c.add(l2);

        l3=new JLabel("Student ID:");
        l3.setBounds(65,240,133,45);
        l3.setFont(font3);
        c.add(l3);

        l4=new JLabel("Student Name:");
        l4.setBounds(65,310,190,45);
        l4.setFont(font3);
        c.add(l4);


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


        button1=new JButton("Return Book");
        button1.setFont(font3);
        button1.setBounds(90,410,180,55);
        button1.setBackground(Color.BLACK);
        button1.setForeground(Color.WHITE);
        button1.addActionListener(this);
        c.add(button1);


        button2=new JButton("Back");
        button2.setFont(font3);
        button2.setBounds(290,410,180,55);
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
            String bookname=t2.getText();
            String student_id=t3.getText();
            String student_name=t4.getText();

            String query1="delete from issuedbooks where Student_ID='"+student_id+"'";
            String query2="update table set Available=Available+1,Issued=Issued-1 where Student_ID='"+student_id+"'";
            Conn c=null;
            try{
                c=new Conn();
                c.s.executeUpdate(query1);
                JOptionPane.showMessageDialog(frame,"Book '"+bookname+"'is returned Successfully");
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
        ReturnBooks returnBooks=new ReturnBooks();
    }
    public void setVisible(boolean b){

    }
}
