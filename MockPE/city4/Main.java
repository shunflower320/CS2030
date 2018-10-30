import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            City city1 = new City(sc.next());
            City city2 = new City(sc.next());
            Route route = new Route(city1, city2, sc.nextDouble());
            LTA.addRoute(route);
        }

        LTA.run();
    }
}

