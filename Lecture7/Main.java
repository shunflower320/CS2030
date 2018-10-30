import java.util.stream.IntStream;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);

        int sum = IntStream
            .rangeClosed(1, 10)
            .map(x -> 2*x)
            .sum();

        System.out.println(sum);
    }
}
