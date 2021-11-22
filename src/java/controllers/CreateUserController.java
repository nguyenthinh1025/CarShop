/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.UserDAO;
import dtos.ErrorUserDTO;
import dtos.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Phu Thinh
 */
public class CreateUserController extends HttpServlet {

    private static final String ERROR = "createUser.jsp";
    private static final String SUCCESS = "login.jsp";
    private static final String US = "US";

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
            String userID = request.getParameter("userID");
            String fullName = request.getParameter("fullName");
            String password = request.getParameter("password");
            String confirm = request.getParameter("confirm");
            String role = US;
            boolean check = true;
            ErrorUserDTO errorUser = new ErrorUserDTO();
            if (userID.length() < 2 || userID.length() > 10) {
                check = false;
                errorUser.setUserIDError("UserID must be in [2,10]");
            }
            if (userID.length() < 3 || fullName.length() > 20) {
                check = false;
                errorUser.setFullNameError("FullName must be in [5,20]");
            }

            if (confirm.isEmpty() || !password.equals(confirm)) {
                check = false;
                errorUser.setConfirmError("Two passwords are not the same");
            }
            if (check) {
                UserDAO dao = new UserDAO();
                boolean checkDuplicate = dao.Duplicate(userID);
                if (checkDuplicate) {
                    errorUser.setUserIDError("Duplicate UserID!!");
                    request.setAttribute("ERROR_USER", errorUser);
                } else {
                    UserDTO user = new UserDTO(userID, fullName, role, password);
                    boolean checkInsert = dao.insert(user);
                    if (checkInsert) {
                        url = SUCCESS;
                    }
                }

            } else {
                request.setAttribute("ERROR_USER", errorUser);
            }
        } catch (Exception e) {
            log("ERROR  at CreateUserController :" + e.toString());
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
