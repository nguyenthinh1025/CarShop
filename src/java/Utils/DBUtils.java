/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Phu Thinh
 */
public class DBUtils {

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Assignment_NguyenPhuThinh";
            conn = DriverManager.getConnection(url, "sa", "25102000");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
