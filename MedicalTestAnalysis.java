import java.util.*;

public class MedicalTestAnalysis {
    public static void main(String[] args) {

        List<Double> testResults = Arrays.asList(75.0, 120.0, 90.0, 110.0, 80.0, 130.0, 100.0);

        double normalRangeUpperBound = 100.0;
        double highRangeUpperBound = 120.0;

        Map<String, Integer> resultCounts = new LinkedHashMap<>();
        Map<String, Double> totalValues = new LinkedHashMap<>();

        resultCounts.put("Normal", 0);
        totalValues.put("Normal", 0.0);
        resultCounts.put("Borderline", 0);
        totalValues.put("Borderline", 0.0);
        resultCounts.put("High", 0);
        totalValues.put("High", 0.0);

        for (Double result : testResults) {
            if (result <= normalRangeUpperBound) {
                resultCounts.put("Normal", resultCounts.get("Normal") + 1);
                totalValues.put("Normal", totalValues.get("Normal") + result);
            } else if (result <= highRangeUpperBound) {
                resultCounts.put("Borderline", resultCounts.get("Borderline") + 1);
                totalValues.put("Borderline", totalValues.get("Borderline") + result);
            } else {
                resultCounts.put("High", resultCounts.get("High") + 1);
                totalValues.put("High", totalValues.get("High") + result);
            }
        }

        System.out.println("Medical Test Analysis:");
        for (Map.Entry<String, Integer> entry : resultCounts.entrySet()) {
            String range = entry.getKey();
            int count = entry.getValue();
            double averageValue = totalValues.get(range) / count;
            System.out.println(range + ":");
            System.out.println("Number of patients: " + count);
            System.out.println("Average value: " + averageValue);
            System.out.println();
        }
    }
}
