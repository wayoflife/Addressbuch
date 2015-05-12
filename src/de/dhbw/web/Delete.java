package de.dhbw.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Delete() {
		super();
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
		if (request.isUserInRole("admin")) {
			try {
				String attribute = request.getParameter("id");
				System.out.println("parameter: " + attribute);
				int id = Integer.parseInt(attribute);
				new AddressList().delete(id);
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
			}
		}
		else {
			response.sendRedirect("/Adressbuch");
		}
	}
}
