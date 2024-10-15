import java.util.Map;

public record Currency(String result,
                       String base_code,
                       String target_code,
                       double conversion_rate,
                       String time_last_update_utc,
                       Map<String, Double> conversion_rates) {
}