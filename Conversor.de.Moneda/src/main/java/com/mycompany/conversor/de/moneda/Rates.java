/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.conversor.de.moneda;

public class Rates {
    private double ARS;
    private double BOB;
    private double BRL;
    private double CLP;
    private double COP;
    private double USD;

    public double getARS() {
        return ARS;
    }

    public double getBOB() {
        return BOB;
    }

    public double getBRL() {
        return BRL;
    }

    public double getCLP() {
        return CLP;
    }

    public double getCOP() {
        return COP;
    }

    public double getUSD() {
        return USD;
    }

    @Override
    public String toString() {
        return "Rates{" +
                "ARS=" + ARS +
                ", BOB=" + BOB +
                ", BRL=" + BRL +
                ", CLP=" + CLP +
                ", COP=" + COP +
                ", USD=" + USD +
                '}';
    }
}
