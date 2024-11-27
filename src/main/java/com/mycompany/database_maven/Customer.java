/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.database_maven;

/**
 *
 * @author jayia
 */
public class Customer {
    private String name;
    private double totalBill;
    
    public Customer(String name, int amount){
        this.name = name;
        this.totalBill = amount;
    }
    
     public void updateTotal(double amount){
        this.totalBill += amount;
    }
}
