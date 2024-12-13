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
            URI uri = new URI("https://v6.exchangerate-api.com/v6/6f7ea3ba3e2518c15787e93c/latest/USD");

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .header("Accept", "application/json")
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            int statusCode = response.statusCode();
            System.out.println("Código de estado: " + statusCode);

            if (statusCode == 200) {
                String responseBody = response.body();
                
                // Imprimir respuesta JSON completa para verificar estructura
                System.out.println("JSON de respuesta: " + responseBody);

                HttpHeaders headers = response.headers();
                headers.map().forEach((key, values) -> {
                    System.out.println(key + ": " + values);
                });

                Gson gson = new Gson();
                ApiResponse apiResponse = gson.fromJson(responseBody, ApiResponse.class);

                System.out.println("Base: " + apiResponse.getBase());

                if (apiResponse.getRates() != null) {
                    System.out.println("ARS Rate: " + apiResponse.getRates().getARS());
                    System.out.println("BOB Rate: " + apiResponse.getRates().getBOB());
                    System.out.println("BRL Rate: " + apiResponse.getRates().getBRL());
                    System.out.println("CLP Rate: " + apiResponse.getRates().getCLP());
                    System.out.println("COP Rate: " + apiResponse.getRates().getCOP());
                    System.out.println("USD Rate: " + apiResponse.getRates().getUSD());
                } else {
                    System.out.println("Error: No se pudieron obtener las tasas de cambio.");
                }
            } else {
                System.out.println("Error: " + statusCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
