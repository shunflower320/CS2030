import java.util.stream.Stream;

class Main {
    static int sum(int first, int last) {
        if (first == last) {
            return first;
        }

        int mid = (first + last) / 2;
        int left = sum(first, mid);
        int right = sum(mid + 1, last);
        return left + right;
    }

    public static void main(String[] args) {
        //sum from 1 to n
        int first = 1;
        int last = 10;
        System.out.println(sum(first, last));
    }

    public static void main(String[] args) {
        System.out.println(Stream.of(1, 2, 3, 4)
            .reduce("A",
                    (x, y) -> {
                        System.out.println("Accumulate");
                        return x + y;
                    },
                    (x, y) -> {
                        System.out.println("Combine");
                        return x + y;
                    })
            );
    }
}
