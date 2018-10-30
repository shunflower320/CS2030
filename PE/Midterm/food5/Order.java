/**
 * Superclass of food and combo.
 */

class Order {
    protected int id;
    protected String name;
    protected String type;
    protected int price;

    Order(int id, String type, String name, int price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
    }
}
