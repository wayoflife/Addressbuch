package de.dhbw.web;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Address {

	private int id, number;
	private String name, vorname, addressform, email, phone, mobile, street, city,
			postcode, country;
	private Date birthday;

	public Address() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * lädt die daten der entsprechenden Adresse in die initialisierte Bean
	 * 
	 * @param id
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws SQLException
	 */
	public boolean read(int id) throws InstantiationException,
			IllegalAccessException, ClassNotFoundException, SQLException {
		// felder befüllen aus datenbank
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection conn = DriverManager
				.getConnection("jdbc:mysql://localhost/addressbook?user=root&password=password");
		Statement stmt = conn.createStatement();
		String sql_query = "SELECT * FROM addressbook.address WHERE id = " + id;
		ResultSet rs = stmt.executeQuery(sql_query);
		boolean geladen = false;
		if (rs.next()) {
			this.id = rs.getInt("id");
			name = rs.getString("name");
			vorname = rs.getString("christianname");
			email = rs.getString("email");
			addressform = rs.getString("addressform");
			phone = rs.getString("phone");
			mobile = rs.getString("mobile");
			street = rs.getString("street");
			number = rs.getInt("number");
			city = rs.getString("city");
			postcode = rs.getString("postcode");
			country = rs.getString("country");
			birthday = rs.getDate("birthday");
			geladen = true;
		}

		rs.close();
		stmt.close();
		conn.close();
		return geladen;
	}

	/**Methode zum Speichern des Zustands der Bean in der Datenbank
	 * 
	 * @return true wenn erfolgreich gespeichert wurde, false bei Fehler
	 */
	public boolean save() {
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = DriverManager
					.getConnection("jdbc:mysql://localhost/addressbook?user=root&password=password");
			Statement stmt = conn.createStatement();
			String sql_query = "SELECT * FROM addressbook.address WHERE id = " + id;
			ResultSet rs = stmt.executeQuery(sql_query);
			if (rs.next()) {
				PreparedStatement ps = conn.prepareStatement(
						"UPDATE addressbook.address SET "
						+ "name = ?, "
						+ "christianname = ?, "
						+ "addressform = ?, "
						+ "email = ?, "
						+ "phone = ?, "
						+ "mobile = ?, "
						+ "street = ?, "
						+ "number = ?, "
						+ "city = ?, "
						+ "postcode = ?, "
						+ "country = ?, "
						+ "birthday = ?"
						+ "WHERE id = " + id);
				setPreparedStatementValues(ps);
				ps.executeUpdate();
				ps.close();
			} else {
				
				PreparedStatement ps = conn.prepareStatement("INSERT INTO addressbook.address "
						+ "(name,"
						+ "christianname, "
						+ "addressform, "
						+ "email, "
						+ "phone, "
						+ "mobile, "
						+ "street, "
						+ "number, "
						+ "city, "
						+ "postcode, "
						+ "country, "
						+ "birthday) "
						+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
				
				setPreparedStatementValues(ps);
				ps.executeUpdate();
				ResultSet keys = ps.getGeneratedKeys();
				if (keys.next()) {
					this.id = keys.getInt(1);
				}
				ps.close();
				keys.close();
			}

			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	private void setPreparedStatementValues(PreparedStatement ps)
			throws SQLException {
		ps.setString(1, name);
		ps.setString(2, vorname);
		ps.setString(3, addressform);
		ps.setString(4, email);
		ps.setString(5, phone);
		ps.setString(6, mobile);
		ps.setString(7, street);
		ps.setInt(8, number);
		ps.setString(9, city);
		ps.setString(10, postcode);
		ps.setString(11, country);
		ps.setDate(12, birthday);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number + "";
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getAddressform() {
		return addressform;
	}

	public void setAddressform(String addressform) {
		this.addressform = addressform;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getBirthday() {
		return birthday.toString();
	}

	public void setBirthday(String birthday) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("ddMMyyyy");
		java.util.Date parsed = format.parse(birthday);
		this.birthday = new Date(parsed.getTime());
	}
	
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return id + " " + name + " " + vorname;
	}
}
