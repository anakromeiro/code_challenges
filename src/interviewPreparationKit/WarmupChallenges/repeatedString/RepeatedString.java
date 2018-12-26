package interviewPreparationKit.WarmupChallenges.repeatedString;

import java.io.IOException;
import java.util.Scanner;

public class RepeatedString {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {

        long multiplus = (long) n/s.length();
        int countA = 0;
        for (char ch: s.toCharArray()) {
            if (ch == 'a'){
                countA++;
            }
        }
        long result = countA * multiplus;

        countA = 0;
        long resto = (long) n%s.length();
        if (resto > 0){
            for (char ch : s.substring(0, (int) resto).toCharArray()) {
                if (ch == 'a') {
                    countA++;
                }
            }
        }

        result = result + countA;

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        System.out.println(result);

        scanner.close();
    }
}
