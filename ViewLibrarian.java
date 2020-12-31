package library.management.systems;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;

class ViewLibrarian implements ActionListener
{
    JFrame frame;
    JTable table;
    Container c;
    JButton button1,button2,button3;
    Font font1,font2,font3;
    JLabel label,l1,l2,l3,l4,l5,l6;

    ViewLibrarian(){
        frame=new JFrame("Library Management System");
        frame.setBounds(100,100,800,600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

        font1=new Font("Arial",Font.PLAIN,30);
        font2=new Font("Arial",Font.PLAIN,25);
        font3=new Font("Arial",Font.PLAIN,20);


        c=frame.getContentPane();
        c.setLayout(null);

        table=new JTable();
        table.setBounds(20,100,740,320);
        table.setBackground(Color.LIGHT_GRAY);
        c.add(table);

        button1=new JButton("Load Data");
        button1.setBounds(40,460,160,55);
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.BLACK);
        button1.setFont(font2);
        button1.addActionListener(this);
        c.add(button1);

        button2=new JButton("Clear Data");
        button2.setBounds(290,460,160,55);
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.BLACK);
        button2.setFont(font2);
        button2.addActionListener(this);
        c.add(button2);

        button3=new JButton("Back");
        button3.setBounds(560,460,160,55);
        button3.setForeground(Color.WHITE);
        button3.setBackground(Color.BLACK);
        button3.setFont(font2);
        button3.addActionListener(this);
        c.add(button3);

        //creating labels

        l1=new JLabel("ID");
        l1.setBounds(35,30,120,45);
        l1.setFont(font3);
        c.add(l1);

        l2=new JLabel("Name");
        l2.setBounds(160,30,120,45);
        l2.setFont(font3);
        c.add(l2);

        l3=new JLabel("Password");
        l3.setBounds(290,30,120,45);
        l3.setFont(font3);
        c.add(l3);

        l4=new JLabel("Gender");
        l4.setBounds(400,30,120,45);
        l4.setFont(font3);
        c.add(l4);

        l5=new JLabel("Email");
        l5.setBounds(520,30,120,45);
        l5.setFont(font3);
        c.add(l5);

        l6=new JLabel("Contact");
        l6.setBounds(650,30,120,45);
        l6.setFont(font3);
        c.add(l6);

        frame.setVisible(true);
    }@Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==button1)
        {
            try{
                Conn c=new Conn();
                String query="select *from librarian_info";
                ResultSet rs=c.s.executeQuery(query);

                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        if(ae.getSource()==button2)
        {
            
        }
        if(ae.getSource()==button3)
        {
            new AdminSection().setVisible(true);
            frame.setVisible(false);
        }

    }

    public static void main(String[] args) {
        ViewLibrarian viewLibrarian=new ViewLibrarian();
    }

    public void setVisible(boolean b) {
    }
}

