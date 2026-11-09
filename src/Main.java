import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Create an array with 100 random integers from 1 to 100
        int[] dataPoints = new int[100];
        Random rnd = new Random();

        for (int i = 0; i < dataPoints.length; i++) {
            dataPoints[i] = rnd.nextInt(100) + 1;
        }

        // Print the array values on one line
        for (int i = 0; i < dataPoints.length; i++) {
            if (i > 0) {
                System.out.print(" | ");
            }
            System.out.print(dataPoints[i]);
        }
        System.out.println();

        // Calculate and display the sum and average
        int sum = 0;
        for (int value : dataPoints) {
            sum += value;
        }

        double average = (double) sum / dataPoints.length;
        System.out.println("The sum of the random array is: " + sum);
        System.out.println("The average of the random array is: " + average);

        // Ask for a number to count
        int searchValue = getRangedInt(
                in, "Enter a number to count in the array", 1, 100);

        // Count how many times the number appears
        int count = 0;
        for (int value : dataPoints) {
            if (value == searchValue) {
                count++;
            }
        }

        System.out.println("The value " + searchValue
                + " appears " + count + " time(s) in the array.");

        // Ask for a number and find its first index
        int findValue = getRangedInt(
                in, "Enter a number to find its first position", 1, 100);

        int foundIndex = -1;
        for (int i = 0; i < dataPoints.length; i++) {
            if (dataPoints[i] == findValue) {
                foundIndex = i;
                break;
            }
        }

        if (foundIndex >= 0) {
            System.out.println("The value " + findValue
                    + " was found at array index " + foundIndex + ".");
        } else {
            System.out.println("The value " + findValue
                    + " was not found in the array.");
        }

        // Find and display the minimum and maximum
        int min = dataPoints[0];
        int max = dataPoints[0];

        for (int i = 1; i < dataPoints.length; i++) {
            if (dataPoints[i] < min) {
                min = dataPoints[i];
            }
            if (dataPoints[i] > max) {
                max = dataPoints[i];
            }
        }

        System.out.println("The minimum value is: " + min);
        System.out.println("The maximum value is: " + max);

        // Test the average method with a double array
        double[] sampleValues = {10.0, 20.0, 30.0};
        System.out.println("The average of the sample double array is: "
                + getAverage(sampleValues));

        // Also calculate the average of the integer array
        System.out.println("The average of dataPoints is: "
                + getAverage(dataPoints));

        in.close();
    }

    // Reads an integer within the given range
    public static int getRangedInt(
            Scanner in, String prompt, int min, int max) {

        while (true) {
            System.out.print(prompt + " (" + min + "-" + max + "): ");

            if (in.hasNextInt()) {
                int value = in.nextInt();

                if (value >= min && value <= max) {
                    return value;
                }

                System.out.println("Please enter a number from "
                        + min + " to " + max + ".");
            } else {
                System.out.println("Please enter a whole number.");
                in.next(); // Discard invalid input
            }
        }
    }

    // Returns the average of a double array
    public static double getAverage(double[] values) {
        if (values.length == 0) {
            return 0.0;
        }

        double sum = 0.0;
        for (double value : values) {
            sum += value;
        }

        return sum / values.length;
    }

    // Returns the average of an integer array
    public static double getAverage(int[] values) {
        if (values.length == 0) {
            return 0.0;
        }

        int sum = 0;
        for (int value : values) {
            sum += value;
        }

        return (double) sum / values.length;
    }
}