import java.util.stream.IntStream;
import java.util.concurrent.ForkJoinPool;
import java.time.Instant;
import java.time.Duration;


class Main {
    public static void main(String[] args) {
        System.out.println(ForkJoinPool.commonPool().getParallelism());
        int num = IntStream.rangeClosed(1, 10)
            .filter(x -> {
                System.out.println("filter: " + x + " " + Thread.currentThread().getName());
                return x % 2 == 0;
            })
            .map(x -> {
                System.out.println("map: " + x + " " + Thread.currentThread().getName());
                return 2*x;
            })
            .sum();

        Instant instant1 = Instant.now();
        long count = IntStream
            .range(2000000, 3000000)
            .parallel()
            .filter(x -> {
                if (x % 2 == 0) {
                    return false;
                } else {
                    for (int i = 3; i <= (int) Math.sqrt(x); i++) {
                        if (x % i == 0) {
                            return false;
                        }
                    }
                    return true;
                }
            })
            .count();
        Instant instant2 = Instant.now();

        System.out.println(count);
        System.out.println(Duration.between(instant1, instant2));
    }
}
