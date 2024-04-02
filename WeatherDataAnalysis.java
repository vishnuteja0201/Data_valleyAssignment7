import java.util.*;

public class WeatherDataAnalysis {
    public static void main(String[] args) {

        List<Double> temperatures = Arrays.asList(5.0, 15.0, -3.0, 8.0, 18.0, 22.0, -2.0);
        List<Integer> humidities = Arrays.asList(65, 70, 80, 60, 75, 85, 90);

        double[] temperatureRanges = { -10, 0, 10, 20, 30 };

        Map<String, Integer> temperatureCounts = new LinkedHashMap<>();
        Map<String, Integer> totalHumidity = new LinkedHashMap<>();

        for (int i = 0; i < temperatureRanges.length - 1; i++) {
            String rangeKey = formatRange(temperatureRanges[i], temperatureRanges[i + 1]);
            temperatureCounts.put(rangeKey, 0);
            totalHumidity.put(rangeKey, 0);
        }

        for (int i = 0; i < temperatures.size(); i++) {
            double temperature = temperatures.get(i);
            int humidity = humidities.get(i);
            for (int j = 0; j < temperatureRanges.length - 1; j++) {
                if (temperature >= temperatureRanges[j] && temperature < temperatureRanges[j + 1]) {
                    String rangeKey = formatRange(temperatureRanges[j], temperatureRanges[j + 1]);
                    int count = temperatureCounts.get(rangeKey) + 1;
                    int total = totalHumidity.get(rangeKey) + humidity;
                    temperatureCounts.put(rangeKey, count);
                    totalHumidity.put(rangeKey, total);
                    break;
                }
            }
        }

        System.out.println("Weather Data Analysis:");
        for (Map.Entry<String, Integer> entry : temperatureCounts.entrySet()) {
            String rangeKey = entry.getKey();
            int count = entry.getValue();
            int avgHumidity = totalHumidity.get(rangeKey) / count;
            System.out.println("Temperature range " + rangeKey + ":");
            System.out.println("Number of days: " + count);
            System.out.println("Average humidity: " + avgHumidity + "%");
            System.out.println();
        }
    }

    private static String formatRange(double lowerBound, double upperBound) {
        return String.format("%.1f-%.1f°C", lowerBound, upperBound);
    }
}
