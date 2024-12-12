/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.conversor.de.moneda;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ConversorDeMoneda {
    public static void main(String[] args) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            URI uri = new URI("https://api.tasasdecambio.com/latest?base=USD&symbols=EUR,GBP");

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .header("Accept", "application/json")
                    .header("Authorization", "Bearer your_token_here")
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            int statusCode = response.statusCode();

            if (statusCode == 200) {
                String responseBody = response.body();
                Gson gson = new Gson();
                JsonObject json = gson.fromJson(responseBody, JsonObject.class);
                System.out.println(json.toString());
            } else {
                System.out.println("Error: " + statusCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
