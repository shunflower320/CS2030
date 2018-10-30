class Point{
    //attributes
    private double x; //initialised x and y
    private double y;

    double getx(){
        return x;
    }

    double gety(){
        return y;
    }

    void setx(double x){
        this.x = x;
    }

    void sety(double y){
        this.y = y;
    }

    Point(double value1, double value2){
        this.x = value1; //assign value to object x
        this.y = value2;
    }

    public double distance (Point otherPoint){
        double dx = this.x - otherPoint.x; //not breaking abstraction barrier
        double dy = this.y - otherPoint.y;
        return Math.sqrt((dx*dx)+(dy*dy));
    }

    public boolean equals (Point pt){
        System.out.println("are they equal");
        return this==pt;
    }
    
    /*public static void main(String[] args){
        Point point1 = new Point(0, 0);
        Point point2 = new Point(1, 1);

        System.out.println(point1.distance(point2));
    }*/
}
