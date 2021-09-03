package jdbcbasics;
import java.sql.*;
import java.util.Scanner;
public class InsertOp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Movie Details");
		String movie = sc.next();
		String hero = sc.next();
		String heroine = sc.next();
		String director = sc.next();
		int year = sc.nextInt();
		System.out.print("**************");
           insert(movie,hero,heroine,director,year);
           getDetails();
	}
	public static void insert(String movie,String hero,String heroine, String director,int year) {
		Connection conn = DbConnection.connect();
		PreparedStatement st = null;
	  try {
          String sql = "INSERT INTO MOVIES VALUES(?,?,?,?,?)"; 
          st = conn.prepareStatement(sql);  
          st.setString(1, movie);
          st.setString(2,hero);
          st.setString(3, heroine);
          st.setString(4, director);
          st.setInt(5, year);
          st.execute();
		  System.out.println("Date inserted");
	  }
	  catch ( Exception e ) {
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	         System.exit(0);
	      }
	}
	public static void getDetails() {
		Connection conn = DbConnection.connect();
		Statement st = null;
		try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM MOVIES");
            while(rs.next()) {
            	System.out.println("Movie: " + rs.getString(1) + " Hero: " + rs.getString(2) + " Heroine: " + rs.getString(3) + " Director: " + rs.getString(4) + " Year: " + rs.getInt(5));
            }
            Scanner sc = new Scanner(System.in);
            System.out.println("Do you want to get movies of your fav actors? TYPE y/n");
            char d = sc.next().charAt(0);
            if(d=='y') System.out.println("Enter Actor Name");
            else{
            	System.out.println("Ok then See yo'later");
            	st.close();
            conn.close();
            System.exit(0);
            }
            String hero = sc.next();
//            st.execute()
            ResultSet ts = st.executeQuery("SELECT * FROM MOVIES WHERE ACTOR= '"+hero+"'");
            while(rs.next()) {
            	System.out.println("MovieName: " + rs.getString(1));
            }
            st.close();
            conn.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
	}
}
}