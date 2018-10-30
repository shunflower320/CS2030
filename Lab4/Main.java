import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

class Main {
   static IntStream factors(int x) {
        ArrayList<Integer> lst = new ArrayList<>();
        IntStream.rangeClosed(1, x)
            .filter(d -> x % d == 0)
            .forEach(e -> lst.add(e));
        return lst.stream().mapToInt(Integer::intValue);
    }

   static boolean isPrime(int n) {
       if (n <= 1) {
           return false;
       } else {
           return IntStream.range(2, n/2 + 1)
               .filter(x -> n % x == 0)
               .count() == 0;
       }
   }

   static IntStream primeFactors(int x) {
       IntStream allFactors = factors(x);
       ArrayList<Integer> lst2 = new ArrayList<>();
       allFactors
           .filter(d -> isPrime(d))
           .forEach(e -> lst2.add(e));
       return lst2.stream().mapToInt(Integer::intValue);
   }

    static String toString(int[] arr) {
        String string = "";
        for (int i = 0; i < arr.length - 1; i++) {
            string += arr[i] +" ";
        }
        string += arr[arr.length - 1];
        return string;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int[] arr = primeFactors(x).toArray();
        System.out.println("Prime factors of " + x + " are: " + toString(arr));
    }
}
