package library.management.systems;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.*;
import java.sql.*;



class AddLibrarian implements ActionListener
{
    JFrame frame;
    JLabel titlelabel,l1,l2,l3,l4,l5,l6;
    JTextField t1,t2,t4,t5,t6;
    JPasswordField p3;
    Font font1,font2;
    Container c;
    JButton button1,button2;
    JRadioButton male,female;
    ButtonGroup buttonGroup;
    AddLibrarian(){
        frame=new JFrame("Library Management System");
        frame.setBounds(100,100,800,600);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);


        c=frame.getContentPane();
        c.setBackground(Color.WHITE);
        c.setLayout(null);

        font1=new Font("Arial",Font.BOLD,35);
        font2=new Font("Arial",Font.PLAIN,25);
        font2=new Font("Arial",Font.PLAIN,22);


        titlelabel=new JLabel("Add Librarian");
        titlelabel.setBounds(260,20,450,35);
        titlelabel.setFont(font1);
        c.add(titlelabel);

        l1=new JLabel("ID:");
        l1.setBounds(60,98,150,40);
        l1.setFont(font2);
        l1.setFont(font2);
        c.add(l1);

        l2=new JLabel("Name:");
        l2.setBounds(60,158,150,40);
        l2.setFont(font2);
        c.add(l2);

        l3=new JLabel("Password:");
        l3.setBounds(60,218,150,40);
        l3.setFont(font2);
        c.add(l3);

        l4=new JLabel("Gender:");
        l4.setBounds(60,278,150,40);
        l4.setFont(font2);
        c.add(l4);

        l5=new JLabel("E-Mail:");
        l5.setBounds(60,338,150,40);
        l5.setFont(font2);
        c.add(l5);

        l6=new JLabel("Contact no:");
        l6.setBounds(60,398,150,40);
        l6.setFont(font2);
        c.add(l6);

        


        //creating textfields and passwordfields
        t1=new JTextField();
        t1.setBounds(240,100,220,35);
        t1.setFont(font2);
        c.add(t1);

        p3=new JPasswordField();
        p3.setBounds(240,220,220,35);
        p3.setFont(font2);
        c.add(p3);

        t2=new JTextField();
        t2.setBounds(240,160,220,35);
        t2.setFont(font2);
        c.add(t2);

        male=new JRadioButton("Male");
        male.setBounds(240,280,100,40);
        male.setFont(font2);
        male.setBackground(Color.white);
        c.add(male);

        female=new JRadioButton("Female");
        female.setBounds(350,280,120,40);
        female.setFont(font2);
        female.setBackground(Color.white);
        c.add(female);

        buttonGroup=new ButtonGroup();
        buttonGroup.add(male);
        buttonGroup.add(female);


        t5=new JTextField();
        t5.setBounds(240,340,220,35);
        t5.setFont(font2);
        c.add(t5);

        t6=new JTextField();
        t6.setBounds(240,400,220,35);
        t6.setFont(font2);
        c.add(t6);




        button1=new JButton("Add Librarian");
        button1.setFont(font2);
        button1.setBounds(60,470,180,50);
        button1.setBackground(Color.BLACK);
        button1.setForeground(Color.WHITE);
        button1.addActionListener(this);
        c.add(button1);

        button2=new JButton("Back");
        button2.setFont(font2);
        button2.setBounds(270,470,180,50);
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
            String id=t1.getText();
            String name=t2.getText();
            String password=p3.getText();
            String gender=null;
            String email=t5.getText();
            String phone=t6.getText();

            if(male.isSelected())
                gender="Male";
            else if(female.isSelected())
                gender="Female";

            Conn c=null;
            String query="insert into librarian_info values('"+id+"','"+name+"','"+password+"','"+gender+"','"+email+"','"+phone+"')";
            try{
                c=new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Librarian added Successfully");
            }
            catch (Exception e){
                e.printStackTrace();
            }



        }
        if(ae.getSource()==button2)
        {
            frame.setVisible(false);
            new AdminSection().setVisible(true);
        }
    }

    public static void main(String[] args) throws Exception{
        AddLibrarian addLibrarian = new AddLibrarian();
    }

    public void setVisible(boolean b) {

    }
}