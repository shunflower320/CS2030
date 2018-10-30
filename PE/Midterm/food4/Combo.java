import java.util.ArrayList;

class Combo extends Order {
    private ArrayList<Food> comboFood = new ArrayList<Food>();
    private int ID;

    public Combo(int ID) {
        this.ID = ID;
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
    
    int getID() {
        return ID;
    }

    public void add(int i) {
        ArrayList<Food> menu = Menu.getMenu();
        for (Food food: menu) {
            if (food.getID() == i) {
                comboFood.add(food);
            }
        }
    }

    void print() {
        for (Food food: comboFood) {
            System.out.println("#" + food.getID() + " " + food.getType() + ": " + food.getName() + " (" + food.getPrice() +")");
        }
    }
}
