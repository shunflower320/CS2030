import java.util.ArrayList;
import java.util.Collections;

/**
 * LTA controls all routes and cities.
 * When cities and routes are created in main, they get added to LTA's database.
 * Here it would alr eliminate repeated routes and cities.
 * Routes with distance of 0 are also eliminated.
 */

public class LTA {
    private static ArrayList<City> cities = new ArrayList<City>();
    private static ArrayList<String> cityNames = new ArrayList<String>();
    private static ArrayList<Route> routes = new ArrayList<Route>();

    /**
     * Save distance of route1.
     * Loop through the rest to find max distance.
     * Loop again to find ties.
     */

    public static ArrayList<String> getLongestRoute() {
        Route route1 = routes.get(0);
        double distance = route1.getDistance();
        Route LR = route1;

        for (Route route: routes) {
            if (route.getDistance() > distance) {
                distance = route.getDistance();
                LR = route;
            }
        }

        ArrayList<String> LRs = new ArrayList<String>();

        for (Route route: routes) {
            if (route.getDistance() == distance) {
                LRs.add(route.routeName());
            }
        }

        Collections.sort(LRs);
        return LRs;
    }

    /**
     * First find accessibility of 1 city, then use nested loop of cities and routes.
     * For every other city in cities, check if they are more accessible than the saved one.
     */

    public static int getAccessibility(City city) {
        int a = 0;
        String cityName = city.getName();
        for (Route route: routes) {
            if (route.getCity(1).getName().equals(cityName)) {
                a++;
            } else if (route.getCity(2).getName().equals(cityName)) {
                a++;
            }
        }
        return a;
    }

    /**
     * Loop once to get the MAC.
     * Then loop again to find those with same accessibility.
     */

    public static ArrayList<String> mostAccessibleCity() {
        City city1 = cities.get(0);
        int a = getAccessibility(city1);
        City MAC = city1;

        for (City city: cities) {
            if (getAccessibility(city) > a) {
                a = getAccessibility(city);
                MAC = city;
            }
        }

        ArrayList<String> MACs = new ArrayList<String>();

        for (City city: cities) {
            if (getAccessibility(city) == a) {
                MACs.add(city.getName());
            }
        }

        Collections.sort(MACs);
        return MACs;
    }

    /**
     * Elminates routes with distance of 0.
     * Then compare route with existing routes,
     * and eliminate those with same cities.
     */

    public static void addRoute(Route route) {
        if (route.getDistance() < 0 | route.getCity(1).getName().equals(route.getCity(2).getName())) {
            return;
        } else if (routeNotInList(route)) {
            routes.add(route);
            addCity(route.getCity(1));
            addCity(route.getCity(2));
        }
    }

    public static boolean routeNotInList(Route route) {
        for (Route r: routes) {
            ArrayList<String> citiesInRoute = new ArrayList<String>();
            City city1 = r.getCity(1);
            City city2 = r.getCity(2);
            citiesInRoute.add(city1.getName());
            citiesInRoute.add(city2.getName());
            if (citiesInRoute.contains(route.getCity(1).getName()) & citiesInRoute.contains(route.getCity(2).getName())) {
                return false;
            }
        }
        return true;
    }

    public static void addCity(City city) {
        if (cityNotInList(city)) {
            cities.add(city);
            cityNames.add(city.getName());
        }
    }

    public static boolean cityNotInList(City city) {
        if (!cityNames.contains(city.getName())) {
            return true;
        }
        return false;
    }

    public static void run() {
        System.out.println("Number of cities: " + cities.size());
        System.out.println("Number of routes: " + routes.size() + "\n");

        System.out.println("List of cities:");
        for (City city: cities) {
            System.out.println(city.getName());
        }

        System.out.println("\nList of routes:");
        for (Route route: routes) {
            System.out.println(route.routeName());
        }

        System.out.println("\nMost accessible cities (sorted):");
        for (String name: mostAccessibleCity()) {
            System.out.println(name);
        }

        System.out.println("\nLongest routes (sorted):");
        for (String name: getLongestRoute()) {
            System.out.println(name);
        }
    }
}
