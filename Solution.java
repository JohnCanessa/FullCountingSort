import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

/**
 * 
 */
public class Solution {

  /**
   * Complete the countSort function below.
   */
  static void countSort(List<List<String>> arr) {

    // **** instantiate array of string builders ****
    StringBuilder[] sb = new StringBuilder[100];
    for (int i = 0; i < 100; i++) {
      sb[i] = new StringBuilder();
    }

    // **** to speed up String to Integer conversion ****
    HashMap<String, Integer> hm = new HashMap<String, Integer>();
    for (int i = 0; i <= 99; i++) {
      String s = Integer.toString(i);
      hm.put(s, i);
    }

    // **** ****
    int index = 0;

    // **** set first half of the strings to "- " ****
    for (int i = 0; i < arr.size() / 2; i++) {
      index = hm.get(arr.get(i).get(0));
      sb[index].append("- ");
    }

    // **** append strings with same index to respective string builder ****
    for (int i = arr.size() / 2; i < arr.size(); i++) {
      index = hm.get(arr.get(i).get(0));
      sb[index].append(arr.get(i).get(1) + " ");
    }

    // **** build and output the result string ****
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < 100; i++) {
      result.append(sb[i].toString());
    }
    System.out.println(result.toString());
  }

  /**
   * Test scaffolding. UNACCEPTABLE having to replace the test scaffolding.
   */
  public static void main(String[] args) throws IOException {

    // **** open buffered reader ****
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    // **** get the number of elements ****
    int n = Integer.parseInt(bufferedReader.readLine().trim());

    // **** instantiate array of string builders ****
    StringBuilder[] sb = new StringBuilder[100];
    for (int i = 0; i < 100; i++) {
      sb[i] = new StringBuilder();
    }

    // **** set first half of the strings to "- " ****
    for (int i = 0; i < n / 2; i++) {

      // **** read the next line ****
      String s = bufferedReader.readLine();

      // **** ****
      String[] split = s.split(" ");

      // **** ****
      int index = Integer.parseInt(split[0]);

      // **** ****
      sb[index].append("- ");
    }

    // **** append strings with same index to respective string builder ****
    for (int i = n / 2; i < n; i++) {

      // **** read the next line ****
      String s = bufferedReader.readLine();

      // **** ****
      String[] split = s.split(" ");

      // **** ****
      int index = Integer.parseInt(split[0]);
      sb[index].append(split[1] + " ");
    }

    // **** build and output the result string ****
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < 100; i++) {
      result.append(sb[i].toString());
    }
    System.out.println(result.toString());

    // **** close buffered reader ****
    bufferedReader.close();
  }

  // /**
  // * Original test scaffolding.
  // */
  // public static void main(String[] args) throws IOException {

  // // **** ****
  // BufferedReader bufferedReader = new BufferedReader(new
  // InputStreamReader(System.in));

  // // **** ****
  // int n = Integer.parseInt(bufferedReader.readLine().trim());

  // // **** ****
  // List<List<String>> arr = new ArrayList<>();

  // // **** ****
  // IntStream.range(0, n).forEach(i -> {
  // try {
  // arr.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split("
  // ")).collect(toList()));
  // } catch (IOException ex) {
  // throw new RuntimeException(ex);
  // }
  // });

  // // **** ****
  // countSort(arr);

  // // **** ****
  // bufferedReader.close();
  // }
}