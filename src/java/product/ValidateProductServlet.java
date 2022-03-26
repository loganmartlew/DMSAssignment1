package product;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import product.ProductDTO;
import FormError.FormErrorBean;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 *
 * @author Logan
 */
@WebServlet(urlPatterns = {"/ValidateProductServlet"})
public class ValidateProductServlet extends HttpServlet {

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
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String qtyString = request.getParameter("quantity");
        String priceString = request.getParameter("price");
        
        ProductDTO productDto = new ProductDTO(name, description, qtyString, priceString);
        
        try {
            if (name == "") {
                throw new Exception("Name must be provided");
            }
            
            if (description == "") {
                throw new Exception("Description must be provided");
            }
            
            int quantity = this.convertQuantity(qtyString);
            int price = this.convertPrice(priceString);
            
            // Send to ProductServlet
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>PetServlet Response</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>New Product</h1>");
            out.println("<p>Name: " + name + "</p>");
            out.println("<p>Description: " + description + "</p>");
            out.println("<p>Quantity: " + quantity + "</p>");
            out.println("<p>Price: " + price + "</p>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception ex) {
            FormErrorBean<ProductDTO> err = new FormErrorBean<ProductDTO>(ex.getMessage(), productDto);
            // Send back to form
            request.setAttribute("error", err);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/newproduct.jsp");
            dispatcher.forward(request, response);
        }
    }
    
    private int convertQuantity(String qtyString) throws Exception {
        int quantity;

        try {
            quantity = Integer.parseInt(qtyString);
        } catch (NumberFormatException ex) {
            throw new Exception("Quantity was not a number");
        }

        if (quantity < 1) {
            throw new Exception("Quantity was less than 1. Quantity must be at least 1");
        }

        if (quantity > 1000) {
            throw new Exception("Quantity was more than 1000. Quantity must be at less than 1000");
        }

        return quantity;
    }
    
    private int convertPrice(String priceString) throws Exception {
        // Price in dollars
        float price;
        
        try {
            price = Float.parseFloat(priceString);
        } catch (NumberFormatException ex) {
            throw new Exception("Price was not a number");
        }
        
        if (price < 0) {
            throw new Exception("Price was less than 0. Price cannot be less than 0");
        }
        
        if (price > 1000) {
            throw new Exception("Price was more than 1000. Price cannot be more than 1000");
        }
        
        // Price in cents
        int priceCents = (int) (price * 100);
        
        return priceCents;
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
