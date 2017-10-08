package javaintro;

/**
 * 
 * @author 学籍番号 氏名
 *
 */
public class Sequence {

/**
* 次のように計算した値を返す
* n=0 のとき 0 を返す
* n=1 のとき a を返す
* n>1 のとき、次のように定義される数列のn項を返す
* A(0)=0, A(1)=a, A(n)=A(n-1)+A(n-2)
* ただし、結果がintの範囲を超える場合は数学的に正しい値を返せなくても良い
* @param a A(1)の値
* @param n 求めたい項の番号
* @return A(n)の値
*/

	public static int value(int a, int n) {
		if (n == 0) return 0;
		if (n == 1) return a;
		
		int[] list = new int[n + 1];
		
		list[0] = 0;
		list[1] = a;
		
		for (int i = 2; i <= n; i++) {
			list[i] = list[i - 1] +  list[i - 2];
		}
		
		return list[n];
	}

	public static void main(String[] args) {
		for (int i = 0; i < 44; i++) {
			System.out.print(value(3, i));
			System.out.print(" ");
		}
		System.out.println("");
	}

}