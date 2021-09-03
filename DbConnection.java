package jdbcbasics;
import java.sql.*;
public class DbConnection {

		// TODO Auto-generated method stub
		  public static Connection connect() {
		        Connection conn = null;
		        Statement st = null;
		        try {
		            // db parameters
		            String url = "jdbc:sqlite:Movies.db";
		            // create a connection to the database
		     
		            conn = DriverManager.getConnection(url);
//		            st = conn.createStatement();
//		            String sql = "INSERT INTO MOVIES(ID,MOVIE_NAME,ACTOR,ACTRESS,DIRECTOR,YEAR) VALUES(1,'Bahu','prabhas','anusk','raj',2010)";
//		            st.executeUpdate(sql);
		            System.out.println("Connection to SQLite has been established.");
		            
		        } catch (SQLException e) {
		            System.out.println(e.getMessage());
		        }
		        return conn;
		    }
//		  public static void main(String[] args) {
//			  connect();
//		  }
//		 
		}