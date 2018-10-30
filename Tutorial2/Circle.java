public class Circle extends Shape{
    double radius;
    Point centre;

    public Circle(Point centre, double radius){
        this.centre = centre;
        this.radius = radius;
    }

    public double getArea(){
        return 0;
    }

    public void print(){
        System.out.println("Hi!");
    }
}
