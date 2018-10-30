package cs2030.mystream;

import java.util.function.*;
import java.util.List;
import java.util.ArrayList;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class MyIntStream implements IntStream {
    private List<Integer> list;

    private MyIntStream(List<Integer> arr) {
        this.list = arr;
    }

    public static MyIntStream of(int ... elements) {
        List<Integer> arr = new ArrayList<>();
        for (int i: elements) {
            arr.add(i);
        }
        return new MyIntStream(arr);
    }

    public int sum() {
        int s = 0;
        for (int i: list) {
            s += i;
        }
        return s;
    }

    public static MyIntStream range(int start, int end) {
        List<Integer> arr = new ArrayList<>();
        for (int i = start; i < end; i++) {
            arr.add(i);
        }
        return new MyIntStream(arr);
    }

    public static MyIntStream rangeClosed(int start, int endInc) {
        List<Integer> arr = new ArrayList<>();
        for (int i = start; i <= endInc; i++) {
            arr.add(i);
        }
        return new MyIntStream(arr);
    }

    public int count() {
        return list.size();
    }

    public OptionalDouble average() {
        int s = this.sum();
        if (s == 0) {
            return OptionalDouble.empty();
        } else {
            return OptionalDouble.of(s/list.size());
        }
    }

    public OptionalInt max() {
        if (list.size() == 0) {
            return OptionalInt.empty();
        }
        int m = list.get(0);
        for (int i: list) {
            if (i > m) {
                m = i;
            }
        }
        return OptionalInt.of(m);
    }

    public OptionalInt min() {
        if (list.size() == 0) {
            return OptionalInt.empty();
        }
        int m = list.get(0);
        for (int i: list) {
            if (i < m) {
                m = i;
            }
        }
        return OptionalInt.of(m);
    }

    public void forEach(IntConsumer action) {
        for (int i: list) {
            action.accept(i);
        }
    }

    public MyIntStream map(IntUnaryOperator mapper) {
        List<Integer> arr = new ArrayList<Integer>();
        for (int i: list) {
            arr.add(mapper.applyAsInt(i));
        }
        return new MyIntStream(arr);
    }

    public MyIntStream filter(IntPredicate predicate) {
        List<Integer> arr = new ArrayList<>();
        for (int i: list) {
            if (predicate.test(i)) {
                arr.add(i);
            }
        }
        return new MyIntStream(arr);
    }

    public MyIntStream limit(int maxSize) {
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < maxSize; i++) {
            arr.add(list.get(i));
        }
        return new MyIntStream(arr);
    }

    public MyIntStream distinct() {
        List<Integer> arr = new ArrayList<>();
        for (int i: list) {
            if (!arr.contains(i)) {
                arr.add(i);
            }
        }
        return new MyIntStream(arr);
    }

    public int reduce(int identity, IntBinaryOperator op) {
        if (list.size() == 0) {
            return identity;
        }
        int res = op.applyAsInt(identity, list.get(0));
        for (int i = 1; i < list.size(); i++) {
            res = op.applyAsInt(res, list.get(i));
        }
        return res;
    }

    public OptionalInt reduce(IntBinaryOperator op) {
        if (list.size() == 0) {
            return OptionalInt.empty();
        }
        int res = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            res = op.applyAsInt(res, list.get(i));
        }
        return OptionalInt.of(res);
    }
}
