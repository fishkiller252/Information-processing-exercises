package struct;

/**
 * @author 学籍番号 氏名
 */
public class TestPoint {

	public static double area(Point p1, Point p2, Point p3) {
		double d12 =  Point.distance(p1, p2);
		double d23 =  Point.distance(p2, p3);
		double d13 =  Point.distance(p3, p1);
		double s = (d12 + d23 + d13) / 2.0;
		return  Math.sqrt(s * (s - d12) * (s - d23) * (s - d13));
	}

	public static void main(String[] args) {
		Point p1 = new Point(3.0, 0.0);
		Point p2 = new Point(0.0, 4.0);
		Point p3 = new Point(0.0, 0.0);
		System.out.println(area(p1, p2, p3));

		Point p4 = new Point(1.0, 2.0, 3.0);
		Point p5 = new Point(1.0, 2.0);
		System.out.println(Point.distance(p4,p5)); 
	}
} 