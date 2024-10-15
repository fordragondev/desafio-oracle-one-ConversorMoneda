import java.time.LocalDateTime;
import java.util.LinkedList;

public class ConverterHistory {

    private final LinkedList<Record> history = new LinkedList<>();

    // Add a new record to the history
    public void addConversionRecord(String fromCurrency, String toCurrency, double amount, double convertedAmount, double rate, LocalDateTime timestamp) {

        Record record = new Record(fromCurrency, toCurrency, amount, convertedAmount, rate, timestamp);
        if (history.size() == 5) {
            history.removeFirst();
        }
        history.add(record);
    }

    // Retrieve all the conversion history
    public LinkedList<Record> getConversionHistory() {
        return history;
    }

    // Display the conversion history
    public void showHistory() {
        System.out.println("=== Historial de Conversiones ===");
        if (history.isEmpty()) {
            System.out.println("No hay registros disponibles.");
        } else {
            for (Record record : history) {
                System.out.println("De: " + record.fromCurrency() +
                        ", a: " + record.toCurrency() +
                        ", Cantidad: " + record.amount() +
                        ", Resultado: " + record.convertedAmount() +
                        ", Tasa: " + record.rate() +
                        ", Timestamp: " + record.timestamp());
            }
        }
    }
}
