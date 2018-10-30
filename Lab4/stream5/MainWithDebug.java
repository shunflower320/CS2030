import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.OptionalDouble;
import java.util.function.IntToDoubleFunction;

class Main {
    static OptionalDouble variance(int[] array) {
        if (array.length > 1) {
            double mean = IntStream.of(array).average().getAsDouble();
            return IntStream.range(0, array.length)
                .map(i -> array[i])
                .mapToDouble(new IntToDoubleFunction() {
                    @Override
                    public double applyAsDouble(int n) {
                        double x = n;
                        return x;
                    }
                })
                .map(x -> {
                    System.out.println("x: " + x + " " + "mean: " + mean + " " + "n-1: " + (array.length-1));
                    double term = (x - mean)*(x - mean)/(array.length - 1);
                    System.out.println(term);
                    return term;
                })
                .reduce((x, y) -> x + y);
        } else {
            return OptionalDouble.empty();
        }
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
        System.out.println("Variance: " + variance(arr));
    }
}
