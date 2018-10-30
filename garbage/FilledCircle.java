import java.awt.color; //this is a pre-defined class, goes by RGB values

public class FilledCircle extends Circle{
    private Color colour;

    public FilledCircle(double radius, Color colour){
	    //super(); //not compulsory
	    super(radius); //preferred, then next line isn necessary
	    //this.radius = radius; //accesses from superclass, not defined under attribute
	    this.colour = colour;
    }

    public static void main(String[] args){
	    FilledCircle fc = new FilledCircle(1.0, Colour.WHITE);
    }
}
