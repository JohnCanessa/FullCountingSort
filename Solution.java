import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


/**
 * 
 */
public class Solution {


  /**
   * Complete the countSort function below.
   * Using StringBuilder.
   */
  static void countSort0(List<List<String>> arr) {

    // **** initialization ****
    int ndx = 0;

    StringBuilder[] sb = new StringBuilder[100];
    for (int i = 0; i < 100; i++)
      sb[i] = new StringBuilder();

    // // **** to speed up String to Integer conversion ****
    // HashMap<String, Integer> hm = new HashMap<String, Integer>();
    // for (int i = 0; i <= 99; i++) {
    //   String s = Integer.toString(i);
    //   hm.put(s, i);
    // }

    // **** set first half of the strings to "- " ****
    for (int i = 0; i < (arr.size() / 2); i++) {

      // **** set index to string to integer ****
      // ndx = hm.get(arr.get(i).get(0));
      ndx = Integer.parseInt(arr.get(i).get(0));

      // **** ****
      sb[ndx].append("- ");
    }

    // **** append strings with same index to respective string builder ****
    for (int i = arr.size() / 2; i < arr.size(); i++) {

      // **** set index to string to integer ****
      // ndx = hm.get(arr.get(i).get(0));
      ndx = Integer.parseInt(arr.get(i).get(0));

      // **** ****
      sb[ndx].append(arr.get(i).get(1) + " ");
    }

    // **** display result string ****
    for (int i = 0; i < 100; i++) {

      // **** skip blank string builder ****
      if (sb[i].toString().equals("")) continue;

      // **** display string builder ****
      System.out.print(sb[i].toString());
    }

    // **** terminate line ****
    System.out.println();
  }


  /**
   * Complete the countSort function below.
   * Using StringBuffer.
   */
  static void countSort(List<List<String>> arr) {

    // **** sanity check(s) ****
    if (arr == null || arr.size() == 0) return;

    // **** initialization ****
    String str;

    StringBuffer[] sb = new StringBuffer[100];
    for (int i = 0; i < 100; i++)
      sb[i] = new StringBuffer();

    int size = arr.size();

    // **** traverse all entries in the string array ****
    for (int i = 0; i < size; i++) {

      // **** generate index ****
      int ndx = Integer.parseInt(arr.get(i).get(0));

      // **** set string ****
      if (i < size / 2)       // top half
        str = "- ";
      else                    // bottom half
        str = arr.get(i).get(1) + " ";

      // **** append string to string buffer ****
      sb[ndx] = sb[ndx].append(str);
    }

    // **** display result string ****
    for (int i = 0; i < 100; i++) {

      // **** skip blank string buffer ****
      if (sb[i].toString().equals("")) continue;

      // **** display contents of string buffer ****
      System.out.print(sb[i]);
    }
  }




  /**
   * Test scaffolding. 
   * UNACCEPTABLE having to replace the test scaffolding.
   */
  public static void main(String[] args) throws IOException {

    // **** initialization ****


    // **** open a buffered reader ****
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    // **** get the number of elements ****
    int n = Integer.parseInt(bufferedReader.readLine().trim());


  // **** ****
    StringBuffer[] sb = new StringBuffer[100];
    for (int i = 0; i < 100; i++)
      sb[i] = new StringBuffer();



    // **** process all `n` entries ****
    for (int i = 0; i < n; i++) {

      // **** read input line and split it ****
      String[] strs = bufferedReader.readLine().trim().split(" ");

      // **** extract index ****
      int ndx = Integer.parseInt(strs[0]);

      // **** ****
      String str;

      // **** set string ****
      if (i < n / 2)          // top half
        str = "- ";
      else                    // bottom half
        str = strs[1] + " ";

      // **** append string to string buffer ****
      sb[ndx] = sb[ndx].append(str);
    }




    // **** display result string ****
    for (int i = 0; i < 100; i++) {

      // **** skip blank string buffer ****
      if (sb[i].toString().equals("")) continue;

      // **** display contents of string buffer ****
      System.out.print(sb[i]);
    }





    // **** close buffered reader ****
    bufferedReader.close();
  }




  // /**
  // * Original test scaffolding.
  // */
  // public static void main(String[] args) throws IOException {

  //   // **** ****
  //   BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

  //   // **** ****
  //   int n = Integer.parseInt(bufferedReader.readLine().trim());

  //   // **** ****
  //   List<List<String>> arr = new ArrayList<>();

  //   // **** ****
  //   IntStream.range(0, n).forEach(i -> {
  //     try {
  //       arr.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).collect(toList()));
  //     } catch (IOException ex) {
  //       throw new RuntimeException(ex);
  //     }
  //   });

  //   // **** close the buffered reader ****
  //   bufferedReader.close();

  //   // **** function of interest (fails on test case #5) ****
  //   countSort0(arr);

  //   // **** function of interest (passes all tests) ****
  //   countSort(arr);
  //   }
}