import java.util.stream.IntStream;

class Main {
    public static void main(String [] args) {
        IntStream.range(1, 3)
            .mapToObj(c -> {//to show that circles are not all created first
                System.out.println(c);
                return new Circle(c);
            }) // else just do (Circle::new)
            .forEach(System.out::println);
    }

    public static void main(Stringp[] args) {
        IntStream.iterate(1, x -> x+1)
            .mapToObj(c -> {
                System.out.println(c);
                return new Circle(c);
            })
            .limit(5) //only here does the computer know it ends at 5
            .forEach(System.out::println);
    }

    public static void main(String[] args) {
        Stream.of(new Circle(5), new Circle(2))
                .mapToDouble(c -> c.getArea())
                .forEach(System.out::println);
    }

    class MyInteger {
        int x = 0;
    }

    MyInteger count = new MyInteger();
    int n = Integer.parseInt(args[0]);

    public static void main(String [] args) { //primality
        IntStream.range(2, n)
            .filter(i -> n % i == 0)
            .forEach(x -> (count.x)++);
        System.out.println(count == 0);
    } //not pure fp
}
