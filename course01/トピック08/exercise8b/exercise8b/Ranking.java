package exercise8b;

//TODO Javaの標準的なクラスライブラリであれば必要に応じてimportしてもよい
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author 学籍番号 氏名
 *
 */
public class Ranking {

	// TODO privateなメンバ変数は必要に応じて追加
	// TODO Tには適切なクラス名を記述
	private ArrayList<Medals> results;

	public Ranking() {
		// TODO 必要な処理があれば追加
		results = new ArrayList<Medals>();
	}

	/**
	 * 指定された国のメダル情報がresultsに格納されているか探し、あればそれを返す
	 * @param country 国(3文字のIOCコード)
	 * @return countryで指定された国のMedals情報、なければnull
	 */
	public Medals getMedals(String country) {
		if (results.isEmpty()) return null;
		for (Medals medal : results)
			if (medal.getCountryName().equals(country))
				return medal;
		return null;
	}

	/**
	 * IOCコードで指定された国に，指定された色のメダルを1つ追加する
	 * @param country 国(3文字のIOCコード)
	 * @param medal メダルの色("Gold", "Silver" または "Bronze")
	 */
	public void winMedal(String country, String medal) {
		if (getMedals(country) == null) {
			results.add(new Medals(country));
		}

		getMedals(country).add(medal);
	}

	/**
	 * 国別の各色メダル獲得数の集計結果を、MedalsクラスのcompareToメソッドに基づいて並び替え、ArrayListで返す
	 * @return 集計結果(何もない場合は中身が空のArrayListインスタンス)
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Medals> getResults() {
		Collections.sort(results);
		return results;
	}

}
