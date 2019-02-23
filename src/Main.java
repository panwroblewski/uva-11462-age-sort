import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    // You are given the ages (in years) of all people of a country with at least 1 year of age. You know that
//    no individual in that country lives for 100 or more years. Now, you are given a very simple task of
//    sorting all the ages in ascending order.
//            Input
//    There are multiple test cases in the input file. Each case starts with an integer n (0 < n ≤ 2000000), the
//    total number of people. In the next line, there are n integers indicating the ages. Input is terminated
//    with a case where n = 0. This case should not be processed.
//    Output
//    For each case, print a line with n space separated integers. These integers are the ages of that country
//    sorted in ascending order.
//    Warning: Input Data is pretty big (∼ 25 MB) so use faster IO.
//    Sample Input
//        5
//        3 4 2 1 5
//        5
//        2 3 2 3 1
//        0
//    Sample Output
//        1 2 3 4 5
//        1 2 2 3 3

    public static void main(String[] args) {
        List<int[]> testCases = readFile();

        testCases.stream().forEach(el -> printArray(countingSortImpl(el, 1, 100)));
    }

    public static int[] countingSortImpl(int[] arr, int min, int max) {
        int delta = max - min;
        int[] possibilities = new int[delta + 1],
                sortedArr = new int[arr.length],
                sumCount = new int[delta + 1];
        int[][] occurencies = new int[possibilities.length][possibilities.length];

        // fill array with occurencies of possible values
        for (int i = 0; i < delta + 1; i++) {
            possibilities[i] = min++;
            occurencies[1][i] = countValue(arr, possibilities[i]);
        }
        occurencies[0] = possibilities;

        // count max indexes for occurencies
        for (int i = 0; i < occurencies[1].length; i++) {
            sumCount[i] = occurencies[1][i] + (i == 0 ? 0 : sumCount[i - 1]);
        }

        // populate sorted array
        for (int i = sortedArr.length - 1; i >= 0 ; i--) {
            for (int j = occurencies[1].length - 1; j >= 0; j--) {
                if (occurencies[1][j] == 0) {
                    continue;
                }

                for (int k = occurencies[1][j]; k > 0; k--) {
                    sortedArr[i--] = occurencies[0][j];
                }
            }
        }

        return sortedArr;
    }

    static int countValue(int arr[], int val) {
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) {
                counter++;
            }
        }
        return counter;
    }

    public static List<int[]> readFile() {

        List<int[]> testCases = new ArrayList<>();
        int counter = 1;

        try (BufferedReader br = new BufferedReader(new FileReader("./testCase.txt"))) {
            for (String line; (line = br.readLine()) != null; ) {
                if (counter++ % 2 == 0) {
                    testCases.add(Arrays.asList(line.split(" ")).stream().mapToInt(Integer::parseInt).toArray());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return testCases;
    }

    public static void printArray(int[] arr) {
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
