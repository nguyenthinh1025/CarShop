/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

/**
 *
 * @author Phu Thinh
 */
public class OrderDetailDTO {

    private String orderDetailID;
    private float price;
    private int quantity;
    private String orderID;
    private String otoID;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(String orderDetailID, float price, int quantity, String orderID, String otoID) {
        this.orderDetailID = orderDetailID;
        this.price = price;
        this.quantity = quantity;
        this.orderID = orderID;
        this.otoID = otoID;
    }

    public String getOrderDetailID() {
        return orderDetailID;
    }

    public void setOrderDetailID(String orderDetailID) {
        this.orderDetailID = orderDetailID;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getOtoID() {
        return otoID;
    }

    public void setOtoID(String otoID) {
        this.otoID = otoID;
    }

}
