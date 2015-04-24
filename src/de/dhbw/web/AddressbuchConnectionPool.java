package de.dhbw.web;

import java.sql.Connection;
import java.sql.SQLException;

import com.jolbox.bonecp.BoneCPDataSource;

public class AddressbuchConnectionPool {
	
	private BoneCPDataSource ds;

	public AddressbuchConnectionPool() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			ds = new BoneCPDataSource();
			
			ds.setJdbcUrl("jdbc:mysql://localhost/addressbook");
			ds.setUsername("root");
			ds.setPassword("password");
		} catch (ClassNotFoundException e) {

		}
	}
	
	public Connection getConnection(){
		try {
			return ds.getConnection();
		} catch (SQLException e) {

		}
		return null;
	}

}
