package library.management.systems;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class AddBooks implements ActionListener {
    JFrame frame;
    Container c;
    Font font1,font2,font3;
    JLabel label,l1,l2,l3,l4;
    JTextField t1,t2,t3,t4;
    JButton button1,button2;
    AddBooks(){
        frame=new JFrame("Library Management System");
        frame.setBounds(100,100,800,600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

        c=frame.getContentPane();
        c.setLayout(null);

        font1=new Font("Arial",Font.BOLD,30);
        font2=new Font("Arial",Font.PLAIN,35);
        font3=new Font("Arial",Font.PLAIN,26);



        label=new JLabel("Add Books");
        label.setBounds(280,20,400,50);
        label.setFont(font1);
        c.add(label);

        l1=new JLabel("Serial No.");
        l1.setBounds(65,100,130,45);
        l1.setFont(font3);
        c.add(l1);

        l2=new JLabel("BookName:");
        l2.setBounds(65,170,140,45);
        l2.setFont(font3);
        c.add(l2);

        l3=new JLabel("Publisher :");
        l3.setBounds(65,240,123,45);
        l3.setFont(font3);
        c.add(l3);

        l4=new JLabel("Quantity :");
        l4.setBounds(65,310,120,45);
        l4.setFont(font3);
        c.add(l4);


        t1=new JTextField();
        t1.setBounds(220,103,220,35);
        t1.setFont(font3);
        c.add(t1);

        t2=new JTextField();
        t2.setBounds(220,173,220,35);
        t2.setFont(font3);
        c.add(t2);

        t3=new JTextField();
        t3.setBounds(220,243,220,35);
        t3.setFont(font3);
        c.add(t3);

        t4=new JTextField();
        t4.setBounds(220,313,220,35);
        t4.setFont(font3);
        c.add(t4);


        button1=new JButton("Add Book");
        button1.setFont(font3);
        button1.setBounds(90,410,160,55);
        button1.setBackground(Color.BLACK);
        button1.setForeground(Color.WHITE);
        button1.addActionListener(this);
        c.add(button1);


        button2=new JButton("Back");
        button2.setFont(font3);
        button2.setBounds(270,410,160,55);
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
            String name=t2.getText();
            String publisher=t3.getText();
            String quantity=t4.getText();
            String avail=quantity;
            int issued=0;

            Conn c=null;
            String query="insert into books(SerialNo,Name,Publisher,Quantity,Available,Issued) values('"+sno+"','"+name+"','"+publisher+"','"+quantity+"','"+avail+"','"+issued+"')";
            try{
                c=new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"The Book is Added Successfully");
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
        AddBooks addBooks=new AddBooks();
    }
    public void setVisible(boolean b){

    }
}
