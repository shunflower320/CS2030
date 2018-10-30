import java.util.List;
import java.util.ArrayList;
import java.util.function.Supplier;

class Delay {//assigns value the moment the object is created, so when they are "get" at different times, the output is different
    static int x = 0;
    int y;

    Delay(){
        y = ++x; //changes x
    }

    int getY() {
        return y;
    }

    @Override
    public String toString() {
        return getY() + "";
    }

    public static void main(String[] args) {
        List<Delay> list = new ArrayList<>();
        list.add(new Delay()); //repeat this many times
        list.add(new Delay());
        System.out.println(x);
    }
}

class Delay {//prints the same number purely based on "get" time, regardless of created time.
    static int x = 0;
    Supplier<Integer> y;

    Delay(){
        y = () -> ++x;
    }

    int getY() {
        return y;
    }

    @Override
    public String toString() {
        return getY() + "";
    }

    public static void main(String[] args) {
        List<Delay> list = new ArrayList<>();
        list.add(new Delay()); //repeat this many times
        list.add(new Delay());
        System.out.println(list.get(0));
        System.out.println(list.get(1));
    }
}

