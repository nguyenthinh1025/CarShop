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
public class ProductDTO {

    private String otoID;
    private String otoName;
    private String image;
    private float price;
    private int quantity;
    private String catagoryID;

    public ProductDTO() {
    }

    public ProductDTO(String otoID, String otoName, String image, float price, int quantity, String catagoryID) {
        this.otoID = otoID;
        this.otoName = otoName;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
        this.catagoryID = catagoryID;
    }

    public String getOtoID() {
        return otoID;
    }

    public void setOtoID(String OtoID) {
        this.otoID = OtoID;
    }

    public String getOtoName() {
        return otoName;
    }

    public void setOtoName(String OtoName) {
        this.otoName = OtoName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public String getCatagoryID() {
        return catagoryID;
    }

    public void setCatagoryID(String catagoryID) {
        this.catagoryID = catagoryID;
    }

    @Override
    public String toString() {
        return "ProductDTO{" + "otoID=" + otoID + ", otoName=" + otoName + ", image=" + image + ", price=" + price + ", quantity=" + quantity + ", catagoryID=" + catagoryID + '}';
    }
}
