import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
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


public class DeleteMedicine implements ActionListener{

	private static final String String = null;
	JFrame f1;
	JButton b1,b2;
	JLabel l,l1;
	JTextField tf1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeleteMedicine DM=new DeleteMedicine();

	}
	DeleteMedicine()
	{
		f1=new JFrame();
		f1.setSize(350,300);
		f1.setLayout(null);
		f1.setLocationRelativeTo(null);
		try {
			f1.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Girish Kale\\OneDrive\\Documents\\MedicalInventarymanagementSystem\\Mainimg.jpg")))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		l=new JLabel("Delete Record");
		l.setBounds(100,20,150,80);
		l.setFont(new Font("Arial",Font.BOLD,20));
		f1.add(l);
		
		l1=new JLabel("Id :");
		l1.setBounds(50,60,50,80);
		l1.setFont(new Font("Arial",Font.BOLD,20));
		f1.add(l1);
		
		tf1= new JTextField();
		tf1.setBounds(100,85,180,30);
	    f1.add(tf1);
	    
	    b1=new JButton("OK");
	    b1.setBounds(85,150,80,30);
	    b1.addActionListener(this);
	    f1.add(b1);
	    
	    
	    b2=new JButton("Cancel");
	    b2.setBounds(180,150,80,30);
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
Object obj = e.getSource();
        
        if(obj==b2)
        	f1.dispose();
        else if(obj==b1)
        {
        	if(s1.length()==0)
        		JOptionPane.showMessageDialog(f1, "Pls. Enter the ID");

        else	
        
        	try
  	  {
  		DAO db=new DAO();
  		Connection conn=db.getConnection();
  	   	   
  	    String deleteQuery = "delete from record where id=?";
  		PreparedStatement preparedStatement;
  		
  		preparedStatement = conn.prepareStatement(deleteQuery);
  		preparedStatement.setString(1, s1+"");
  			
  		int count = preparedStatement.executeUpdate();
  		
  		if(count==0)		
  		{
     		    JOptionPane.showMessageDialog(f1,"ID Not Found :"+s1);
  		}       
  		else
  			JOptionPane.showMessageDialog(f1,"ID :"+s1+ " Records Deleted !!!");
  	 }
  	 catch(Exception e1)
  	 {
  		 System.out.println(e);
  	 }
		
	}
	}}
