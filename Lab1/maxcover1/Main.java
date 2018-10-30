import java.util.*;

public class Main{

	public static void main (String[] args){
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		Point[] points = new Point[n];

		for (int i=0; i<n; i++){
			double x = sc.nextDouble();
			double y = sc.nextDouble();
            points[i] = new Point(x, y);
		}

        for (Point pt: points){
          	System.out.println("("+String.format("%.3f", pt.get_x())+", "+String.format("%.3f", pt.get_y())+")"); 
        }
    }
}
