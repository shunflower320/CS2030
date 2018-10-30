import java.util.ArrayList;

class Combo extends Order {
    private ArrayList<Food> comboFood = new ArrayList<Food>();
    /*
    private int id;
    private String type;
    private String name;
    private int price;
    */

    public Combo(int id, String type, String name, int price) {
        super(id, type, name, price);
    }

    public void add(Food food) {
        comboFood.add(food);
    }

    String getType() {
        return type;
    }

    int getPrice() { //added this
        int price = 0;
        for (Food food: comboFood) {
            price += food.getPrice();
        }
        price -= 50;
        return price;
    }

    ArrayList<Food> getComboFood() {
        return comboFood;
    }
    
    int getid() {
        return id;
    }
}
