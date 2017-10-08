package advanced5b;

import java.awt.Point;

/**
 * @author 学籍番号 氏名
 *
 */
public class TestOfMyVector {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyVector v1 = new MyVector(new double[]{2.4, -1.0, 1.8});
		MyVector v2 = new MyVector(new double[]{2.4, -1.0, 1.8});
		MyVector v3 = new MyVector(new double[]{2.4, -1.0});
		MyVector v4 = new MyVector(new double[]{5.2,  3.8, 9.9});
		Point.Double p1 = new Point.Double(2.4, -1.0);

		System.out.println( "Vector v1 is " + v1.toString());

		if ( v1.equals(v2)) { System.out.println("v1 == v2"); }
		else { System.out.println("v1 != v2"); }
		if ( v1.equals(v3)) { System.out.println("v1 == v3"); }
		else { System.out.println("v1 != v3"); }
		if ( v4.equals(v1)) { System.out.println("v4 == v1"); }
		else { System.out.println("v4 != v1"); }
		if ( v1.equals(p1)) { System.out.println("v1 == p1"); }
		else { System.out.println("v1 != p1"); }

		System.out.println("hashCode(v1)=" + v1.hashCode());
		System.out.println("hashCode(v2)=" + v2.hashCode());
		System.out.println("hashCode(v3)=" + v3.hashCode());
		System.out.println("hashCode(v4)=" + v4.hashCode());
	}

}
