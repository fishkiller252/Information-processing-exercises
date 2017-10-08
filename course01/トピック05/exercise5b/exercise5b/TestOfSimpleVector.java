package exercise5b;

/**
 * 
 * @author 学籍番号 氏名
 *
 */
public class TestOfSimpleVector {

	private static String tos(SimpleVector v) {
		return "(" + v.getX() + "," + v.getY() + "," + v.getZ() + ")";
	}

	/**
	 * SimpleVectorクラスのテストを行う
	 * @param args
	 */
	public static void main(String[] args) {

		SimpleVector v1 = new SimpleVector(3.0, 3.0, 3.0);
		SimpleVector v2 = new SimpleVector(3.0, 3.0, 3.0);
		SimpleVector v3 = null;
		SimpleVector v4 = null;
		System.out.println("v1 is " + tos(v1));
		System.out.println("v2 is " + tos(v2));

		// TODO: 各メソッドを実装次第、それぞれコメントを外して動作確認する
		//  normalizeメソッド
///*
		System.out.println("--- normalize method ---");
		System.out.println("norm of v1 is " + v1.norm());
		v1.normalize();
		System.out.println("normalized v1 is " + tos(v1));
		System.out.println("norm of v1 is " + v1.norm());
//*/
		//  getUnitVectorメソッド
///*
		System.out.println("--- getUnitVector method ---");
		v4 = SimpleVector.getUnitVector(v2);
		System.out.println("v4(normalized v2) is " + tos(v4));
		System.out.println("norm of v4 is " + SimpleVector.norm(v4));
		System.out.println("norm of v2 is " + SimpleVector.norm(v2));
		if (v4.norm() == v2.norm()) System.out.println("implementation of method is NG");
		else System.out.println("implementation of method is OK");
//*/
		// diffメソッド１
///*
		System.out.println("--- diff method(1) ---");
		v3 = v1.diff(v2);
		System.out.println("v3(diff of v1 and v2) is " + tos(v3));
		System.out.println("norm of v3 is " + SimpleVector.norm(v3));
		System.out.println("norm of v2 is " + SimpleVector.norm(v2));
		System.out.println("norm of v1 is " + SimpleVector.norm(v1));
		if ( v1.norm() == v3.norm() || v2.norm() == v3.norm()) {
			System.out.println("implementation of method is NG");
		} else {
			System.out.println("implementation of method is OK");
		}
//*/
		// diffメソッド2
///*
		System.out.println("--- diff method(2) ---");
		v4 = SimpleVector.diff(v1, v2);
		System.out.println("v4(diff of v1 and v2) is " + tos(v3));
		System.out.println("norm of v4 is " + SimpleVector.norm(v4));
		System.out.println("norm of v2 is " + SimpleVector.norm(v2));
		System.out.println("norm of v1 is " + SimpleVector.norm(v1));
		if ( v1.norm() == v4.norm() || v2.norm() == v4.norm()) {
			System.out.println("implementation of method is NG");
		} else {
			System.out.println("implementation of method is OK");
		}
//*/
		// extractメソッド
///*
		System.out.println("--- extract ---");
		MyVector v = new MyVector(new double[]{2.0, -3.0, 1.0, -2.5, 5.0});
		v3 = SimpleVector.extract(v);
		System.out.println("v3 is " + tos(v3));
		v = new MyVector(new double[]{2.0, -3.0});
		v4 = SimpleVector.extract(v);
		System.out.println("v4 is " + tos(v4));
//*/
	}
}