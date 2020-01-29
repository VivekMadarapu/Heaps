import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class Goat {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("goat.dat"));
        int cases = input.nextInt();
        List<Integer> cycleSizes = new ArrayList<>();
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
                cycleSizes.add(goat.size());
            }
            int daysNotEaten = 0;
            while(goats.size() != 0 && daysNotEaten <= Collections.max(cycleSizes)){
                boolean leave = true;
                for (int j = 0; j < goats.size(); j++) {
                    for (int k = 0; k < goats.size(); k++) {
                        if(!Arrays.equals(goats.get(j).toArray(), goats.get(k).toArray())){
                            leave = false;
                        }
                    }
                }
                if(leave){
                    break;
                }
                List<Integer> milk = new ArrayList<>();
                for (int j = 0; j < goats.size(); j++) {
                    milk.add(goats.get(j).removeFirst());
            }
                List<Integer> milkSorted = new ArrayList<>(milk);
                Collections.sort(milkSorted);
                if(goats.size() == 1){
                    goats.clear();
                    cycleSizes.clear();
                    milk.clear();
                    daysNotEaten = 0;
                }
                else if(milkSorted.get(0) == milkSorted.get(1)){
                    for (int j = 0; j < goats.size(); j++) {
                        goats.get(j).addLast(milk.get(j));
                    }
                    daysNotEaten++;
                }
                else{
                    goats.remove(milk.indexOf(milkSorted.get(0)));
                    cycleSizes.remove(milk.indexOf(milkSorted.get(0)));
                    milk.remove(milkSorted.get(0));
                    for (int j = 0; j < goats.size(); j++) {
                        goats.get(j).addLast(milk.get(j));
                    }
                    daysNotEaten = 0;
                }
                days++;
            }
            System.out.println(goats.size() + " " + (days));
        }
    }
}
