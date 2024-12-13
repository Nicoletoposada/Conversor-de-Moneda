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
import java.util.Scanner;

public class ConversorDeMoneda{

    //Método principal
    public static void main(String[] args){
        try{
            //Crear un cliente HttpClient
            HttpClient client = HttpClient.newHttpClient();
            URI uri = new URI("https://v6.exchangerate-api.com/v6/6f7ea3ba3e2518c15787e93c/latest/USD");//Con mi APIKEY

            //Crear una solicitud HttpRequest
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .header("Accept", "application/json")
                    .GET()
                    .build();

            //Enviar la solicitud y obtener la respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            int statusCode = response.statusCode();
            System.out.println("Código de estado: " + statusCode);

            if(statusCode == 200){
                String responseBody = response.body();
                
                //Imprimir respuesta JSON completa para verificar estructura
                System.out.println("JSON de respuesta: " + responseBody);

                //Imprimir encabezados de respuesta
                HttpHeaders headers = response.headers();
                headers.map().forEach((key, values) -> {
                    System.out.println(key + ": " + values);
                });

                //Convertir JSON de respuesta a un objeto ApiResponse
                Gson gson = new Gson();
                ApiResponse apiResponse = gson.fromJson(responseBody, ApiResponse.class);

                //Imprimir ApiResponse para verificar la estructura
                System.out.println("ApiResponse: " + apiResponse);

                //Verificar que las tasas de cambio no sean nulas
                if(apiResponse.getRates() != null){
                    // Imprimir las tasas de cambio
                    System.out.println("Base: " + apiResponse.getBase());
                    System.out.println("ARS Rate: " + apiResponse.getRates().getARS());
                    System.out.println("BOB Rate: " + apiResponse.getRates().getBOB());
                    System.out.println("BRL Rate: " + apiResponse.getRates().getBRL());
                    System.out.println("CLP Rate: " + apiResponse.getRates().getCLP());
                    System.out.println("COP Rate: " + apiResponse.getRates().getCOP());
                    System.out.println("USD Rate: " + apiResponse.getRates().getUSD());

                    //Menú de interacción con el usuario
                    Scanner scanner = new Scanner(System.in);
                    boolean exit = false;

                    while(!exit){
                        //Mostrar opciones de conversión
                        System.out.println("Seleccione la opción de conversión:");
                        System.out.println("1. USD a ARS");
                        System.out.println("2. USD a BOB");
                        System.out.println("3. USD a BRL");
                        System.out.println("4. USD a CLP");
                        System.out.println("5. USD a COP");
                        System.out.println("6. Salir");

                        //Obtener elección del usuario
                        int choice = scanner.nextInt();
                        switch(choice){
                            case 1:
                                //Convertir USD a ARS
                                System.out.print("Ingrese la cantidad en USD: ");
                                double amountInUSDToARS = scanner.nextDouble();
                                double amountInARS = convertCurrency(amountInUSDToARS, apiResponse.getRates().getUSD(), apiResponse.getRates().getARS());
                                System.out.println(amountInUSDToARS + " USD es equivalente a " + amountInARS + " ARS");
                                break;
                            case 2:
                                //Convertir USD a BOB
                                System.out.print("Ingrese la cantidad en USD: ");
                                double amountInUSDToBOB = scanner.nextDouble();
                                double amountInBOB = convertCurrency(amountInUSDToBOB, apiResponse.getRates().getUSD(), apiResponse.getRates().getBOB());
                                System.out.println(amountInUSDToBOB + " USD es equivalente a " + amountInBOB + " BOB");
                                break;
                            case 3:
                                //Convertir USD a BRL
                                System.out.print("Ingrese la cantidad en USD: ");
                                double amountInUSDToBRL = scanner.nextDouble();
                                double amountInBRL = convertCurrency(amountInUSDToBRL, apiResponse.getRates().getUSD(), apiResponse.getRates().getBRL());
                                System.out.println(amountInUSDToBRL + " USD es equivalente a " + amountInBRL + " BRL");
                                break;
                            case 4:
                                //Convertir USD a CLP
                                System.out.print("Ingrese la cantidad en USD: ");
                                double amountInUSDToCLP = scanner.nextDouble();
                                double amountInCLP = convertCurrency(amountInUSDToCLP, apiResponse.getRates().getUSD(), apiResponse.getRates().getCLP());
                                System.out.println(amountInUSDToCLP + " USD es equivalente a " + amountInCLP + " CLP");
                                break;
                            case 5:
                                //Convertir USD a COP
                                System.out.print("Ingrese la cantidad en USD: ");
                                double amountInUSDToCOP = scanner.nextDouble();
                                double amountInCOP = convertCurrency(amountInUSDToCOP, apiResponse.getRates().getUSD(), apiResponse.getRates().getCOP());
                                System.out.println(amountInUSDToCOP + " USD es equivalente a " + amountInCOP + " COP");
                                break;
                            case 6:
                                //Salir del menú
                                exit = true;
                                System.out.println("Saliendo...");
                                break;
                            default:
                                System.out.println("Opción no válida. Intente de nuevo.");
                        }
                    }
                }else{
                    System.out.println("Error: No se pudieron obtener las tasas de cambio.");
                }
            }else{
                System.out.println("Error: " + statusCode);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //Método para convertir monedas
    public static double convertCurrency(double amount, double rateFrom, double rateTo){
        return amount * (rateTo / rateFrom);
    }
}
