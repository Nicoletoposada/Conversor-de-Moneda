/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.conversor.de.moneda;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpHeaders;
import java.net.URI;
import com.google.gson.Gson;

public class ConversorDeMoneda {
    public static void main(String[] args) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            URI uri = new URI("https://api.tasasdecambio.com/latest?base=USD&symbols=ARS,BOB,BRL,CLP,COP,USD");

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .header("Accept", "application/json")
                    .header("Authorization", "Bearer 6f7ea3ba3e2518c15787e93c")
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            int statusCode = response.statusCode();
            System.out.println("Código de estado: " + statusCode);

            if (statusCode == 200) {
                String responseBody = response.body();
                
                HttpHeaders headers = response.headers();
                headers.map().forEach((key, values) -> {
                    System.out.println(key + ": " + values);
                });

                Gson gson = new Gson();
                ApiResponse apiResponse = gson.fromJson(responseBody, ApiResponse.class);

                System.out.println("Base: " + apiResponse.getBase());
                System.out.println("ARS Rate: " + apiResponse.getRates().getARS());
                System.out.println("BOB Rate: " + apiResponse.getRates().getBOB());
                System.out.println("BRL Rate: " + apiResponse.getRates().getBRL());
                System.out.println("CLP Rate: " + apiResponse.getRates().getCLP());
                System.out.println("COP Rate: " + apiResponse.getRates().getCOP());
                System.out.println("USD Rate: " + apiResponse.getRates().getUSD());
            } else {
                System.out.println("Error: " + statusCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ApiResponse {
    private String base;
    private Rates rates;

    public String getBase() {
        return base;
    }

    public Rates getRates() {
        return rates;
    }
}

class Rates {
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
}
