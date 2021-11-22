/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Phu Thinh
 */
public class MainController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String LOGIN = "LoginController";
    private static final String SEARCH = "SearchController";
    private static final String INSERT = "InsertController";
    private static final String LOGOUT = "LogoutController";
    private static final String UPDATE = "UpdateController";
    private static final String DELETE = "DeleteController";
    private static final String USER_SEARCH = "UserSearchController";
    private static final String ADD = "AddOtoController";
    private static final String VIEW = "viewBillPage.jsp";
    private static final String DELETE_BILL = "DeleteBillController";
    private static final String UPDATE_BILL = "UpdateBillController";
    private static final String BUY_OTO = "BuyOtoController";
    private static final String CREATE_USE = "CreateUserController";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String action = request.getParameter("btnAction");
            if ("Login".equals(action)) {
                url = LOGIN;
            } else if ("Search".equals(action)) {
                url = SEARCH;
            } else if ("Insert".equals(action)) {
                url = INSERT;
            } else if ("Logout".equals(action)) {
                url = LOGOUT;
            } else if ("Update".equals(action)) {
                url = UPDATE;
            } else if ("Delete".equals(action)) {
                url = DELETE;
            } else if ("SearchOto".equals(action)) {
                url = USER_SEARCH;
            } else if ("Add".equals(action)) {
                url = ADD;
            } else if ("View".equals(action)) {
                url = VIEW;
            } else if ("Delete Oto".equals(action)) {
                url = DELETE_BILL;
            } else if ("Buy Oto".equals(action)) {
                url = BUY_OTO;
            } else if ("Update Oto".equals(action)) {
                url = UPDATE_BILL;
            } else if ("Create".equals(action)) {
                url = CREATE_USE;
            }
        } catch (Exception e) {
            log("Error at MainController" + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
