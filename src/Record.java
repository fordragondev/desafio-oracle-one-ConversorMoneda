import java.time.LocalDateTime;

public record Record(String fromCurrency,
                     String toCurrency,
                     double amount,
                     double convertedAmount,
                     double rate,
                     LocalDateTime timestamp) {
}
