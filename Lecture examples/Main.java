class Main{
    public static void main(String[] args){
        Circle c = new Circle(new Point(0, 0), 10);
        Shape s = c;
        Printable p = c;
        p.print();
    }
}
