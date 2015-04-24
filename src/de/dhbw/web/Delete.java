package de.dhbw.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private InitialContext context;
	private DataSource ds;
	private Connection conn;

	public Delete() {
		super();
		try {
			context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/MySQLDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		bearbeiteDelete(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		bearbeiteDelete(request, response);
	}

	private void bearbeiteDelete(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		try {
			String attribute = request.getParameter("id");
			System.out.println("parameter: " + attribute);
			int id = Integer.parseInt(attribute);
			conn = ds.getConnection();
			new AddressList().delete(id, conn);
			String referer = "/Adressbuch";
			System.out.println("Eintrag wurde gelöscht, id: " + id);
			System.out.println("Keine exception: " + referer);
			response.sendRedirect(referer);
		} catch (NumberFormatException ef) {
			String referer = request.getHeader("Referer");
			System.out.println("NumberFormatException: " + referer);
			response.sendRedirect(referer);
		} catch (Exception e) {
			String referer = "/Adressbuch";
			System.out.println("Sonstige Exception: " + referer);
			response.sendRedirect(referer);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// ignorieren, kann man nicht behandeln hier
				}
				conn = null;
			}
		}
	}
}
