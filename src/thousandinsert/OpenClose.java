/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package thousandinsert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.time.LocalDateTime;

/**
 *
 * @author nierema_sd2081
 */
public class OpenClose {
    
    public static void main (String []args)
    {
        try
        {
            LocalDateTime now = LocalDateTime.now();  
            System.out.println("Time started: "+ now);
            while(true)
            {
                String driver = "com.mysql.jdbc.Driver";
                String url = "jdbc:mysql://localhost:3306/niere";
                Class.forName(driver);
                
                Connection conn = DriverManager.getConnection(url, "root", "");
                
                int count= 0;
                while(!(count == 300)) 
                {
                    int one =1 , two=2, three=3,four=4, five=5;
                
                String insertQuery = " insert into insertThousand (one, two, tree, four, five)" + "values ('" + one + "','" + two + "', '"
                    + three + "','" + four + "','" + five  + "')";                
                Statement st = conn.createStatement();
                System.out.println(one+ " "+ two + " "+ three+ " "+ four+ " "+ five);
                st.execute(insertQuery);
                count++;

                }
                conn.close();
                System.out.println("Time ended: "+ now);

            }
        }
        catch(Exception e)
        {
            
        }
    }
    
}
