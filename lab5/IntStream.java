package cs2030.mystream;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.*;

public interface IntStream {
    public static IntStream of(int ... elements) {
        return MyIntStream.of(elements);
    }

    public static IntStream range(int start, int end) {
        return MyIntStream.range(start, end);
    }

    public static IntStream rangeClosed(int start, int endInc) {
        return MyIntStream.rangeClosed(start, endInc);
    }

    public int sum();

    public int count();

    public OptionalDouble average();

    public OptionalInt max();

    public OptionalInt min();

    public void forEach(IntConsumer action);

    public IntStream map(IntUnaryOperator mapper);

    public IntStream filter(IntPredicate predicate);

    public IntStream limit(int maxSize);

    public IntStream distinct();

    public int reduce(int identity, IntBinaryOperator op);

    public OptionalInt reduce(IntBinaryOperator op);
}
