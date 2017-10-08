package advanced4;

/**
 * @author 学籍番号 氏名
 */
public class TestOfArray {

	// IntArrayクラスの動作確認用
	public static void main(String[] args) {

		IntArray a = new IntArray();

		// インスタンス生成直後のgetLength
		System.out.print("getLength() for empty array is ");
		if (a.getLength() == 0) {
			System.out.println("OK");
		} else {
			System.out.println("NG");
		}

		// 代入していない要素に対するget
		System.out.print("get() for unassigned element is ");
		int flag = 0;
		for (int i = 0; i < 100; i++) {
			if (a.get((int)(Math.random() * 200)) != 0) flag ++;
		}
		if (flag == 0) {
			System.out.println("OK");
		} else {
			System.out.println("NG");
		}

		// getだけした後のgetLength
		System.out.print("getLength() after get() is ");
		if (a.getLength() == 0) {
			System.out.println("OK");
		} else {
			System.out.println("NG");
		}

		// setしたものをgetできるか
		flag = 0;
		int max = -1;
		System.out.print("get() after set() is ");
		for (int i = 0; i < 20; i++) {
			int d = (int)(Math.random() * 300);
			int n = (int)(Math.random() * 10000);
			System.out.println("index:" + d + ", value:" + n);
			a.set(d, n);
			if (d > max) max = d;
			if (n != a.get(d)) {
				System.out.println("index:" + d + ", value:" + n + ", get():" + a.get(d));
				flag ++;
			}
		}
		if (flag == 0) {
			System.out.println("OK");
		} else {
			System.out.println("NG");
		}

		// setした後のgetLength
		System.out.print("getLength() after set() is ");
		if (a.getLength() == max + 1) {
			System.out.println("OK");
		} else {
			System.out.println("NG");
		}

		// サンプルデータを代入して、表示してみる (1)
		System.out.print("sample1: ");
		a = new IntArray();
		a.set(0, 5);
		a.set(1, 3);
		a.set(2, 2);
		a.set(10, 51);
		a.set(21, 35);
		a.set(32, 102);
		for (int i = 0; i < a.getLength(); i++) {
			System.out.print(a.get(i));
			System.out.print(" ");
		}
		System.out.println("");

		// サンプルデータを代入して、表示してみる (2)
		System.out.print("sample2: ");
		a = new IntArray();
		int[] indexa = new int[199];
		for (int i = 0; i < indexa.length; i++) {
			indexa[i] = (int)(Math.random() * Integer.MAX_VALUE);
			int value = (int)(Math.random() * Integer.MAX_VALUE);
			a.set(indexa[i], value);
		}
		for (int i = 0; i < indexa.length; i++) {
			System.out.print("a[");
			System.out.print(indexa[i]);
			System.out.print("]=");
			System.out.print(a.get(indexa[i]));
			System.out.print(" ");
		}
		System.out.println("");
	}

}
