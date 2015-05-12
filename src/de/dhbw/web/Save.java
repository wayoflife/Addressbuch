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

	protected void doGet(HttpServletRequest rq, HttpServletResponse rs)
			throws ServletException, IOException {
		bearbeiteSave(rq, rs);
	}

	protected void doPost(HttpServletRequest rq, HttpServletResponse rs)
			throws ServletException, IOException {
		bearbeiteSave(rq, rs);
	}

	private void bearbeiteSave(HttpServletRequest rq, HttpServletResponse rs)
			throws IOException {
		if (rq.isUserInRole("ADMIN")) {
			Address ad = new Address();
			if (rq.getParameter("id") != null && !rq.getParameter("id").isEmpty()) {
				ad.setId(Integer.parseInt(rq.getParameter("id")));
			}
			saveAdress(ad, rq, rs);
			
		} else if(rq.isUserInRole("ADMIN7")){
			
			String newPostcode = rq.getParameter("postcode");  
			Address ad = new Address();
			if (rq.getParameter("id") != null && !rq.getParameter("id").isEmpty()) {
				ad.setId(Integer.parseInt(rq.getParameter("id")));
			}
			if( newPostcode.startsWith("7") && ad.getPostcode().startsWith("7") ){
				saveAdress(ad, rq, rs);
			}
			
		} else {
			rs.sendRedirect("/Adressbuch");
		}
	}

	private void saveAdress(Address ad, HttpServletRequest rq, HttpServletResponse rs) {
		
		if (rq.getParameter("birthday") != null
				&& !rq.getParameter("birthday").isEmpty()) {
			try {
				ad.setBirthday(rq.getParameter("birthday"));
			} catch (ParseException e) {
				// TODO ändern?
			}
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
		try {
			if (ad.save()) {
				String referer = "/Adressbuch/Detail.jsp?id=" + ad.getId();
				System.out.println("Speichern erfolgreich: " + referer);
				rs.sendRedirect(referer);
			} else {
				String referer = rq.getHeader("Referer");
				System.out.println("Speichern nicht erfolgreich: " + referer);
				rs.sendRedirect(referer);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
