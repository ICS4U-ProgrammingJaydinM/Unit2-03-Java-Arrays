import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class, named 'Arrays', calculates the mean and median of a set of integers read from several
 * files. It also provides an example of how to read data from files, process it, and present the
 * results.
 *
 * @author Jaydin Madore
 * @version 1.0
 * @since 2024-04-01
 */
public final class Arrays {

  private static int[] numAry;

  private Arrays() {
    throw new UnsupportedOperationException("Cannot instantiate");
  }

  public static void main(String[] args) {
    // List of file paths to read from.
    String[] readFilePaths = {"set1.txt", "set2.txt", "set3.txt"};

    // Loop through the array of file paths.
    for (String readPath : readFilePaths) {
      File readFile = new File(readPath);
      List<String> listOfNumbersStr = new ArrayList<>();

      // Read the file and handle exceptions.
      try {
        Scanner sc = new Scanner(readFile);
        while (sc.hasNextLine()) {
          String numStr = sc.next();
          listOfNumbersStr.add(numStr);
        }
      } catch (Exception e) {
        System.out.println("Invalid file path!");
        continue;
      }

      // Store the integers from the list of strings.
      numAry = new int[listOfNumbersStr.size()];
      for (int i = 0; i < listOfNumbersStr.size(); i++) {
        numAry[i] = Integer.parseInt(listOfNumbersStr.get(i));
      }

      // Calls the mean and median functions.
      double mean = CalcMean();
      double median = CalcMedian();

      // Print the results
      System.out.printf("%s:%nMean: %.2f%nMedian: %.2f%n%n", readPath, mean, median);
    }
  }

  // Calculates the mean of the integers in the 'numAry' array.
  // @return the mean to the the main.
  private static double CalcMean() {
    long sum = 0;
    for (int num : numAry) {
      sum += num;
    }
    return sum / (double) numAry.length;
  }

  // Calculates the median of the integers in the 'numAry' array.
  // return the median to main.
  // Calculates the median of the integers in the 'numAry' array.
  // Returns the median to main.
  private static double CalcMedian() {
    // Check if the array contains only one element
    if (numAry.length == 1) {
      return numAry[0];
    }

    // Sort the array in ascending order
    java.util.Arrays.sort(numAry);

    // Check if the length of the array is even.
    int midIndex = numAry.length / 2;
    if (numAry.length % 2 == 0) {
      int num1 = numAry[midIndex - 1];
      int num2 = numAry[midIndex];
      Double median = (num1 + num2) / 2.0;
      // It will return the average of the two middle elements.
      return median;
    } else {
      // It will return the middle element.
      return numAry[midIndex];
    }
  }
}
