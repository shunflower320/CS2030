/**
 * Every food order is an order.
 * Food has id, name, type and price.
 */

public class Food extends Order {
    /**
     * Constructor.
     * @param id id of food.
     * @param type type of food.
     * @param name name of food.
     * @param price price of food.
     */

    public Food(int id, String type, String name, int price) {
        super(id, type, name, price);
    }

    int getid() {
        return id;
    }

    String getType() {
        //System.out.println(this.name);
        return type;
    }

    String getName() {
        return name;
    }

    int getPrice() {
        return price;
    }

}
