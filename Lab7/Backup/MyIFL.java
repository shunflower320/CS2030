package cs2030.mystream;
import java.util.Optional;
import java.util.ArrayList;
import java.util.function.*;

abstract class MyIFL<T> implements InfiniteList<T> {
    public Optional<Boolean> isEmptyCache = Optional.empty();
    private T headCache = null;
    private MyIFL<T> tailCache = null;

    //to customise
    abstract boolean _isEmpty();
    abstract T _head();
    abstract MyIFL<T> _tail();

    public boolean isEmpty() {
        if (!this.isEmptyCache.isPresent()) {
            this.isEmptyCache = Optional.of(this._isEmpty());
        }
        return isEmptyCache.get();
    }

    public T head() {
        if (this.headCache == null) {
            this.headCache = this._head();
        }
        return this.headCache;
    }

    public MyIFL<T> tail() {
        if (this.tailCache == null) {
            this.tailCache = this._tail();
        }
        return this.tailCache;
    }
    
    public long count() {
        long counter = 0;
        MyIFL<T> list = this;
        //System.out.println(list.head()); //is indeed null
        //System.out.println(list.tail()); //is null too
        //System.out.println(list.isEmpty()); //is somehow false
        while (!list.isEmpty()) { //takeWhile first called
            //System.out.println("enter");
            counter++;
            //System.out.println("cough");
            list = list.tail(); //2nd takeWhile and iterate called
            if (list == null) {
                break;
            } else {
                continue;
            }
        }
        return counter;
    }

    public void forEach(Consumer<? super T> action) {
        MyIFL<T> list = this;
        while (!list.isEmpty()) {
            action.accept(list.head());
            if (list.tail() != null) {
                list = list.tail();
            } else {
                break;
            }
        }
    }

    public Optional<T> reduce(BinaryOperator<T> accumulator) {
        if (this.count() == 0) {
            return Optional.empty();
        } else {
            T result = this.head();
            MyIFL<T> list = this.tail();
            while (!list.isEmpty()) {
                result = accumulator.apply(result, list.head());
                if (list.tail() != null) {
                    list = list.tail();
                } else {
                    break;
                }
            }
            return Optional.of(result);
        }
    }

    public T reduce(T identity, BinaryOperator<T> accumulator) {
        T result = identity;
        MyIFL<T> list = this;
        while (!list.isEmpty()) {
            result = accumulator.apply(result, list.head());
            if (list.tail() != null) {
                list = list.tail();
            } else {
                break;
            }
        }
        return result;
    }

    public Object[] toArray() {
        ArrayList<T> arr = new ArrayList<>();
        MyIFL<T> list = this;
        while (!list.isEmpty()) {
            arr.add(list.head());
            if (list.tail() != null) {
                list = list.tail();
            } else {
                break;
            }
        }
        return arr.toArray();
    }

    public InfiniteList<T> limit(long maxSize) {
        if (maxSize == 0) {
            return new MyIFL<T>() {
                boolean _isEmpty() {
                    return true;
                }
                T _head() {
                    return null;
                }
                MyIFL<T> _tail() {
                    return null;
                }
            };
        }
        return new MyIFL<T>() {
            MyIFL<T> list = MyIFL.this;
            boolean _isEmpty() {
                return list.isEmpty();
            }
            T _head() {
                return list.head(); //if head is null, it will be null
            }
            MyIFL<T> _tail() {
                if (maxSize == 1) {
                    return null;
                } else if (list.tail() != null) {
                    return (MyIFL<T>) list.tail().limit(maxSize - 1);
                } else {
                    return null;
                }
            }
        };
    }

    public InfiniteList<T> filter(Predicate<? super T> predicate) {
        return new MyIFL<T>() {
            MyIFL<T> list = MyIFL.this;
            boolean _isEmpty() {
                while (!list.isEmpty()) {
                    if (predicate.test(list.head())) {
                        return false;
                    } else {
                        list = list.tail();
                        if (list == null) {
                            break;
                        }
                    }
                }
                return true;
            }
            T _head() {
                if (!list.isEmpty()) {
                    return list.head();
                } else {
                    return null;
                }
            }
            MyIFL<T> _tail() {
                MyIFL<T> tail = list.tail();
                if (tail != null) {
                    return (MyIFL<T>) tail.filter(predicate);
                } else {
                    return null;
                }
            }
        };
    }

    public <R> InfiniteList<R> map(Function<? super T, ? extends R> mapper) {
        MyIFL<T> list = this;
        return new MyIFL<R>() {
            boolean _isEmpty() {
                return list.isEmpty();
            }
            R _head() {
                return mapper.apply(list.head());
            }
            MyIFL<R> _tail() {
                if (list.tail() == null) {
                    return null;
                }
                return (MyIFL<R>) list.tail().map(mapper);
            }
        };
    }

    public InfiniteList<T> takeWhile(Predicate<? super T> predicate) {
        MyIFL<T> list = this;
        return new MyIFL<T>() { 
            boolean _isEmpty() {
                if (predicate.test(list.head())) {
                    return list.isEmpty();
                }
                return true;
            }
            T _head() {
                return list.head(); 
            }
            MyIFL<T> _tail() {
                return (MyIFL<T>) list.tail().takeWhile(predicate);
            }
        };
    }
}
