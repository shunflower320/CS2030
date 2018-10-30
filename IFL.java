import java.util.function.Supplier;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.Optional; //really optional, not so impt, but good practice

class IFL<T> {
    Supplier<T> head;
    Supplier<IFL<T>> tail; //supposed to supply an infinite list

    IFL(Supplier<T> s, Supplier<IFL<T>> tail) {
        this.head = s;
        this.tail = tail;
    }

    //can use T, but is not same T as the T tied to the class. If T not declared as anonymous T, then it would be referencing
    //non-static variable in static context, because T can be created as anything!!
    static <U> IFL<U> generate(Supplier<U> s) { //need declare U in front of IFL to show scoping.
        //return new IFL<T>(s); //there's no tail, only head. Not correct!!
        return new IFL<T>(s, () -> generate(s)); //tail must be called through generate
    }

    static <T> IFL<T> iterate(T seed, Function<T, T> next) {
        return new IFL<T>(() -> seed,
        () -> iterate(next.apply(seed), next);
    }

    //adds predicate to every IFL, so that at the terminal, only those that pass the predicate are processed
    //can try filtering directly also
    IFL<T> filter(Predicate<T> p) {
        return new IFL<T>(head,
        () -> tail.get().filter(p), p); //very impt, but i dont rly get
    }
    //use tail.get to go upstream until you get to the one with iterate as tail.

    boolean isHeadFiltered() {
        return !predicate.test(head);
    }

    IFL<T> limit(int n) {
        if (n == 1) {
            //return this;
            return new IFL<T>(head, () -> EmptyList());
        }
        return new IFL<T>(head, () -> tail.get().limit(n-1)) //recursion?!
    }

    void forEachPrint() {
        IFL<T> list;
        list = this;
        while (true) {
            System.out.println(list.head.get()); //calls from supplier
            list = list.tail.get(); //calls from another supplier (tho output happens to be the same)
            //new IFL created, even though same lambda (function for suppplier), is ultimately thru a diff path.
        }
        
    }

    void ForEach(Consumer<T> c) {
        IFL<T> list;
        list = this;
        while(true) {
            if (!list.isHeadFiltered()) { //remember to call the new list!!!!
                c.accept(list.head.get());
            }
            //c.accept(list.head.get());
            list = list.tail.get();
        }
    }

    public static void main(String[] args) {
        IFL.generate(() -> 1) //takes in supplier s, s only produces the element 1
        .forEachPrint(); //not terminal
    }

    public static void main(String[] args) {
        IFL.iterate(1, x -> x+1)
        .filter(x -> x % 2 == 0)
        .limit(5)
        .forEach(System.out::println);
    }
}