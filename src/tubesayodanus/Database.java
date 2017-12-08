/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubesayodanus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author hanifussafly
 */
public class Database {
    private String dbuser = "root";
    private String dbpass = "";
    private Statement stmt = null;
    private Connection conn =null;
    private ResultSet rs = null;
    
    public Database(){
        //load jdbc
        try{
            Class.forName("org.gjt.mm.mysql.Driver");
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, ""+e.getMessage(),"JDBC DRIVER ERROR", JOptionPane.WARNING_MESSAGE);
        }
        
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbdanus", dbuser, dbpass);
            stmt = conn.createStatement();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, ""+e.getMessage(), "Connection error", JOptionPane.WARNING_MESSAGE);
            
        }
    }
    public ResultSet getData(String SQLString){
        try{
            rs= stmt.executeQuery(SQLString);
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+ e.getMessage(),"Communication Error",JOptionPane.WARNING_MESSAGE);
            
        }
        return rs;
    }
    public void query(String SQLString){
        try{
            stmt.executeUpdate(SQLString);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "error: "+ e.getMessage(),"Communication Error", JOptionPane.WARNING_MESSAGE);
        }
    }
    
}
