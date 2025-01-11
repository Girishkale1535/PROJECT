import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;


public class mainframe implements ActionListener {

	JFrame f1;
	JProgressBar jpb;
	JRadioButton r1,r2,r3,r4,r5,r6,r7;
	JButton b1,b2;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mainframe obj=new mainframe();

	}
	mainframe()
	{
		f1=new JFrame();
		f1.setSize(600,600);
		f1.setTitle("SK Medical Inventory Management System");
		try {
			f1.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Girish Kale\\OneDrive\\Documents\\MedicalInventarymanagementSystem\\Mainimg.jpg")))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		f1.setLocationRelativeTo(null);
		f1.setLayout(null);
		
		
		jpb=new JProgressBar();
		jpb.setOrientation(0);    //0->Horizontal   1->Vertical
		jpb.setBackground(new Color(12,23,255));
		jpb.setFont(new Font("Arial",Font.BOLD,30));
		jpb.setForeground(Color.RED);
		jpb.setIndeterminate(true);
		jpb.setString("SK Medical");
		jpb.setBounds(150,40,300,50);
		jpb.setStringPainted(true);
		f1.add(jpb);
		
		r1=new JRadioButton("Add Record");
		r1.setFont(new Font("Arial",Font.BOLD,20));
		r1.setBounds(200,100,200,30);
		f1.add(r1);
		
		r2=new JRadioButton("Delete Medicine");
		r2.setFont(new Font("Arial",Font.BOLD,20));
		r2.setBounds(200,150,200,30);
		f1.add(r2);
		
		r3=new JRadioButton("Search by Name");
		r3.setFont(new Font("Arial",Font.BOLD,20));
		r3.setBounds(200,200,200,30);
		f1.add(r3);
		
		r4=new JRadioButton("Search by ID");
		r4.setFont(new Font("Arial",Font.BOLD,20));
		r4.setBounds(200,250,200,30);
		f1.add(r4);
		
		r5=new JRadioButton("Update Medicine");
		r5.setFont(new Font("Arial",Font.BOLD,20));
		r5.setBounds(200,300,200,30);
		f1.add(r5);
		
		r6=new JRadioButton("Display All");
		r6.setFont(new Font("Arial",Font.BOLD,20));
		r6.setBounds(200,350,200,30);
		f1.add(r6);
		
		r7=new JRadioButton("Display Expired");
		r7.setFont(new Font("Arial",Font.BOLD,20));
		r7.setBounds(200,400,200,30);
		f1.add(r7);
		
		 b1 = new JButton("Run");
	     b1.setBounds(200,440,90,25);
	     b1.addActionListener(this);
         f1.add(b1);
         b2 = new JButton("Cancel");
	     b2.setBounds(300,440,90,25);
         b2.addActionListener(this);
	     f1.add(b2);
	        
				
		f1.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 Object obj = e.getSource();
		 f1.dispose();
	        
	        if(obj==b2)
	        	f1.dispose();
	        else if(obj==b1)
	        {
	        	if (r1.isSelected())
	            {
	        		AddRecord AD = new AddRecord();
	            }
	        	if (r2.isSelected())
	            {
	        		DeleteMedicine DM=new DeleteMedicine();
	            }
	        	if (r3.isSelected())
	            {
	        		SearchByname SN=new SearchByname();
	            }
	        	if (r4.isSelected())
	            {
	        		SearchbyId SI=new SearchbyId();
	            }
	        	if (r5.isSelected())
	            {
	        		updateMedicine UM = new updateMedicine();
	            }
	        	if (r6.isSelected())
	            {
	            	DisplyAllRecords.display();
	            }
	        	if (r7.isSelected())
	            {
	        		ShowExpired.Search();
	            }
	        }
		
	}

}
