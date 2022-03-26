package formerror;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Logan
 */
public class FormErrorBean<T> {
    private T object;
    private String message;
    
    public FormErrorBean() {}
    
    public FormErrorBean(String message, T object) {
        this.object = object;
        this.message = message;
    }
    
    public String getMessage() {
        return this.message;
    }
    
    public T getObject() {
        return this.object;
    }
}
