package tWSEchker;
import java.sql.*;
import javax.swing.*;


final class Thesqlconnector {
	Connection conn=null;
	public static Connection dbconnector() {
		try {Class.forName("org.sqlite.JDBC");
		Connection conn=DriverManager.getConnection("jdbc:sqlite:/workspace/JavaGuiDemo V1.1/the_reminderdatabase.sqlite");
		JOptionPane.showMessageDialog(null, "database connected!!");
		
		return conn;		
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "database connect fail !!");
			return null;
			
		}
		
	}

}
