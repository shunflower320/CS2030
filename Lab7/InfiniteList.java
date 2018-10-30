package cs2030.mystream;
import java.util.function.*;
import java.util.Optional;

public interface InfiniteList<T> {
    static <T> InfiniteList<T> generate(Supplier<? extends T> supplier) {
        return new MyIFL<T>() {
            boolean _isEmpty() {
                return false;
            }
            T _head() {
                return supplier.get();
            }
            MyIFL<T> _tail() {
                return (MyIFL<T>) InfiniteList.generate(supplier);
            }
        };
    }

    
    static <T> InfiniteList<T> iterate(T seed, UnaryOperator<T> next) {
        return new MyIFL<T>() {
            boolean _isEmpty() {
                return false;
            }
            T _head() {
                return seed;
            }
            MyIFL<T> _tail() {
                return (MyIFL<T>) InfiniteList.iterate(next.apply(seed), next);
            }
        };
    }

    boolean isEmpty();
    
    T head();

    MyIFL<T> tail();

    long count();

    void forEach(Consumer<? super T> action);

    Optional reduce(BinaryOperator<T> accumulator);

    T reduce(T identity, BinaryOperator<T> accumulator);
    
    Object[] toArray();

    InfiniteList<T> limit(long maxSize);

    InfiniteList<T> filter(Predicate<? super T> predicate);

    <R> InfiniteList<R> map(Function<? super T, ? extends R> mapper);
    
    InfiniteList<T> takeWhile(Predicate<? super T> predicate);
}
