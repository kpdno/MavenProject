package lesson28;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectToDB {

	public static void main(String[] args) {
		
		String conUrl = "jdbc:sqlite:C:\\Users\\Acer\\mydatabase.db";
		
		String selectAll = "select * from contacts";
		String createOrdersTable = "create table if not exists orders (id integer, item text, amount int)";
		
		try {
			Connection conn = DriverManager.getConnection(conUrl);
			Statement statement = conn.createStatement();
			statement.execute(createOrdersTable);
//			statement.execute("insert into orders values(1, 'book', 3)");
			
			ResultSet contactData = statement.executeQuery(selectAll);
			while(contactData.next()) {
				System.out.println("Name: " + contactData.getString("name") + 
						" Phone: " + contactData.getInt(2) +
						" Email: " + contactData.getString("email"));
			}
			
			
			//clean up
			contactData.close();
			statement.close();
			conn.close();
			System.out.println("Executed successfully");
		} catch (SQLException e) {	
			System.out.println("Code crashed");
			e.printStackTrace();
		}

	}

}
