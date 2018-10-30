import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

class Main {
    static long countRepeats(int[] array) {
        return IntStream.range(0, array.length-1)
                .filter(i -> array[i] == array[i+1] && 
                    (i == 0 || array[i-1] != array[i]))
                .count();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        while (sc.hasNext()) {
            list.add(sc.nextInt());
        }

        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        System.out.println("Number of occurrences: " + countRepeats(arr));
    }
}
