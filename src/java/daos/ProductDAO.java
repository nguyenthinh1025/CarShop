/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import Utils.DBUtils;
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
public class ProductDAO {

    public List<ProductDTO> getListOto(String searchName, String searchCatagory) throws SQLException {
        List<ProductDTO> list = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT otoID,otoName,image,price,quantity,catagoryID\n"
                        + "FROM tblProducts\n"
                        + "WHERE OtoName like ? AND catagoryID like ? ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, "%" + searchName + "%");
                stm.setString(2, "%" + searchCatagory + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    String otoID = rs.getString("otoID").trim();
                    String otoName = rs.getString("otoName").trim();
                    String image = rs.getString("image");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    String catagoryID = rs.getString("catagoryID").trim();
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    list.add(new ProductDTO(otoID, otoName, image, price, quantity, catagoryID));
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

    public void insert(ProductDTO product) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO tblProducts(otoID,otoName,image,price,quantity,catagoryID)\n"
                        + "VALUES (?,?,?,?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, product.getOtoID());
                stm.setString(2, product.getOtoName());
                stm.setString(3, product.getImage());
                stm.setFloat(4, product.getPrice());
                stm.setInt(5, product.getQuantity());
                stm.setString(6, product.getCatagoryID());
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

    public boolean Duplicate(String id) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT otoID\n"
                        + "FROM tblProducts\n"
                        + "WHERE otoID = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, id);
                rs = stm.executeQuery();
                if (rs.next()) {
                    check = true;
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
        return check;
    }

    public void update(ProductDTO product) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "UPDATE tblProducts\n"
                        + "SET otoName=? ,price=? ,quantity=? ,catagoryID=?\n"
                        + "WHERE otoID = ? ";

                stm = conn.prepareStatement(sql);
                stm.setString(1, product.getOtoName());
                stm.setFloat(2, product.getPrice());
                stm.setInt(3, product.getQuantity());
                stm.setString(4, product.getCatagoryID());
                stm.setString(5, product.getOtoID());
                stm.executeQuery();
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

    public void delete(String otoID) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            String sql = "DELETE tblProducts\n"
                    + "WHERE otoID = ?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, otoID);
            stm.executeQuery();
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

    public boolean checkQuantity(String otoID, int quantity) throws SQLException {
        boolean result = false;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT otoName\n"
                        + "FROM tblProducts\n"
                        + "WHERE otoID = ? AND quantity >= ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, otoID);
                stm.setInt(2, quantity);
                rs = stm.executeQuery();
                if (rs.next()) {
                    result = true;
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
}
