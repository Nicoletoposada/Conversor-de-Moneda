/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.conversor.de.moneda;

public class ApiResponse {
    private String result;
    private String base_code;
    private Rates rates;

    public String getBase() {
        return base_code;
    }

    public Rates getRates() {
        return rates;
    }
}