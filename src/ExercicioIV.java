import java.util.HashMap;
import java.util.Map;

public class ExercicioIV {
    public static void main(String[] args) {
        Map<String, Double> revenue = new HashMap<>();
        revenue.put("SP", 67836.43);
        revenue.put("RJ", 36678.66);
        revenue.put("MG", 29229.88);
        revenue.put("ES", 27165.48);
        revenue.put("Outros", 19849.53);

        double total = 0;
        for (double value : revenue.values()) {
            total += value;
        }

        for (Map.Entry<String, Double> entry : revenue.entrySet()) {
            String state = entry.getKey();
            double value = entry.getValue();
            double percentage = (value / total) * 100;
            System.out.printf("Percentual de %s: %.2f%%\n", state, percentage);
        }
    }
}