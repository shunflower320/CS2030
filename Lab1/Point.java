public class Point {
	private double x;
	private double y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
    }

    public double get_x() {
        return this.x;
    }

    public double get_y(){
        return this.y;
    }

    public String coordinates(){
        return "("+String.format("%.3f", this.x)+", "+String.format("%.3f", this.y)+")";
    }

    public double angle(Point pt){
        return Math.atan2((pt.get_y()-this.y), (pt.get_x()-this.x));
    }

    public double mdpt_x(Point pt){
        return (this.x+pt.x)/2;
    }

    public double mdpt_y(Point pt){
        return (this.y+pt.y)/2;
    }

    public String midPoint(Point pt){
        return "("+String.format("%.3f", mdpt_x(pt))+", "+String.format("%.3f", mdpt_y(pt))+")";
    }

    public double distance(Point pt){
        return Math.sqrt(Math.pow(this.x-pt.get_x(), 2)+Math.pow(this.y-pt.get_y(), 2));
    }
    
    public double[] centre_coords(Point pt){
        double pq_half = this.distance(pt)/2;
        double mc = Math.sqrt(1-(Math.pow(pq_half, 2)));
        double new_angle = (Math.PI/2)-this.angle(pt);

        double[] coords = new double[2];
        coords[0] = mdpt_x(pt)-mc*Math.cos(new_angle);
        coords[1] = mdpt_y(pt)+mc*Math.sin(new_angle);
        return coords;
    }

    public String centre(Point pt){
        return "(" + String.format("%.3f", centre_coords(pt)[0]) + ", " + String.format("%.3f", centre_coords(pt)[1]) + ")";
    }

}
