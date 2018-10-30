import java.util.stream;
import java.util.Pair;

class Main {
    public static Stream<BigInteger> fib(int n) {
        return Stream<Pair>.of(new Pair(0, 1))
            .flatMap(x -> 
    }

    public static void main(String[] args) {
        fib(10).forEach(System.out::println)
    }
}
