/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package product;

import jakarta.annotation.Resource;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.UserTransaction;
import java.util.List;

/**
 *
 * @author Logan
 */
public class ProductService {
    private EntityManager em;
    
    public ProductService(EntityManager em) {
        this.em = em;
    };
    
    public List<Product> getAll() {
        Query query = em.createQuery("SELECT p FROM Product p", Product.class);
        List<Product> products = query.getResultList();
        return products;
    }
    
    public Product getProduct(Long id) {
        Product product = em.find(Product.class, id);
        return product;
    }
}
