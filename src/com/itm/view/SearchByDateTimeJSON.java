package com.itm.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.itm.controller.DBHelper;
import com.itm.controller.TrackingController;

/**
 * Servlet implementation class SearchByDateTimeJSON
 */
@WebServlet("/SearchByDateTimeJSON")
public class SearchByDateTimeJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchByDateTimeJSON() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		ResultSet rs=TrackingController.searchByTimeDate(request.getParameter("tracking_date"),request.getParameter("fromTime"), request.getParameter("toTime"), request.getParameter("mobileno"));
		ArrayList<JSONObject> list=DBHelper.JsonEngine(rs);
		out.print(list);
	}

}
