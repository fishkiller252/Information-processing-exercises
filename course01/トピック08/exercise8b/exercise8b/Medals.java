package exercise8b;

import java.util.Arrays;

// TODO Javaの標準的なクラスライブラリであれば必要に応じてimportしてもよい

/**
 *
 * @author 学籍番号 氏名
 *
 */
@SuppressWarnings("rawtypes")
public class Medals implements Comparable {

	// TODO privateなメンバ変数は必要に応じて追加
	private static final int GOLD = 0;
	private static final int SILVER = 1;
	private static final int BRONZE = 2;
	
	private String name;
	private int types[];	

	// TODO 課題の指示に応じてpublicコンストラクタやpublicメソッドを実装
	public Medals(String name) {
		this.name = name;
		this.types = new int[3];
	}
	
	public String getCountryName() {
		return name;
	}
	
	public void add(String type) {
		if (type.equalsIgnoreCase("Gold")) types[GOLD]++;
		if (type.equalsIgnoreCase("Silver")) types[SILVER]++;
		if (type.equalsIgnoreCase("Bronze")) types[BRONZE]++;
	}
	
	public int get(String type) {
		if (type.equalsIgnoreCase("Gold")) return types[GOLD];
		if (type.equalsIgnoreCase("Silver")) return types[SILVER];
		if (type.equalsIgnoreCase("Bronze")) return types[BRONZE];
		return -1;
	}
	
	@Override
	public String toString() {
		String medals = Arrays.toString(types).replace("[", "(").replace("]", ")").replaceAll(" ", "");
		int sum = types[GOLD] + types[SILVER] + types[BRONZE];
		return name + medals + "[" + sum + "]";
	}

	@Override
	public int compareTo(Object o) {
		try {
			Medals medal = (Medals) o;
			for (int i = 0; i < 3; i++) {
				if (medal.types[i] - this.types[i] != 0)
					return medal.types[i] - this.types[i];
			}
			return (name.compareTo(medal.getCountryName()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
