import java.util.Scanner;
public class TemperatureConverter {
    
    public static double convertTemperature(double value, String from, String to) {
        from = from.toLowerCase();
        to = to.toLowerCase();
        
        if (from.equals(to)) {
            return value; 
        }
        
        switch (from) {
            case "celsius":
                if (to.equals("fahrenheit")) {
                    return (value * 9/5) + 32;
                } else if (to.equals("kelvin")) {
                    return value + 273.15;
                }
                break;
            
            case "fahrenheit":
                if (to.equals("celsius")) {
                    return (value - 32) * 5/9;
                } else if (to.equals("kelvin")) {
                    return (value - 32) * 5/9 + 273.15;
                }
                break;
            
            case "kelvin":
                if (to.equals("celsius")) {
                    return value - 273.15;
                } else if (to.equals("fahrenheit")) {
                    return (value - 273.15) * 9/5 + 32;
                }
                break;
        }
        
        return Double.NaN;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter temperature value: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input! Please enter a valid number.");
            scanner.next();
        }
        double value = scanner.nextDouble();
        
        System.out.print("Enter source scale (Celsius, Fahrenheit, Kelvin): ");
        String from = scanner.next();
        
        System.out.print("Enter target scale (Celsius, Fahrenheit, Kelvin): ");
        String to = scanner.next();
        
        double convertedTemp = convertTemperature(value, from, to);
        
        if (Double.isNaN(convertedTemp)) {
            System.out.println("Invalid temperature scales entered!");
        } else {
            System.out.printf("Converted Temperature: %.2f %s\n", convertedTemp, to);
        }
        
        scanner.close();
    }
}
