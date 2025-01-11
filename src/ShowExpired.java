import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ShowExpired {
	
	static String rows[][] = new String [100][7];

	static int row=0;
    public static void Search() {
    
        try{
        	DAO db=new DAO();
    	    Connection conn=db.getConnection();
    	 
    	    SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
            String query = "select * from  record where exp";
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery(); 
            
            
            while (rs.next()) {
            	SimpleDateFormat sf = new SimpleDateFormat("dd MM yyyy");
                String EXP=rs.getString(5);
                System.out.println("Expired Date= "+EXP);
                Date cd = new Date();
        		String val = sf.format(cd);
        		System.out.println("Current Date= "+val);

        	try
        	{
            		Date date1 = myFormat.parse(EXP);
            		Date date2 = myFormat.parse(val);
            		long diff = date2.getTime() - date1.getTime();
            		System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
            		if (diff>0)
            		{
            			System.out.println("Expired");
            			for (int i = 0; i < 7; i++)
            				rows[row][i] =rs.getString((i+1));
            				row++;
            		}
            		else
            		{
            			System.out.println("Not Expired");
            		}
        	}
        	
        	catch (Exception e)
        	{
            		e.printStackTrace();
        	}
        	
        		}
            expireddisplay.populateArray(rows);
            }
        
            
           
             
            catch (SQLException e)
            {
            System.out.println("Error searching for expired medicines: " + e.getMessage());
            }
        
        
   }
}
   