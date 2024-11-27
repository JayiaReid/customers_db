/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.database_maven;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author jayia
 */
public class Database_maven {
   
   

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/sales";
        String username = "root";
        String password = "root";
        
        try(Connection connection = DriverManager.getConnection(jdbcUrl, username, password)){
           if(connection != null){
               System.out.println("Bills:");
               displayCustomers(connection);
           }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    
    private static void displayCustomers(Connection connection){
         Map< String, Integer> sales = new HashMap<>();
        String sql = "SELECT * FROM sales";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
//                int id = resultSet.getInt("CustomerID");
                String customerName = resultSet.getString("Customer");
                String product = resultSet.getString("Product");
                int price = resultSet.getInt("Price");
                
            if (!sales.containsKey(customerName)) {
                sales.put(customerName, price);
            }else{
                int oldPrice = sales.get(customerName);
                sales.put(customerName, oldPrice+price);
            }
                
            }
            
            for (String c : sales.keySet()) {
                System.out.println("========");
                System.out.println("Customer: " + c);
                System.out.println("Total: $" + sales.get(c));
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
