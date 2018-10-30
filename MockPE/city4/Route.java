/**
 * A route is made up of 2 cities and their distance.
 * It has methods to print routes, and return cities.
 */

public class Route {
    private City city1;
    private City city2;
    private double distance;

    /**
     * A route consists of 2 cities and their distance.
     * @param city1 first city.
     * @param city2 second city.
     * @param distance distance between them.
     */

    public Route(City city1, City city2, double distance) {
        this.city1 = city1;
        this.city2 = city2;
        this.distance = distance;
    }

    public String routeName() {
        return city1.getName() + " and " + city2.getName() + " is " + distance + "km apart";
    }

    public City getCity(int n) {
        if (n == 1) {
            return city1;
        } else {
            return city2;
        }
    }

    public double getDistance() {
        return distance;
    }
}
