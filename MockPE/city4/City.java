/**
 * A city only has a name.
 * So it only needs 1 method, which returns its name.
 */

public class City {
    private String name;

    public City(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
}
