package de.dhbw.web;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Save")
public class Save extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Save() {
        super();
    }

	protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		Address ad = new Address();
		if (rq.getParameter("id") != null) {
			ad.setId(Integer.parseInt(rq.getParameter("id")));
		}
		try {
			ad.setBirthday(rq.getParameter("birthday"));
		} catch (ParseException e) {
			//TODO ändern?
		}
		ad.setAddressform(rq.getParameter("addressform"));
		ad.setCity(rq.getParameter("city"));
		ad.setCountry(rq.getParameter("country"));
		ad.setEmail(rq.getParameter("email"));
		ad.setMobile(rq.getParameter("mobile"));
		ad.setName(rq.getParameter("name"));
		ad.setNumber(Integer.parseInt(rq.getParameter("number")));
		ad.setPhone(rq.getParameter("phone"));
		ad.setPostcode(rq.getParameter("postcode"));
		ad.setStreet(rq.getParameter("street"));
		ad.setVorname(rq.getParameter("vorname"));
		if(ad.save()){
			String referer = "/Adressbuch/List.jsp";
			System.out.println("Speichern erfolgreich: " + referer);
			rs.sendRedirect(referer);
		} else {
			String referer = rq.getHeader("Referer");
			System.out.println("Speichern nicht erfolgreich: " + referer);
			rs.sendRedirect(referer);
		}
	}

	protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		Address ad = new Address();
		if (rq.getParameter("id") != null) {
			ad.setId(Integer.parseInt(rq.getParameter("id")));
		}
		try {
			ad.setBirthday(rq.getParameter("birthday"));
		} catch (ParseException e) {
			//TODO ändern?
		}
		ad.setAddressform(rq.getParameter("addressform"));
		ad.setCity(rq.getParameter("city"));
		ad.setCountry(rq.getParameter("country"));
		ad.setEmail(rq.getParameter("email"));
		ad.setMobile(rq.getParameter("mobile"));
		ad.setName(rq.getParameter("name"));
		if (rq.getParameter("number") != null && !rq.getParameter("number").isEmpty()) {
			ad.setNumber(Integer.valueOf(rq.getParameter("number")));
		}
		ad.setPhone(rq.getParameter("phone"));
		ad.setPostcode(rq.getParameter("postcode"));
		ad.setStreet(rq.getParameter("street"));
		ad.setVorname(rq.getParameter("vorname"));
		if(ad.save()){
			String referer = "/Adressbuch/List.jsp";
			System.out.println("Speichern erfolgreich: " + referer);
			rs.sendRedirect(referer);
		} else {
			String referer = rq.getHeader("Referer");
			System.out.println("Speichern nicht erfolgreich: " + referer);
			rs.sendRedirect(referer);
		}
	}
}
