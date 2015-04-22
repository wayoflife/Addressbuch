package de.dhbw.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AddressList {
	
	private String suchtext = "";
	private List<Address> addressListe;
	
	public AddressList() {
		addressListe = new ArrayList<>();
	}

	public String getSuchtext() {
		return suchtext;
	}

	public void setSuchtext(String suchtext) {
		this.suchtext = suchtext;
	}

	public List<Address> getAddressListe() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection conn = DriverManager
				.getConnection("jdbc:mysql://localhost/addressbook?user=root&password=password");
		Statement stmt = conn.createStatement();
		String sql_query = "SELECT * FROM addressbook.address WHERE name LIKE '%" + suchtext + "%'";
		ResultSet rs = stmt.executeQuery(sql_query);
		while (rs.next()) {
			Address ad = new Address();
			ad.setId(rs.getInt("id"));
			ad.setName(rs.getString("name"));
			ad.setVorname(rs.getString("christianname"));
			ad.setEmail(rs.getString("email"));
			ad.setAddressform(rs.getString("addressform"));
			ad.setPhone(rs.getString("phone"));
			ad.setMobile(rs.getString("mobile"));
			ad.setStreet(rs.getString("street"));
			ad.setNumber(rs.getInt("number"));
			ad.setCity(rs.getString("city"));
			ad.setPostcode(rs.getString("postcode"));
			ad.setCountry(rs.getString("country"));
			ad.setBirthday(rs.getDate("birthday"));
			addressListe.add(ad);
		}
		rs.close();
		stmt.close();
		conn.close();
		return addressListe;
	}
	
	public void delete(int id) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection conn = DriverManager
				.getConnection("jdbc:mysql://localhost/addressbook?user=root&password=password");
		
		PreparedStatement ps = conn.prepareStatement("DELETE FROM address WHERE id = "+ id);
		ps.execute();
		
		ps.close();
		conn.close();
	}

	public void setAdressListe(List<Address> adressListe) {
		this.addressListe = adressListe;
	}

}
