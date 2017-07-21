package com.tracker.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Servlet implementation class CoordinateReaderServlet
 */

public class CoordinateReaderServlet extends HttpServlet implements Servlet {

	Map<String, String> map = new HashMap<String, String>();

	public CoordinateReaderServlet() 
	{
		map.put("longitude", "");
		map.put("latitude", "");
		map.put("imei", "");
		System.out.println("CoordinateReaderServlet");
	}

	protected void doGet(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		doread(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		doread(request, response);
	}

	protected void doread(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String dataRead = request.getParameter("read");
		System.out.println("dataRead===" + dataRead);
		if (dataRead != null && dataRead.equalsIgnoreCase("Y")) {
			response.setContentType("text/xml;charset=UTF-8");
			PrintWriter out = response.getWriter();
			System.out.println("Inside If===");
			StringBuffer sb = new StringBuffer();
			// sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append("<responseData>");
			sb.append("<longitude>").append(map.get("longitude"))
					.append("</longitude>");
			sb.append("<latitude>").append(map.get("latitude"))
					.append("</latitude>");
			sb.append("</responseData>");
			out.write(sb.toString());
		} else {
			String longitude = request.getParameter("longitude");
			String latitude = request.getParameter("latitude");
			String imei = request.getParameter("imei");
			System.out.println("Else===");
			map.put("longitude", longitude);
			map.put("latitude", latitude);
			map.put("imei", imei);
			System.out.println("longitude===" + longitude);
			System.out.println("latitude====" + latitude);
			System.out.println("imei========" + imei);
		}
	}
}