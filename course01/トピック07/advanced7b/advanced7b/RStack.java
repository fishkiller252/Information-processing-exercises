package advanced7b;

import java.util.ArrayList;

/**
 * @author 学籍番号 氏名
 */

@SuppressWarnings("serial")
public class RStack extends ArrayList<Double> {

	// TODO 課題の指定を満たすようメソッドを実装する(メンバ変数の宣言は不要)
	
	/**
	 * 実数値をスタックする
	 * @param num スタックする実数値
	 */
	public void push(double num) {
		add(num);
	}
	
	/**
	 * スタックされている実数値を取り出す
	 * @return 取り出した実数値
	 */
	public double pop() {
		double num = get(size()-1);
		remove(size()-1);
		return num;
	}
	
	/**
	 * 2項演算が可能か判定する
	 * @return (可能)-> true (不可)-> false
	 */
	public boolean available() {
		return size() >= 2;
	}
	
	@Override
	public String toString() {
		if (super.isEmpty()) return "";
		return super.toString().replaceAll(",", ")(").replaceAll(" ", "").replace("[", "(").replace("]", ")");
	}
}
