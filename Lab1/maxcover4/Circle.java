class Circle{
    Point centre;
    int radius;

    public Circle(Point centre, int radius){
        this.centre = centre;
        this.radius = radius;
    }

    public double[] centre_coords(Point pt1, Point pt2){
        double pq_half = pt1.distance(pt2)/2;
        double mc = Math.sqrt(1-(Math.pow(pq_half, 2)));
        double new_angle = (Math.PI/2)-pt1.angle(pt2);

        double[] coords = new double[2];
        double x = pt1.mdpt_x(pt2);
        double y = pt1.mdpt_y(pt2);
        Point mid = new Point(x, y);

        coords[0] = mid.move_x(mc*Math.cos(new_angle));
        coords[1] = mid.move_y(mc*Math.sin(new_angle));
        return coords;
    }

    public boolean contains(Point pt){
        return pt.distance(centre)<=1;
    }

    /*
    public String centre(Point pt){ //sth wrong here
        return "("+String.format("%.3f", centre_coords(pt2)[0])+", "+String.format("%.3f", pt1.centre_coords(pt2)[1])+")";
    }
    */
}
