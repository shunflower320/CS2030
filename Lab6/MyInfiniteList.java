package cs2030.mystream;

import java.util.function.Supplier;
import java.util.function.UnaryOperator;

class MyIFL<T> {
    private Supplier<T> head;
    private Supplier<MyIFL<T>> tail;

    private MyIFL<T>(Supplier<T> head, Supplier<MyIFL<T>> tail) {
        this.head = head;
        this.tail = tail;
    }

    //if you don't want head to change, then don't just construct with s like the code below.
    //you should use () -> supply.get() to ensure that every new IFL created has same head.
    //you need supplier s as head because you want lazy evaluation.
    //will always get same head.
    static <T> MyIFL<T> generate(Supplier<? extends T> s) {
        return new MyIFL<T>(() -> s, () -> generate(s));
    }

    static <T> MyIFL<T> iterate(T seed, UnaryOperator<T> next) {
        return new MyIFL<T>(next.apply(seed), next);
    }

    long count() {
        IFL.this
    }
}
