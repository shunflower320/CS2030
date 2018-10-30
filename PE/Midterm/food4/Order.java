class Order {
    private int ID;
    private String name;
    private String type;
    private int price;

    public void Order(int ID, String type, String name, int price) {
        this.ID = ID;
        this.type = type;
        this.name = name;
        this.price = price;
    }
}
