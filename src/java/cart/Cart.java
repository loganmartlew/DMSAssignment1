/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cart;

import jakarta.persistence.EntityManager;
import java.util.HashMap;

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
    
    public void checkout() {
        this.items = new HashMap();
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
}
