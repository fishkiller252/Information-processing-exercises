package advanced2;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author 学籍番号 氏名
 *
 */
public class Prime {

	public static String primeNumbers(int n) {
		
		if (n <= 2) return "";
		
		// 素数候補を表す整数配列を用意(全部0になっている)
		int[] number = new int[n];
		
		// 指定されたアルゴリズムを用いて素数判定を行う
		
		// 配列に全ての数値を入れる
		for (int i = 0; i < n; i++) {
			number[i] = i;
		}
		
		// 素数ではない数値が入っている場所を0にする
		number[0] = 0;
		number[1] = 0;
		for (int i = 0; i < n; i++) {
			if (number[i] == 0) continue;

			for (int j = i; j * i < n; j++) {
				System.out.println(i * j);
				number[i * j] = 0;
			}
		}
		
		// 配列の0ではない数値を集める
		List<Integer> list = new ArrayList<Integer>();
		for (int num : number) {
			if (num != 0) {
				list.add(num);
			}
		}
		
		// 結果文字列を返す
		return list.toString().replace("[", "").replace("]", "");
	}
	
	public static void main(String[] args) {
		String s = primeNumbers(100000);
		System.out.println(s);
	}
}
