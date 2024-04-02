import java.util.*;

public class HousingPriceAnalysis {
    public static void main(String[] args) {

        Map<Double, Integer> housingPrices = new HashMap<>();
        housingPrices.put(150000.0, 1200); // Price: $150,000, Square footage: 1200
        housingPrices.put(220000.0, 1500); // Price: $220,000, Square footage: 1500
        housingPrices.put(180000.0, 1300); // Price: $180,000, Square footage: 1300
        housingPrices.put(250000.0, 1800); // Price: $250,000, Square footage: 1800
        housingPrices.put(300000.0, 2000); // Price: $300,000, Square footage: 2000
        housingPrices.put(190000.0, 1400); // Price: $190,000, Square footage: 1400
        housingPrices.put(350000.0, 2200); // Price: $350,000, Square footage: 2200
        housingPrices.put(280000.0, 1700); // Price: $280,000, Square footage: 1700
        housingPrices.put(200000.0, 1600); // Price: $200,000, Square footage: 1600
        housingPrices.put(400000.0, 2500); // Price: $400,000, Square footage: 2500

        int range100kTo200kCount = 0;
        int range200kTo300kCount = 0;
        int range300kTo400kCount = 0;
        int range400kTo500kCount = 0;
        double range100kTo200kTotalSqFt = 0.0;
        double range200kTo300kTotalSqFt = 0.0;
        double range300kTo400kTotalSqFt = 0.0;
        double range400kTo500kTotalSqFt = 0.0;

        for (Map.Entry<Double, Integer> entry : housingPrices.entrySet()) {
            double price = entry.getKey();
            int squareFootage = entry.getValue();

            if (price >= 100000.0 && price < 200000.0) {
                range100kTo200kCount++;
                range100kTo200kTotalSqFt += squareFootage;
            } else if (price >= 200000.0 && price < 300000.0) {
                range200kTo300kCount++;
                range200kTo300kTotalSqFt += squareFootage;
            } else if (price >= 300000.0 && price < 400000.0) {
                range300kTo400kCount++;
                range300kTo400kTotalSqFt += squareFootage;
            } else if (price >= 400000.0 && price < 500000.0) {
                range400kTo500kCount++;
                range400kTo500kTotalSqFt += squareFootage;
            }
        }

        System.out.println("Housing Price Analysis:");
        System.out.println("$100,000 - $200,000:");
        System.out.println("Number of houses sold: " + range100kTo200kCount);
        System.out.println("Average square footage: " + (range100kTo200kTotalSqFt / range100kTo200kCount));
        System.out.println();
        System.out.println("$200,000 - $300,000:");
        System.out.println("Number of houses sold: " + range200kTo300kCount);
        System.out.println("Average square footage: " + (range200kTo300kTotalSqFt / range200kTo300kCount));
        System.out.println();
        System.out.println("$300,000 - $400,000:");
        System.out.println("Number of houses sold: " + range300kTo400kCount);
        System.out.println("Average square footage: " + (range300kTo400kTotalSqFt / range300kTo400kCount));
        System.out.println();
        System.out.println("$400,000 - $500,000:");
        System.out.println("Number of houses sold: " + range400kTo500kCount);
        System.out.println("Average square footage: " + (range400kTo500kTotalSqFt / range400kTo500kCount));
    }
}
