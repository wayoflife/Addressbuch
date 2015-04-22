package de.dhbw.web;

import java.io.IOException;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Address ad = new Address();
		if(ad.save()){
			String referer = "/Adressbuch/List.jsp?id="+ad.getId();
			System.out.println("Speichern erfolgreich: " + referer);
			response.sendRedirect(referer);
		} else {
			String referer = request.getHeader("Referer");
			System.out.println("Speichern nicht erfolgreich: " + referer);
			response.sendRedirect(referer);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Address ad = new Address();
		if(ad.save()){
			String referer = "/Adressbuch/List.jsp?id="+ad.getId();
			System.out.println("Speichern erfolgreich: " + referer);
			response.sendRedirect(referer);
		} else {
			String referer = request.getHeader("Referer");
			System.out.println("Speichern nicht erfolgreich: " + referer);
			response.sendRedirect(referer);
		}
	}
}
