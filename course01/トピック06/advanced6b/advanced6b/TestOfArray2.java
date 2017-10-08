package advanced6b;

import java.util.Random;

/**
 * 
 * @author 学籍番号 氏名
 * 
 */
public class TestOfArray2 {

	// IntArrayクラスの動作確認用
	public static void main(String[] args) {

		// サンプルデータを代入して、表示してみる
		IntArray a = new IntArray();
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
		// toStringを使って表示してみる
		System.out.println(a.toString());
		// 明示的にtoStringを呼ばなくても同じものが表示できる
		System.out.println(a);

		IntArray b = new IntArray();
		int emptyhash = b.hashCode();
		// 要素なし配列とnullのequals
		System.out.print(b);
		System.out.print(b.equals(null) ? "==" : "!=");
		System.out.println("null");
		// 要素あり配列と要素なし配列のequals
		System.out.print(a);
		System.out.print(a.equals(b) ? "==" : "!=");
		System.out.println(b);
		// 異なる順番に代入された同じ中身の配列のequals
		b.set(10, 51);
		b.set(2, 2);
		b.set(21, 35);
		b.set(0, 5);
		b.set(32, 102);
		b.set(1, 3);
		int bhash = b.hashCode();
		System.out.print(a);
		System.out.print(a.equals(b) ? "==" : "!=");
		System.out.println(b);
		// 要素あり配列とnullのequals
		System.out.print(b);
		System.out.print(b.equals(null) ? "==" : "!=");
		System.out.println("null");
		// 中身の異なる配列のequals
		b.set(5, -10);
		System.out.print(a);
		System.out.print(a.equals(b) ? "==" : "!=");
		System.out.println(b);

		System.out.println("aのハッシュコード:" + a.hashCode());
		System.out.println("bが空のときのハッシュコード:" + emptyhash);
		System.out.println("bがaと同じ中身のときのハッシュコード:" + bhash);
		System.out.println("bがaと中身が異なるときのハッシュコード:" + b.hashCode());
	}
}
