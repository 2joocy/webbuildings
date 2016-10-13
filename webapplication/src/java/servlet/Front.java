/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DbHandler.*;
import entities.Building;
import javax.servlet.http.HttpSession;

/**
 *
 * @author William-PC
 */
@WebServlet(name = "Front", urlPatterns = {"/Front"})
public class Front extends HttpServlet {

    DbBuildingHandler handler = new DbBuildingHandler();
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter writer = response.getWriter();
        
        String method = request.getParameter("method");
        String buildingID = request.getParameter("buildingID");
        
        String address = request.getParameter("address");
        int zip = -1;
        String city = null;
        String contactPerson = null;
        String contactPhone = null;
        if (address != null) {
             zip = Integer.parseInt(request.getParameter("zip"));
             city = request.getParameter("city");
             contactPerson = request.getParameter("contactPerson");
             contactPhone = request.getParameter("contactPhone");
        }
        Building building = handler.getBuilding(Integer.parseInt(buildingID));
        
        switch (method) {
            case "edit1":
                HttpSession session = request.getSession();
                session.setAttribute("editbuilding", building);
                response.sendRedirect("editBuilding.jsp");
                break;
                
            case "edit2":
                building.setAddress(address);
                building.setZip(zip);
                building.setCity(city);
                building.setContactPerson(contactPerson);
                building.setContactPhone(contactPhone);
                handler.updateDatabase(building);
                response.sendRedirect("index.jsp");
                break;
                
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
