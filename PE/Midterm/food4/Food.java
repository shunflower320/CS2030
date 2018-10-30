public class Food extends Order {
    private int ID;
    private String name;
    private int price;
    private String type;

    public Food(int ID, String type, String name, int price) {
        this.ID = ID;
        this.type = type;
        this.name = name;
        this.price = price;
    }

    int getID() {
        return ID;
    }

    String getType() {
        return type;
    }

    String getName() {
        return name;
    }

    int getPrice() {
        return price;
    }

}
