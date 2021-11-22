/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.ProductDAO;
import dtos.ProductDTO;
import dtos.ProductError;
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
public class InsertController extends HttpServlet {

    private final static String ERROR = "insert.jsp";
    private final static String SUCCESS = "search.jsp";

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
        ProductError error = new ProductError("", "", "", "", "", "");
        try {
            String otoID = request.getParameter("txtID");
            String otoName = request.getParameter("txtName");
            String image = request.getParameter("txtImage");
            String price = request.getParameter("txtPrice");
            String quantity = request.getParameter("txtQuantity");
            String catagoryID = request.getParameter("txtCatagory");
            ProductDAO pdao = new ProductDAO();
            boolean check = true;
            if (otoID.isEmpty()) {
                check = false;
                error.setOtoIDError("otoID is wrong format !");
            }
            if (otoName.isEmpty()) {
                check = false;
                error.setOtoNameError("otoName is not empty !");
            }
            if (image.isEmpty()) {
                check = false;
                error.setImageError("Image is not empty !");
            }
            if (price.isEmpty()) {
                try {
                    float priceF = Float.parseFloat(price);
                } catch (NumberFormatException e) {
                    check = false;
                    error.setPriceError("Price is not empty !");
                }
            }
            if (quantity.isEmpty()) {
                try {
                    int quantityI = Integer.parseInt(quantity);
                } catch (NumberFormatException e) {
                    check = false;
                    error.setQuantityError("Quantity is not empty");
                }
            }
            if (catagoryID.isEmpty()) {
                check = false;
                error.setCatagoryIDError("CatagoryID is not empty !");
            }

            if (check == true) {
                ProductDAO dao = new ProductDAO();
                boolean checkDuplicate = dao.Duplicate(otoID);
                if (checkDuplicate) {
                    error.setOtoIDError("Duplicate OtoID!!");
                    request.setAttribute("ERROR", error);
                } else {
                    ProductDTO product = new ProductDTO(otoID, otoName, image, Float.parseFloat(price), Integer.parseInt(quantity), catagoryID);
                    pdao.insert(product);
                    url = SUCCESS;
                     request.setAttribute("ERROR", "INSERT THANH CONG!!!!!");
                }
            } else {
                request.setAttribute("ERROR", error);
            }
        } catch (Exception e) {
            log("Error at InsertController: " + e.toString());
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
