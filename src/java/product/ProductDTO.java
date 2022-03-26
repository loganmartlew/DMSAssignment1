package product;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Logan
 */
public class ProductDTO {
    private String name = "";
    private String description = "";
    private String qtyString = "";
    private String priceString = "";
    
    public ProductDTO(String name, String description, String qtyString, String priceString) {
        this.name = name;
        this.description = description;
        this.qtyString = qtyString;
        this.priceString = priceString;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getQtyString() {
        return qtyString;
    }

    public String getPriceString() {
        return priceString;
    }
}
