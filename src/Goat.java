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
            while(goats.size() != 0 && daysNotEaten <= lcm(cycleSizes.toArray())){
                List<Integer> milk = new ArrayList<>();
                for (Deque<Integer> goat : goats) {
                    milk.add(goat.removeFirst());
                }
                List<Integer> milkSorted = new ArrayList<>(milk);
                Collections.sort(milkSorted);
                if(goats.size() == 1){
                    goats.clear();
                    cycleSizes.clear();
                    milk.clear();
                    daysNotEaten = 0;
                }
                else if(milkSorted.get(0).equals(milkSorted.get(1))){
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
            System.out.println(goats.size() + " " + (days-daysNotEaten));
        }
    }

    public static long lcm(Object[] element_array)
    {
        long lcm_of_array_elements = 1;
        int divisor = 2;

        while (true) {
            int counter = 0;
            boolean divisible = false;

            for (int i = 0; i < element_array.length; i++) {

                if ((int)element_array[i] == 0) {
                    return 0;
                }
                else if ((int)element_array[i] < 0) {
                    element_array[i] = (int)element_array[i] * (-1);
                }
                if ((int)element_array[i] == 1) {
                    counter++;
                }

                if ((int)element_array[i] % divisor == 0) {
                    divisible = true;
                    element_array[i] = (int)element_array[i] / divisor;
                }
            }

            if (divisible) {
                lcm_of_array_elements = lcm_of_array_elements * divisor;
            }
            else {
                divisor++;
            }

            if (counter == element_array.length) {
                return lcm_of_array_elements;
            }
        }
    }

}