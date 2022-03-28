/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cart;

import jakarta.persistence.EntityManager;
import product.Product;
import product.ProductService;

/**
 *
 * @author Logan
 */
public class CartItem {
    private Product product;
    private int quantity = 1;
    
    public CartItem(Long id, EntityManager em) {
        this.product = new ProductService(em).getProduct(id);
    };
    
    public Product getProduct() {
        return this.product;
    }
    
    public int getQuantity() {
        return this.quantity;
    }
    
    public void addQuantity() {
        this.quantity += 1;
    }
    
    public void subtractQuantity() {
        if (this.quantity == 1) return;
        this.quantity -= 1;
    }
}
