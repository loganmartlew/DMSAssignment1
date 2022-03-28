/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Users;

import formerror.FormErrorBean;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import product.ProductDTO;

/**
 * @author coen
 */
public class ValidateUserCreationServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        userAccount newUser = new userAccount();
        newUser.setUserName(userName);
        newUser.setPassword(password);
        
        try {
            if (userName == "") {
                throw new Exception("Name must be provided");
            }

            if (password == "") {
                throw new Exception("Password must be provided");
            }

            request.setAttribute("newUser", newUser);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/newUserAccount");
            dispatcher.forward(request, response);
            
        } catch (Exception ex) {
            FormErrorBean<userAccount> err = new FormErrorBean<>(ex.getMessage(), newUser);

            request.setAttribute("error", err);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/createUser.jsp");
            dispatcher.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
