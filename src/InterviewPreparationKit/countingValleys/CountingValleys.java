package InterviewPreparationKit.countingValleys;

import java.io.IOException;
import java.util.Scanner;

public class CountingValleys {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        int up = 0;
        int down = 0;
        int valleyCount = 0;
        String[] path = s.split("");
        for (int i = 0; i < path.length; i++){
            if (path[i].equals("U")){
                up++;
            }else {
                if (down == 0 && up ==0){
                    valleyCount++;
                }
                down++;
            }
            if (up == down){
                up = down = 0;
            }
        }
        return valleyCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        //bufferedWriter.close();

        System.out.println(result);

        scanner.close();
    }
}
