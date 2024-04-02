import java.util.*;

public class EmployeeWorkHoursAnalysis {
    public static void main(String[] args) {

        Map<String, List<Integer>> employeeWorkHours = new HashMap<>();
        employeeWorkHours.put("John", Arrays.asList(35, 42, 39, 40, 38)); // John worked 2 days more than 40 hours
        employeeWorkHours.put("Emily", Arrays.asList(40, 40, 40, 40, 40)); // Emily worked exactly 40 hours every day
        employeeWorkHours.put("Michael", Arrays.asList(38, 36, 37, 38, 39)); // Michael worked less than 40 hours every
                                                                             // day

        int moreThan40Count = 0;
        int exactly40Count = 0;
        int lessThan40Count = 0;
        double moreThan40TotalHours = 0.0;
        double exactly40TotalHours = 0.0;
        double lessThan40TotalHours = 0.0;

        for (Map.Entry<String, List<Integer>> entry : employeeWorkHours.entrySet()) {
            String employee = entry.getKey();
            List<Integer> hours = entry.getValue();
            double totalHours = hours.stream().mapToInt(Integer::intValue).sum();
            double averageHoursPerDay = totalHours / hours.size();

            if (totalHours > 40 * hours.size()) {
                moreThan40Count++;
                moreThan40TotalHours += totalHours;
            } else if (totalHours == 40 * hours.size()) {
                exactly40Count++;
                exactly40TotalHours += totalHours;
            } else {
                lessThan40Count++;
                lessThan40TotalHours += totalHours;
            }

            System.out.println(employee + ":");
            System.out.println("Total hours worked: " + totalHours);
            System.out.println("Average hours per day: " + averageHoursPerDay);
            System.out.println();
        }

        System.out.println("Employee Work Hours Analysis:");
        System.out.println("More than 40 hours:");
        System.out.println("Number of employees: " + moreThan40Count);
        System.out.println("Average hours per day: " + moreThan40TotalHours / moreThan40Count);
        System.out.println();
        System.out.println("Exactly 40 hours:");
        System.out.println("Number of employees: " + exactly40Count);
        System.out.println("Average hours per day: " + exactly40TotalHours / exactly40Count);
        System.out.println();
        System.out.println("Less than 40 hours:");
        System.out.println("Number of employees: " + lessThan40Count);
        System.out.println("Average hours per day: " + lessThan40TotalHours / lessThan40Count);
    }
}
