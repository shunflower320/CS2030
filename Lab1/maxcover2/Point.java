public class Point{
	private double x;
	private double y;

	public Point(double x, double y){
		this.x = x;
		this.y = y;
    }

    public double get_x(){
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

    public String midPoint(Point pt){
        return "("+String.format("%.3f", (this.x+pt.x)/2)+", "+String.format("%.3f", (this.y+pt.y)/2)+")";
    }

}
