package interviewPreparationKit.WarmupChallenges.sockMerchant;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SockMerchant {
    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        HashMap<Integer, Integer> arMap = new HashMap<>();
        for (int i = 0; i<ar.length; i++){
            Integer countSock = arMap.get(ar[i]);
            if (countSock != null){
                countSock++;
            }else{
                countSock = 1;
            }
            arMap.put(ar[i], countSock);
        }
        int amountSocks = 0;
        for (Map.Entry<Integer, Integer> map : arMap.entrySet()){
            amountSocks += map.getValue()/2;
        }
        return amountSocks;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        //bufferedWriter.close();

        scanner.close();
    }

}
