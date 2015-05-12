package de.dhbw.web;

import java.sql.Connection;
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

	public List<Address> getAddressListe() throws SQLException {
		Connection conn = new AddressbuchConnectionPool().getConnection();
		System.out.println(suchtext);
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM addressbook.address WHERE name LIKE ?");
		ps.setString(1, "%" + suchtext + "%");
		ResultSet rs = ps.executeQuery();
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
		ps.close();
		conn.close();
		return addressListe;
	}
	
	public void delete(int id) throws SQLException{
		
		Connection conn = new AddressbuchConnectionPool().getConnection();
		PreparedStatement ps = conn.prepareStatement("DELETE FROM address WHERE id = ? ");
		ps.setString(1, id+"");
		ps.execute();
		
		ps.close();
		conn.close();
	}
	

	public void setAdressListe(List<Address> adressListe) {
		this.addressListe = adressListe;
	}

}
