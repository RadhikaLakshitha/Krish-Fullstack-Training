package registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import registration.model.student;

public class studentDao {
	
	public int registerStudent(student stdt) throws ClassNotFoundException {
		String insert_student = "INSERT INTO register" + " (id, first_name, last_name, password, address, mobile) VALUES " + 
	"(?, ?, ? ,? ,? ,?);";
		
		int result = 0;
		
		Class.forName("com.mysql.jdbc.Driver");
		
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql_database?useSSL=false", "root", "root");
				PreparedStatement preparedStatement = connection.prepareStatement(insert_student)){
			preparedStatement.setInt(1, 1);
			preparedStatement.setString(2, stdt.getFirstName());
			preparedStatement.setString(3, stdt.getLastName());
			preparedStatement.setString(4, stdt.getPassword());
			preparedStatement.setString(5, stdt.getAdddress());
			preparedStatement.setString(6, stdt.getMobile());
			
			
			System.out.println(preparedStatement);
			
			result = preparedStatement.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return result;
		
	}
	

}
