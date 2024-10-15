import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;
//import java.io.StringReader;

public class ConsultaApi {
    String apiKEy = "xxx-xxx-xxx-xxx"; // Cambiar por el key

    public void currencyApilatest() {
        String apiUrl = "https://v6.exchangerate-api.com/v6/" + apiKEy + "/latest/USD";
        URI apiUri = URI.create(apiUrl);

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(apiUri)
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Parse the JSON response using Gson
            Gson gson = new Gson();
            Currency apiCurrencyResponse = gson.fromJson(response.body(), Currency.class);
            System.out.println("API latest Response: " + apiCurrencyResponse.result());

            if (apiCurrencyResponse.conversion_rates().get("USD") != null){
                Double usdRate = apiCurrencyResponse.conversion_rates().get("USD");
                Double arsRate = apiCurrencyResponse.conversion_rates().get("ARS");
                Double brlRate = apiCurrencyResponse.conversion_rates().get("BRL");
                Double copRate = apiCurrencyResponse.conversion_rates().get("COP");
                Double penRate = apiCurrencyResponse.conversion_rates().get("PEN");

                if (arsRate != null && brlRate != null && copRate != null && penRate != null) {
                    System.out.println("Tasas de cambio para " + apiCurrencyResponse.base_code() + " con fecha " + apiCurrencyResponse.time_last_update_utc() + " :");
                    System.out.println("-- USD: " + usdRate + ", ARS: " + arsRate + ", BRL: " + brlRate + ", COP: " + copRate + ", PEN: " + penRate);
                }
            }else {
                System.out.println("Las tasas para el USD no estan disponibles.");
            }
        } catch (IOException e) {
            System.out.println("Error de conexión: " + e.getMessage());
            throw new RuntimeException("Error al conectar con la API. Por favor, revisa la URL o tu conexión a internet.");
        } catch (InterruptedException e) {
            System.out.println("La operación fue interrumpida: " + e.getMessage());
            throw new RuntimeException("La llamada a la API fue interrumpida.");
        }
    }

    public double currencyApiPair(String fromCurrency, String toCurrency) {
        String apiUrl = "https://v6.exchangerate-api.com/v6/" + apiKEy + "/pair/" + fromCurrency + "/" + toCurrency;
        URI apiUri = URI.create(apiUrl);
        double conversionRate = 0.0;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(apiUri)
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Parse the JSON response using Gson
            Gson gson = new Gson();
            Currency apiCurrencyResponse = gson.fromJson(response.body(), Currency.class);
            System.out.println("API Pair Response: " + apiCurrencyResponse.result());

            conversionRate = apiCurrencyResponse.conversion_rate();

        } catch (IOException e) {
            System.out.println("Error de conexión: " + e.getMessage());
            throw new RuntimeException("Error al conectar con la API. Por favor, revisa la URL o tu conexión a internet.");
        } catch (InterruptedException e) {
            System.out.println("La operación fue interrumpida: " + e.getMessage());
            throw new RuntimeException("La llamada a la API fue interrumpida.");
        }
        return conversionRate;
    }
}