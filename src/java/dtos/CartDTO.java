/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Phu Thinh
 */
public class CartDTO {

    private Map<String, ProductDTO> cart;
    private float totalPrice;

    public CartDTO() {
    }

    public CartDTO(Map<String, ProductDTO> cart, float totalPrice) {

        this.cart = cart;
        this.totalPrice = totalPrice;
    }

    public Map<String, ProductDTO> getCart() {
        return cart;
    }

    public void setCart(Map<String, ProductDTO> cart) {
        this.cart = cart;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean add(ProductDTO oto) {
        boolean check = false;
        try {
            if (cart == null) {
                cart = new HashMap<>();

            }
            if (cart.containsKey(oto.getOtoID())) {
                int quantity = cart.get(oto.getOtoID()).getQuantity();
                oto.setQuantity(quantity + oto.getQuantity());
            }
            cart.put(oto.getOtoID(), oto);
            check = true;
        } catch (Exception e) {
        }
        return true;
    }

    public boolean delete(String id) {
        boolean check = false;
        try {
            if (cart != null) {
                if (cart.containsKey(id)) {
                    cart.remove(id);
                    check = true;
                }
            }
        } catch (Exception e) {
        }
        return check;
    }

    public boolean update(String id, ProductDTO tea) {
        boolean check = false;
        try {
            if (cart != null) {
                if (cart.containsKey(id)) {
                    this.cart.replace(id, tea);
                    check = true;
                }
            }
        } catch (Exception e) {
        }
        return check;
    }
}
