package notFromHackerRank;

import java.io.IOException;
import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) throws IOException {
        PriorityQueue nextClient = new PriorityQueue();
        nextClient.add("4");
        nextClient.add("2");
        nextClient.add("3");
        nextClient.offer("3");
        System.out.println(nextClient);
        System.out.print(nextClient.size() + " " + nextClient.poll());
        System.out.print(" " + nextClient.peek() + " " + nextClient.poll());
        System.out.println(" " + nextClient.poll() + " " + nextClient.poll());
    }

}
