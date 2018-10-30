import cs2030.mystream.MyIntStream;

class Main {
    public static void main(String[] args) {
        System.out.println(MyIntStream.of(1, 2, 3, 4, 5, 6)
                .filter(x -> x%2==0)
                .reduce(0, (x, y) -> x+y));
    }
}
