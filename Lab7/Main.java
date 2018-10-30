import cs2030.mystream.InfiniteList;

class Main {
    public static void main(String[] args) {
        /*
        InfiniteList.iterate(0, x -> x + 1).limit(0).limit(3).count();
        InfiniteList.iterate(0, x -> x + 1).limit(0).forEach(System.out::println);
        System.out.println();
        InfiniteList.iterate(0, x -> x + 1).limit(1).forEach(System.out::println);
        System.out.println();
        InfiniteList.iterate(0, x -> x + 1).limit(2).forEach(System.out::println);
        System.out.println();
        InfiniteList.iterate(0, x -> x + 1).limit(3).forEach(System.out::println);
        System.out.println();
        InfiniteList.iterate(0, x -> x + 1).limit(4).forEach(System.out::println);
        System.out.println();
        long c = InfiniteList.iterate(0, x -> x + 1).limit(4).filter(x -> x < 2).count();
        System.out.println(c);
        
        InfiniteList.iterate(32, x -> x + 2).map(x -> 2 * x).map(x -> x / 2).filter(x -> x % 3 == 0).takeWhile(x -> x < 100).limit(7).map(x -> x * x).forEach(System.out::println);
        */
        System.out.println(InfiniteList.iterate(0, x -> x + 1).filter(x -> x > 10).head());
    }
}
