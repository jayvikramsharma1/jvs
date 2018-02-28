package uk.co.news.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlLiteDBImpls {
	Connection c = null;
    Statement stmt = null;
	private SqlLiteDBImpls() {
	    
	}
	public static Statement getStatement() {
		Connection c = null;
	    Statement stmt = null;
        try {
        	Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:MAT.db");
			stmt = c.createStatement();
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return stmt;
	    
        
        
        /*try {
	         Statement stmt = SqlLiteDBImpls.getStatement();
	         String sql = "CREATE TABLE MANIFESTS " +
	                        "(ID INTEGER PRIMARY KEY	AUTOINCREMENT," +
	                        " TIMESTAMP			TEXT NOT NULL, " + 
	                        " TITLE            	TEXT NOT NULL, " + 
	                        " MANIFEST_TEXT     TEXT NOT NULL) "; 
	         stmt.executeUpdate(sql);
	         stmt.close();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	         //System.exit(0);
	      }
	      System.out.println("Table created successfully");*/
        
        /*ResultSet rs = stmt.executeQuery( "SELECT * FROM MANIFESTS ORDER BY TIMESTAMP DESC;" );
        
        while ( rs.next() ) {
           int id = rs.getInt("id");
           String  title = rs.getString("TITLE");
           String  timestamp = rs.getString("TIMESTAMP");
           String  manifests = rs.getString("MANIFEST_TEXT");

           
           System.out.println( "ID = " + id );
           System.out.println( "Title = " + title );
           System.out.println( "timestamp = " + timestamp );
           System.out.println( "manifests = " + manifests );
           System.out.println();
        }
        rs.close();
*/
	}
}
