public class SimpleCircle{
    double radius;

    public SimpleCircle(double radius){
        this.radius = radius;
    }

    @Override //if the method that you intend to override does not exist, then there will be an error   
    public String toString(){ //toString is a method of the object type "String", this replaces println
        return "Circle with radius "+radius;
    }
   
    public boolean equals(Object obj){
        if (obj == this){//why need this
            return true;
        } else{
            if (obj instanceof SimpleCircle){
                return this.radius == ((SimpleCircle) obj).radius;
            } return false;
        }
    }
}
