package interviewPreparationKit.arrays.twoDArrayDS;

import java.util.Scanner;
import java.io.*;

public class Solution {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        /* Hourglass's size */
        int sizeTopBottomHourglass = 3;
        int sizeMidHourglass = sizeTopBottomHourglass/2;

        int rowAux, colAux;

        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int posRow = 0; posRow < arr.length; posRow++) {
            if (posRow + sizeTopBottomHourglass <= arr.length) {
                rowAux = posRow;
                for (int posCol = 0; posCol < arr.length; posCol++) {
                    if (posCol + sizeTopBottomHourglass <= arr.length) {
                        colAux = posCol;
                        for (int i = 0; i < sizeTopBottomHourglass; i++) {
                            sum += arr[rowAux][colAux + i];
                        }

                        rowAux++;
                        colAux++;

                        for (int i = 0; i < sizeMidHourglass; i++) {
                            sum += arr[rowAux][colAux + i];
                        }

                        rowAux++;
                        colAux = posCol;

                        for (int i = 0; i < sizeTopBottomHourglass; i++) {
                            sum += arr[rowAux][colAux + i];
                        }

                        if (sum > maxSum){
                            maxSum = sum;
                        }

                        sum = 0;
                        rowAux = posRow;
                    }
                }
            }
        }
        return maxSum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/home/anakromeiro/Documents/Estudos/contests_hackerrank/src/interviewPreparationKit/arrays/twoDArrayDS/output/output.txt"));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
