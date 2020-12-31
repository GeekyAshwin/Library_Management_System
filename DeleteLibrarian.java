package library.management.systems;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class DeleteLibrarian implements ActionListener{
    JFrame frame;
    Container c;
    JLabel label,l1;
    JTextField t1;
    Font font1,font2;
    JButton button1,button2;
    DeleteLibrarian(){
        frame=new JFrame("Library Management System");
        frame.setBounds(200,100,600,400);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setResizable(false);


        c=frame.getContentPane();
        c.setBackground(Color.lightGray);
        c.setLayout(null);

        font1=new Font("Arial",Font.PLAIN,30);
        font2=new Font("Arial",Font.PLAIN,24);

        label=new JLabel("Delete Librarian");
        label.setBounds(180,20,250,40);
        label.setFont(font1);
        c.add(label);

        l1=new JLabel("Enter ID:");
        l1.setBounds(100,100,120,40);
        l1.setFont(font2);
        c.add(l1);

        t1=new JTextField();
        t1.setBounds(220,100,200,35);
        t1.setFont(font2);
        c.add(t1);

        button1=new JButton("Delete Librarian");
        button1.setBounds(250,200,220,55);
        button1.setBackground(Color.black);
        button1.setFont(font2);
        button1.setForeground(Color.white);
        button1.addActionListener(this);
        c.add(button1);

        button2=new JButton("Back");
        button2.setBounds(250,270,220,55);
        button2.setBackground(Color.black);
        button2.setFont(font2);
        button2.setForeground(Color.white);
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
            Conn c=null;
            String query="delete from librarian_info where id= '"+id+"'";
            try{
                c=new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showConfirmDialog(frame,"Are you sure you want to delete this librarian?");
                JOptionPane.showMessageDialog(frame,"Librarian Deleted Successfully");


            }
            catch (Exception e){
                e.printStackTrace();
            }

        }
        if (ae.getSource()==button2)
        {
            frame.setVisible(false);
            new AdminSection().setVisible(true);
        }
    }

    public static void main(String[] args) {
        DeleteLibrarian deleteLibrarian=new DeleteLibrarian();
    }


    public void setVisible(boolean b){

    }
}
