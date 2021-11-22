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
public class ProductError {

    private String OtoIDError;
    private String OtoNameError;
    private String imageError;
    private String priceError;
    private String quantityError;
    private String catagoryIDError;

    public ProductError() {
    }

    public ProductError(String OtoIDError, String OtoNameError, String imageError, String priceError, String quantityError, String catagoryIDError) {
        this.OtoIDError = OtoIDError;
        this.OtoNameError = OtoNameError;
        this.imageError = imageError;
        this.priceError = priceError;
        this.quantityError = quantityError;
    }

    public String getOtoIDError() {
        return OtoIDError;
    }

    public void setOtoIDError(String OtoIDError) {
        this.OtoIDError = OtoIDError;
    }

    public String getOtoNameError() {
        return OtoNameError;
    }

    public void setOtoNameError(String OtoNameError) {
        this.OtoNameError = OtoNameError;
    }

    public String getImageError() {
        return imageError;
    }

    public void setImageError(String imageError) {
        this.imageError = imageError;
    }

    public String getPriceError() {
        return priceError;
    }

    public void setPriceError(String priceError) {
        this.priceError = priceError;
    }

    public String getQuantityError() {
        return quantityError;
    }

    public void setQuantityError(String quantityError) {
        this.quantityError = quantityError;
    }

    public String getCatagoryIDError() {
        return catagoryIDError;
    }

    public void setCatagoryIDError(String catagoryIDError) {
        this.catagoryIDError = catagoryIDError;
    }

}
