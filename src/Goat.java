import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Goat {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("goat.dat"));
        int cases = input.nextInt();
        List<Deque<Integer>> goats = new ArrayList<>();
        for (int i = 0; i < cases; i++) {
            int n = input.nextInt();
            int days = 0;
            for (int j = 0; j < n; j++) {
                ArrayDeque<Integer> goat = new ArrayDeque<>();
                int t = input.nextInt();
                for (int k = 0; k < t; k++) {
                    goat.addLast(input.nextInt());
                }
                goats.add(goat);
            }
            System.out.println(goats);
            while(goats.size() != 0){
                int[] milk = new int[goats.size()];
                for (int j = 0; j < milk.length; j++) {
                    milk[j] = goats.get(j).removeFirst();
                }
                
                days++;
            }
            System.out.println(goats.size() + " " + days);
        }
    }
}
