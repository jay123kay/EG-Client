package com.eg.electrogrid;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class PowerPlantsAPI
 */
public class PowerPlantsAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	powerplant powerplantObj= new powerplant();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PowerPlantsAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String output = powerplantObj.insertPowerPlant( 
				request.getParameter("name"),
				request.getParameter("type"), 
				request.getParameter("address"), 
				request.getParameter("capacity"));
		response.getWriter().write(output);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		{ 
			 Map paras = getParasMap(request); 
			 String output = powerplantObj.updatePowerPlant(paras.get("hidPowerPlantidSave").toString(), 
			 paras.get("name").toString(), 
			paras.get("type").toString(), 
			paras.get("address").toString(), 
			paras.get("capacity").toString()); 
			response.getWriter().write(output); 
			}
			}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		{ 
			 Map paras = getParasMap(request); 
			 String output = powerplantObj.deletePowerPlant(paras.get("id").toString()); 
			response.getWriter().write(output);
	}

}// Convert request parameters to a Map
	private static Map getParasMap(HttpServletRequest request) 
	{ 
	 Map<String, String> map = new HashMap<String, String>(); 
	try
	 { 
	 Scanner scanner = new Scanner(request.getInputStream(), "UTF-8"); 
	 String queryString = scanner.hasNext() ? 
	 scanner.useDelimiter("\\A").next() : ""; 
	 scanner.close(); 
	 String[] params = queryString.split("&"); 
	 for (String param : params) 
	 { 
	 String[] p = param.split("="); 
	 map.put(p[0], p[1]); 
	 } 
	 } 
	catch (Exception e) 
	 { 
	 } 
	return map; 
	}
}