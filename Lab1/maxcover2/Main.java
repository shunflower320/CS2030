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

        for (int i=0; i<n-1; i++){
            System.out.println(points[i].coordinates()+" and "+points[i+1].coordinates()+" has mid-point "+points[i].midPoint(points[i+1])+" and angle "+String.format("%.3f", points[i].angle(points[i+1])));
        }
    }
}
