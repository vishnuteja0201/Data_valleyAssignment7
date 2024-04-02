import java.util.*;

public class ProductSalesAnalysis {
    public static void main(String[] args) {

        List<Double> productSales = Arrays.asList(45.0, 80.0, 120.0, 55.0, 180.0, 30.0, 90.0);

        double[] priceRanges = { 0, 50, 100, 200, 500 };

        Map<String, Double> salesSummary = new LinkedHashMap<>();
        for (int i = 0; i < priceRanges.length - 1; i++) {
            String priceRangeKey = "$" + priceRanges[i] + "-" + priceRanges[i + 1];
            salesSummary.put(priceRangeKey, 0.0);
        }

        for (Double sale : productSales) {
            for (int i = 0; i < priceRanges.length - 1; i++) {
                if (sale >= priceRanges[i] && sale < priceRanges[i + 1]) {
                    String priceRangeKey = "$" + priceRanges[i] + "-" + priceRanges[i + 1];
                    double totalRevenue = salesSummary.get(priceRangeKey) + sale;
                    salesSummary.put(priceRangeKey, totalRevenue);
                    break;
                }
            }
        }

        System.out.println("Sales Summary:");
        for (Map.Entry<String, Double> entry : salesSummary.entrySet()) {
            System.out.println(entry.getKey() + ":");
            System.out
                    .println("Number of products sold: " + getProductCount(productSales, priceRanges, entry.getKey()));
            System.out.println("Total revenue: $" + entry.getValue());
            System.out.println();
        }
    }

    private static int getProductCount(List<Double> productSales, double[] priceRanges, String rangeKey) {
        int count = 0;
        String[] rangeBounds = rangeKey.substring(1).split("-");
        double lowerBound = Double.parseDouble(rangeBounds[0]);
        double upperBound = Double.parseDouble(rangeBounds[1]);
        for (Double sale : productSales) {
            if (sale >= lowerBound && sale < upperBound) {
                count++;
            }
        }
        return count;
    }
}
