package exercise8b;

import java.util.ArrayList;

/**
 *
 * @author 学籍番号 氏名
 *
 */
public class Competition {

	/**
	 * 動作確認用のmainメソッド
	 * @param args
	 */
	public static void main(String[] args) {
		// Rankingインスタンスを作成
		Ranking rank = new Ranking();
		// サンプルデータを登録
		rank.winMedal("ITA","Bronze");
		rank.winMedal("NOR","Bronze");
		rank.winMedal("CAN","Silver");
		rank.winMedal("CZE","Silver");
		rank.winMedal("RUS","Silver");
		rank.winMedal("RUS","Gold");
		rank.winMedal("AUT","Silver");
		rank.winMedal("CAN","Gold");
		rank.winMedal("KOR","Silver");
		rank.winMedal("NED","Bronze");
		rank.winMedal("NOR","Bronze");
		rank.winMedal("NOR","Gold");
		rank.winMedal("USA","Gold");
		rank.winMedal("NED","Bronze");
		rank.winMedal("KOR","Gold");
		rank.winMedal("RUS","Bronze");
		rank.winMedal("NOR","Gold");
		rank.winMedal("NED","Gold");
		rank.winMedal("RUS","Silver");
		rank.winMedal("NOR","Silver");
		rank.winMedal("USA","Bronze");
		rank.winMedal("CAN","Gold");
		rank.winMedal("GER","Gold");
		rank.winMedal("CAN","Bronze");
		rank.winMedal("USA","Silver");
		rank.winMedal("CAN","Silver");
		rank.winMedal("USA","Bronze");
		rank.winMedal("GER","Gold");
		rank.winMedal("SUI","Silver");
		rank.winMedal("GER","Silver");
		rank.winMedal("GER","Bronze");
		rank.winMedal("AUT","Gold");
		rank.winMedal("RUS","Bronze");
		rank.winMedal("AUT","Silver");
		rank.winMedal("AUT","Bronze");
		rank.winMedal("FRA","Gold");
		rank.winMedal("NED","Silver");
		rank.winMedal("FRA","Bronze");
		rank.winMedal("CHN","Gold");
		rank.winMedal("CHN","Silver");
		rank.winMedal("BLR","Gold");
		rank.winMedal("FRA","Silver");
		rank.winMedal("SUI","Gold");
		rank.winMedal("USA","Gold");
		rank.winMedal("RUS","Gold");
		rank.winMedal("POL","Gold");
		rank.winMedal("JPN","Silver");
		rank.winMedal("JPN","Bronze");
		rank.winMedal("SWE","Silver");
		rank.winMedal("SWE","Bronze");
		rank.winMedal("NED","Gold");
		rank.winMedal("FIN","Silver");
		rank.winMedal("RUS","Gold");
		rank.winMedal("SLO","Bronze");
		// 集計結果を取得
		ArrayList<Medals> results = rank.getResults();
		// 集計結果を表示
		for (int i = 0; i < results.size(); i++) {
			System.out.println(results.get(i));
		}

		// いくつかの国のメダル獲得状況を確かめる
		String[] countries = {"SWE", "GER", "DEN", "JPN", "GBR"};
		for(String country : countries){
			if(rank.getMedals(country) == null) {
				System.out.println(country + " did not win medals");
			} else {
				System.out.println(country + " won some medals");
			}
		}
	}

}
