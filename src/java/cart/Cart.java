/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cart;

import jakarta.persistence.EntityManager;
import jakarta.transaction.HeuristicMixedException;
import jakarta.transaction.HeuristicRollbackException;
import jakarta.transaction.NotSupportedException;
import jakarta.transaction.RollbackException;
import jakarta.transaction.SystemException;
import jakarta.transaction.UserTransaction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import product.NewProductServlet;
import product.Product;

/**
 *
 * @author Logan
 */
public class Cart {
    private HashMap<Long, CartItem> items = new HashMap();
    private EntityManager em;
    
    public Cart(EntityManager em) {
        this.em = em;
    }
    
    public boolean hasItems() {
        return !items.isEmpty();
    }
    
    public HashMap<Long, CartItem> getItems() {
        return this.items;
    }
    
    public void addToCart(Long id) {
        if (items.containsKey(id)) {
            items.get(id).addQuantity();
        } else {
            CartItem newItem = new CartItem(id, this.em);
            items.put(id, newItem);
        }
    }
    
    public void removeFromCart(Long id) {
        items.remove(id);
    }
    
    public void checkout(UserTransaction utx) {
        for(Map.Entry<Long, CartItem> entry : items.entrySet()) {
            CartItem item = entry.getValue();
            int quantity = item.getQuantity();
            Product product = item.getProduct();
            
            try {
                utx.begin();
                product.setQuantity(product.getQuantity() - quantity);
                Product updatedProduct = em.merge(product);
                if (product.getQuantity() <= 0) {
                    em.remove(updatedProduct);
                }
                utx.commit();
            } catch (NotSupportedException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException | SystemException ex) {
                Logger.getLogger(NewProductServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        items.clear();
    }
    
    public void incrementItem(Long id) {
        if (items.containsKey(id)) {
            items.get(id).addQuantity();
        }
    }
    
    public void decrementItem(Long id) {
        if (items.containsKey(id)) {
            items.get(id).subtractQuantity();
        }
    }
    
    public String getFormattedCartPrice() {
        int totalCents = 0;
        
        for(Map.Entry<Long, CartItem> entry : items.entrySet()) {
            CartItem item = entry.getValue();
            totalCents += item.getProduct().getPrice() * item.getQuantity();
        }
        
        double totalDollars = totalCents/100;
        String output = String.format("$%.2f", totalDollars);
        return output;
    }
}
