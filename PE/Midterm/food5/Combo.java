/**
 * A combo order is an order.
 * A combo has an id, type, name and dummy variable for price.
 */

import java.util.ArrayList;

class Combo extends Order {
    private ArrayList<Food> comboFood = new ArrayList<Food>();

    public Combo(int id, String type, String name, int price) {
        super(id, type, name, price);
    }

    public void add(Food food) {
        comboFood.add(food);
    }

    String getType() {
        return type;
    }

    /**
     * Takes discount into account.
     */

    int getPrice() {
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
