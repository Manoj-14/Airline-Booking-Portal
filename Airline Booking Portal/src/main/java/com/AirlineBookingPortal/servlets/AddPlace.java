package com.AirlineBookingPortal.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AirlineBookingPortal.Utils.PlaceUtil;

@WebServlet("/AddPlace")
public class AddPlace extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AddPlace() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PlaceUtil.addplace("Mysore");
		PlaceUtil.addplace("Banglore");
	}

}
