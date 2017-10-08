package exercise7b;

import java.util.ArrayList;

/**
 * @author 学籍番号 氏名
 */
public class Union {

	/**
	 * a, bを重複集合と見立てて、その和を返す
	 * @param a 集合(数値の大きい順)
	 * @param b 集合(数値の大きい順)
	 * @return 集合aと集合bの和集合(数値の大きい順)
	 */
	public static ArrayList<Integer> union(ArrayList<Integer> a, ArrayList<Integer> b) {
		ArrayList<Integer> union = new ArrayList<Integer>();
		int index_a = 0;
		int index_b = 0;
		
		/* マージソートをするぞ！ */
		
		while (index_a != a.size() && index_b != b.size()) {
			union.add((a.get(index_a) >= b.get(index_b)) ? a.get(index_a++) : b.get(index_b++));
		}
		
		while (index_a != a.size()) {
			union.add(a.get(index_a++));
		}
		
		while (index_b != b.size()) {
			union.add(b.get(index_b++));
		}
		
		return union;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> v1 = new ArrayList<Integer>();
		v1.add(35);
		v1.add(20);
		v1.add(3);
		v1.add(2);

		ArrayList<Integer> v2 = new ArrayList<Integer>();
		v2.add(18);
		v2.add(5);
		v2.add(3);
		ArrayList<Integer> result = union(v1, v2);
		System.out.println(result);
	}
}