/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import Utils.DBUtils;
import dtos.OrderDTO;
import dtos.ProductDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Phu Thinh
 */
public class OrderDAO {

    public int getNoOfOrder() throws SQLException {
        int result = 0;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "select Count(orderID) as NoofOrder\n"
                        + " from tblOrders";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                if (rs.next()) {
                    result = rs.getInt("NoOfOrder");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }

    public void createOrder(OrderDTO order) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO tblOrders(orderID,orderDate,totalPrice,userID)\n"
                        + "values(?,?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, order.getOrderID());
                stm.setString(2, order.getOrderDate());
                stm.setFloat(3, order.getTotalPrice());
                stm.setString(4, order.getUserID());
                stm.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
    
    public List<OrderDTO> listOrder() throws SQLException{
        List<OrderDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT orderID,orderDate,totalPrice,userID\n"
                        + "FROM tblOrders\n"
                        + "WHERE userID = ?";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String orderID = rs.getString("orderID").trim();
                    String orderDate = rs.getString("orderDate");               
                    float totalPrice = rs.getFloat("totalPrice");               
                    String userID = rs.getString("userID").trim();               
                    list.add(new OrderDTO(orderID, orderDate, totalPrice, userID) );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }
}
