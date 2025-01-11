import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

public class AddRecord implements ActionListener
{
	JFrame f1;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
	JButton b1,b2;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8;
	JComboBox cb1;
	JLabel label;
	JDateChooser dc1,dc2;
	public static void main(String[] args) 
	{
		SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
		AddRecord AD = new AddRecord();
	}
	AddRecord()
	{
		f1 = new JFrame();
		f1.setSize(500,600);
		try {
			f1.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Girish Kale\\OneDrive\\Documents\\MedicalInventarymanagementSystem\\Mainimg.jpg")))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		f1.setLocationRelativeTo(null);
		f1.setLayout(null);
		
		l1 = new JLabel("Add Record");
		l1.setFont(new Font("Arial",Font.BOLD,25));
		l1.setBounds(150,50,200,30);
		f1.add(l1);
        
        l1 = new JLabel("ID");
        l1.setBounds(150,100,70,25);
        f1.add(l1);
        tf1 = new JTextField();
        tf1.setBounds(230,100,150,25);
        f1.add(tf1);
        
        tf1.addKeyListener(new KeyAdapter() 
    	{
            public void keyTyped(KeyEvent ke) 
            {
                char ch = ke.getKeyChar();

                if (!(Character.isDigit(ch) || ch == KeyEvent.VK_BACK_SPACE || ch == KeyEvent.VK_SPACE)) 
                {
                   f1.getToolkit().beep();
                    ke.consume();
                }
                
                
            }
        });
		
        l2 = new JLabel("Name");
        l2.setBounds(150,150,50,25);
        f1.add(l2);
        tf2 = new JTextField();
        tf2.setBounds(230,150,150,25);
        f1.add(tf2);
        
        tf2.addKeyListener(new KeyAdapter()
    	{
    		public void keyTyped(KeyEvent ke)
    		{
    			char ch=ke.getKeyChar();
    		
    		if(!((ch>'A'&& ch<='z')||(ch>='a' && ch<='z')||ch==KeyEvent.VK_BACK_SPACE ||ch==KeyEvent.VK_SPACE))
    		{
    			f1.getToolkit().beep();
    			ke.consume();
    		}
    		}
    	});
        
        l3 = new JLabel("Company Name");
        l3.setBounds(150,200,100,25);
        f1.add(l3);
        tf3 = new JTextField();
        tf3.setBounds(250,200,130,25);
        f1.add(tf3);
        
        tf2.addKeyListener(new KeyAdapter()
    	{
    		public void keyTyped(KeyEvent ke)
    		{
    			char ch=ke.getKeyChar();
    		
    		if(!((ch>'A'&& ch<='z')||(ch>='a' && ch<='z')||ch==KeyEvent.VK_BACK_SPACE ||ch==KeyEvent.VK_SPACE))
    		{
    			f1.getToolkit().beep();
    			ke.consume();
    		}
    		}
    	});
        
        l4 = new JLabel("Mfd");
        l4.setBounds(150,250,50,25);
        f1.add(l4);
        tf4 = new JTextField();
        tf4.setBounds(230,250,150,25);
        //f1.add(tf4);
        dc1= new JDateChooser();
		dc1.setBounds(230,250,150,25);
		dc1.setForeground(new Color(105, 105, 105));
		f1.add(dc1);
        
        l5 = new JLabel("Exp");
        l5.setBounds(150,300,70,25);
        f1.add(l5);
        tf5 = new JTextField();
        tf5.setBounds(230,300,50,25);
        //f1.add(tf5);
        dc2= new JDateChooser();
		dc2.setBounds(230,300,150,25);
		dc2.setForeground(new Color(105, 105, 105));
		f1.add(dc2);
        
        l6 = new JLabel("Price");
        l6.setBounds(150,350,50,25);
        f1.add(l6);
        l9 = new JLabel("Per Piece");
        l9.setBounds(350,350,100,25);
        f1.add(l9);
        tf6 = new JTextField();
        tf6.setBounds(230,350,100,25);
        f1.add(tf6);
        tf6.addKeyListener(new KeyAdapter() 
    	{
            public void keyTyped(KeyEvent ke) 
            {
                char ch = ke.getKeyChar();

                if (!(Character.isDigit(ch) || ch == KeyEvent.VK_BACK_SPACE || ch == KeyEvent.VK_SPACE)) 
                {
                   f1.getToolkit().beep();
                    ke.consume();
                }
                
                
            }
        });
        
        
        l7 =new JLabel("Qty");
        l7.setBounds(150,390,70,25);
        f1.add(l7);
        tf7 = new JTextField();
        tf7.setBounds(230,390,100,25);
        f1.add(tf7);
        tf7.addKeyListener(new KeyAdapter() 
    	{
            public void keyTyped(KeyEvent ke) 
            {
                char ch = ke.getKeyChar();

                if (!(Character.isDigit(ch) || ch == KeyEvent.VK_BACK_SPACE || ch == KeyEvent.VK_SPACE)) 
                {
                   f1.getToolkit().beep();
                    ke.consume();
                }
                
                
            }
        });

        
        b1 = new JButton("Submit");
        b1.setBounds(150,430,90,25);
        b1.addActionListener(this);
        f1.add(b1);
        b2 = new JButton("Cancel");
        b2.setBounds(250,430,90,25);
        b2.addActionListener(this);
        f1.add(b2);
        
		f1.setVisible(true);
		f1.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
					f1.dispose();
					mainframe obj=new mainframe();

			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
		String s1=tf1.getText();
        String s2=tf2.getText();
        String s3=tf3.getText();
        String d1 = ((JTextField) dc1.getDateEditor().getUiComponent()).getText();
        String d2 = ((JTextField) dc2.getDateEditor().getUiComponent()).getText();
        Date DC1=dc1.getDate();
        String D1=myFormat.format(DC1);
        Date DC2=dc2.getDate();
        String D2=myFormat.format(DC2);
        String s6=tf6.getText();
        String s7=tf7.getText();
        Object obj = e.getSource();
        
        if(obj==b2)
        	f1.dispose();
        
        else
        	if(s1.length()==0)
        		JOptionPane.showMessageDialog(f1, "Pls. Enter the ID");
        else
        	if(s2.length()==0)
        		JOptionPane.showMessageDialog(f1, "Pls. Enter the Name of Medicine");
        else
        	if(s3.length()==0)
        		JOptionPane.showMessageDialog(f1, "Pls. Enter the Name of Company");
        else
        	if(d1.length()==0)
        		JOptionPane.showMessageDialog(f1, "Pls. Enter the Manufacturing Date");
        else
        	if(d2.length()==0)
        		JOptionPane.showMessageDialog(f1, "Pls. Enter the Expiry Date");
        else
        	if(s6.length()==0)
        		JOptionPane.showMessageDialog(f1, "Pls. Enter Price/piece");
        else
            if(s6.length()==0)
            	JOptionPane.showMessageDialog(f1, "Pls. Enter Quantity");	
        else
          	 try
  	  {
  		DAO db=new DAO();
  		Connection conn=db.getConnection();
  				
  	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
  	   
  	    String insertQuery = "insert into record values(?,?,?,?,?,?,?)";
  	    PreparedStatement preparedStatement;
  		
  	    preparedStatement = conn.prepareStatement(insertQuery);
  	    preparedStatement.setString(1,s1+"");
  	    preparedStatement.setString(2,s2);
  	    preparedStatement.setString(3,s3);
  	    preparedStatement.setString(4,D1);
  	    preparedStatement.setString(5,D2);
  	    preparedStatement.setString(6,s6);
  	    preparedStatement.setString(7,s7);
  			
  	    preparedStatement.executeUpdate();
  	    System.out.println("Data  Successfully Inserted !!!");
  	 }
  	 catch(Exception o)
  	 {
  		 System.out.println(o);
  	 }

	}
	}

