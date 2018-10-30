public class Food extends Order {
    /*
    private int id;
    private String name;
    private int price;
    private String type;
    */

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
