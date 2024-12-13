/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.conversor.de.moneda;

public class ApiResponse {
    private String result;
    private String base_code;
    private Rates conversion_rates;

    // Obtener la moneda base
    public String getBase() {
        return base_code;
    }

    // Obtener las tasas de conversión
    public Rates getRates() {
        return conversion_rates;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "result='" + result + '\'' +
                ", base_code='" + base_code + '\'' +
                ", rates=" + conversion_rates +
                '}';
    }
}
