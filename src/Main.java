import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ConsultaApi consultaLastest = new ConsultaApi();
        ConsultaApi consultaPair = new ConsultaApi();

        String fromCurrency = "COP";
        String toCurrency = "USD";
        double amount = 0.0;
        double result = 0.0;

        Scanner reader = new Scanner(System.in);
        ConverterHistory converterHistory = new ConverterHistory();

        System.out.println("=== Conversor de Monedas ===");
        try {
            consultaLastest.currencyApilatest();

        } catch (RuntimeException e) {
            System.out.println("Error al llamar el API: " + e.getMessage());
        }

        while (true) {
            try {
                System.out.println("\n" + "Escriba el código de la moneda origen (Ej: USD, COP, ARS, BRL, PEN): ");
                fromCurrency = reader.nextLine().toUpperCase();

                System.out.println("Escriba la cantidad que desea convertir: ");
                amount = Double.parseDouble(reader.nextLine());
                //amount = Integer.valueOf(lectura.nextLine());

                System.out.println("Escriba el código de la moneda destino (Ej: USD, COP, ARS, BRL, PEN): ");
                toCurrency = reader.nextLine().toUpperCase();

                // Validation
                if (fromCurrency.isEmpty() || toCurrency.isEmpty() || amount <= 0) {
                    throw new IllegalArgumentException("Por favor, ingrese valores válidos.");
                }

                try {
                    double conversionRate = consultaPair.currencyApiPair(fromCurrency, toCurrency);
                    result = amount * conversionRate;
                    System.out.println("Resultado de la conversión: " + result + "\n");

                    // Imprime el historial de conversiones
                    converterHistory.addConversionRecord(fromCurrency, toCurrency, amount, result, conversionRate, LocalDateTime.now());
                    converterHistory.showHistory();

                } catch (NumberFormatException e) {
                    System.out.println("Número no encontrado " + e.getMessage());
                } catch (RuntimeException e) {
                    System.out.println("Finalizando la aplicación, error: " + e.getMessage());
                }

            } catch (NumberFormatException e) {
                System.out.println("Cantidad inválida. Por favor, ingrese un número válido para la cantidad.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
