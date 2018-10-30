import java.util.*;

public class Main{

	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
        int numberOfPoints = 0;

		Point[] points = new Point[n];
        Point[] centres = new Point[n-1];

		for (int i=0; i<n; i++){
			double x = sc.nextDouble();
			double y = sc.nextDouble();
            points[i] = new Point(x, y);
		}

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){

                if (points[i].distance(points[j])>2 || points[i].distance(points[j])==0){
                    continue;
                }
                //I think I don't need midpoint
                
                //double x_mdpt = points[i].mdpt_x(pt[j]); //in point class
                //double y_mdpt = points[i].mdpt_y(pt[j]); //in point class

                Circle circle = new Circle(new Point(0, 0), 1);
                
                double centre_x = circle.centre_coords(points[i], points[j])[0];
                double centre_y = circle.centre_coords(points[i], points[j])[1];

                Point centre = new Point(centre_x, centre_y);
                circle = new Circle(centre, 1);

                int num1 = 0;


                for (Point pt: points){
                    if (circle.contains(pt)){
                        num1+=1; //distance between all other points in points and the centre, if within circle, n+=1
                    }
                }

                if (num1>numberOfPoints){
                    numberOfPoints = num1;
                }
            }
        }

        System.out.println("Maximum Disc Coverage: "+numberOfPoints);
    }
}
