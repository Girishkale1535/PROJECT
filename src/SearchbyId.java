import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class SearchbyId implements ActionListener
{
	JFrame f1;
	JButton b1,b2;
	 JLabel l1,l2;
	    JTextField tf1;
	    
	    
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SearchbyId SI=new SearchbyId();
		

	}
	
	
	SearchbyId()
	{
		f1=new JFrame();
    	f1.setSize(400,300);
    	f1.setBackground(new Color(90,194,199));
    	f1.setLocationRelativeTo(null);
    	f1.setLayout(null);
    	try {
			f1.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Girish Kale\\OneDrive\\Documents\\MedicalInventarymanagementSystem\\Mainimg.jpg")))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	l1=new JLabel("Search By ID");
    	l1.setFont(new Font("Arial",Font.BOLD,22));
    	l1.setBounds(100,45,250,35);
    	f1.add(l1);
    	
    	l2=new JLabel("Enter ID");
    	l2.setFont(new Font("Arial",Font.PLAIN,18));
    	l2.setBounds(55,90,100,30);
    	f1.add(l2);
    	
    	tf1=new JTextField();
    	tf1.setBounds(160,90,170,30);
    	tf1.setFont(new Font("Arial",Font.PLAIN,18));
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
                 
                 else if (tf1.getText().length() ==10) 
                 {
                     ke.consume();
                     
                         f1.getToolkit().beep();
                          ke.consume();
                      }
                 
             }
         });
    	
    	
    	b1=new JButton("Search");
    	b1.setFont(new Font("Arial",Font.PLAIN,18));
    	b1.setBounds(70,150,100,30);
    	b1.setBackground(new Color(255,255,255));
    	b1.addActionListener(this);
    	f1.add(b1);
    	
    	b2=new JButton("Cancel");
    	b2.setBounds(210,150,100,30);
    	b2.setFont(new Font("Arial",Font.PLAIN,18));
    	b2.setBackground(new Color(255,255,255));
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
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		String s1=tf1.getText();
		
		Object obj=e.getSource();
		if(obj==b2)
			f1.dispose();
		
		else if(s1.length()==0)
			JOptionPane.showMessageDialog(f1, "Pls Enter ID");
		else
			try
			  {
				DAO db=new DAO();
				Connection conn=db.getConnection();
				
				String selectQuery = "select * from record where id=?";   	    
				PreparedStatement preparedStatement = conn.prepareStatement(selectQuery);

				preparedStatement.setString(1, s1+"");
				ResultSet result = preparedStatement.executeQuery();
				
		 	
				
					
				//int count = preparedStatement.executeUpdate();
				
				if(result.first())
				{	System.out.println(" Record found !!!");
				    System.out.println("Id= "+result.getString(1));
	    	        System.out.println("Medicine Name= "+result.getString(2));
	    	        System.out.println("Company Name= "+result.getString(3));
	    	        System.out.println("MFD= "+result.getString(4));
	    	        System.out.println("EXP= "+result.getString(5));
	    	        System.out.println("Price= "+result.getString(6));
	    	        System.out.println("Quantity= "+result.getString(7));
	    	        JOptionPane.showMessageDialog(f1,"Id= "+result.getString(1)+"\n"+"Medicine Name= "+result.getString(2)+"\n"+"Company Name= "+result.getString(3)+"\n"+"MFD= "+result.getString(4)+"\n"+"EXP= "+result.getString(5)+"\n"+"Price= "+result.getString(6)+"\n"+"Quantity= "+result.getString(7));
				}
				else
				{	   System.out.println("No Recored Found with ID= !!!"+s1);
				       JOptionPane.showMessageDialog(f1,"ID Not Found");
				}
			  }
			 catch(Exception e1)
			 {
				 System.out.println(e);
			 }

	}

}