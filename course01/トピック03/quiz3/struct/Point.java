package struct;

/**
 * @author 学籍番号 氏名
 */
public class Point {
	double x, y, z;

	public Point(double x, double y) {
		this(x, y, 0);
	}
	
	public Point(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	 public static double distance(Point p1, Point p2) {
		return Math.sqrt((p1.x-p2.x)*(p1.x-p2.x)+(p1.y-p2.y)*(p1.y-p2.y)+(p1.z-p2.z)*(p1.z-p2.z));
	}
}