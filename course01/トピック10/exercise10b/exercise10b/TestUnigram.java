package exercise10b;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * @author 学籍番号 氏名
 *
 */
public class TestUnigram {

	/**
	 * テキストデータを含むファイルを生成する。
	 * @return 生成したテキストデータを含むファイル
	 * @throws IOException
	 */
	private static File generateArrayText1() throws IOException {
		File file = new File("text1.txt");
		PrintWriter out = new PrintWriter(new FileWriter(file));

		// 簡易テスト用
//		out.println("a b");

		// 前回の問題と同一のチェック用
		out.println("情報 科学 は 、 学問 全体 の 歴史 から 見れ ば とても 新しい 研究 分野 です 。");
		out.println("日本 で は 1970 年代 から 、 全国 の 大学 で 相次い で 情報 科学 の 学部 ・ 学科 が 設置 さ れ て き まし た 。");
		out.println("当初 から 情報 科学 は 「 文系 と 理工 系 の 融合 」 による 学際 領域 という こと が うたわ れ て き まし た が 、 コンピュータ や 半導体 の 急速 な 進歩 の 中 で 、 研究 や 教育 に 求め られ て き た もの は 、 社会 の 即 戦力 と なる 高度 な 理工 系 の 科学 技術 で あり 、 文理 融合 による 情報 科学 の 創成 という 理想 像 は なかなか 実現 さ れ て き ませ ん でし た 。");
		out.println("そんな 中 で 、 はこ だ て 未来 大学 は 、 この 古く て 新しい 情報 科学 の 創成 に 挑戦 する 大学 として 誕生 し まし た 。");
		out.println("これ まで の 「 計算 機 中心 」 「 機械 中心 」 の 情報 科学 ・ 情報 技術 と は 一線 を 画する 、 「 人間 ・ 社会 ・ 環境 」 を 中心 に 据え た コンピューティング の 学問 体系 を 構築 し 、 人間 と 社会 、 さらに は 地球 環境 を 希望 ある 未来 、 幸福 な 未来 へ 導い て いく ため の 情報 科学 を 創成 する こと 、 この 新しい 情報 科学 の 素養 を 備え た 若い 世代 を 世に 送り出し て いく こと を みずから の 使命 と し て い ます 。");

		out.close();
		return file;
	}

	/**
	 * テキストデータを含むファイルを生成する。
	 * @return 生成したテキストデータを含むファイル
	 * @throws IOException
	 */
	private static File generateArrayText2() throws IOException {
		File file = new File("text2.txt");
		PrintWriter out = new PrintWriter(new FileWriter(file));

		// 簡易テスト用
//		out.println("a 1 2");

		// 前回の問題と同一のチェック用
		out.println("「 新しい 酒 は 新しい 皮 袋 に 」 という 格言 が あり ます 。");
		out.println("新しい 思想 や 内容 に は 新しい 形式 が 必要 で ある という 意味 です 。");
		out.println("はこ だ て 未来 大学 も 、 2000 年 の 建 学 に 先立っ て 、 新しい 学問 の ため の 新しい 教育 と 研究 の 環境 を 準備 する こと に 力 を 注ぎ まし た 。");
		out.println("本来 、 4 年間 の 大学 生活 で の 「 学び 」 という もの は 、 教室 で の 講義 だけ で は なく 、 人 と の 協同 作業 や 、 教師 や 仲間 といった コミュニティ の 中 で の さまざま な 共有 体験 （ 課外 活動 や おしゃべり など も 含め て ） を通して 体得 さ れ て いく もの です 。");
		out.println("自分 の 未知 なる 可能 性 を 探り当て 、 育て て いく に は 、 人 や 環境 と の 関係 が 必要 な の です 。");
		out.println("世界 から 孤立 し て 、 周囲 と なん の 交渉 も なし に 成長 できる 人間 など 、 この世 に は 存在 し ませ ん 。");
		out.println("こうした 考え方 の もと で 、 「 オープン スペース 、 オープン マインド 」 を 目標 に 掲げ た 環境 づくり が 目指さ れ まし た 。");
		out.println("できるだけ 壁 を 取り払い 、 大きな 空間 で 構成 する とともに 、 講義 室 や 教員 の 研究 室 の 壁 は 透明 に し て 、 誰 でも いつ でも 外 から 中 の 様子 が 分かる よう に し まし た 。");
		out.println("物理 的 な 開放 感 を 実現 する だけ の オープン スペース なら 、 他 でも さまざま 試み られ て おり 、 珍しく あり ませ ん 。");
		out.println("もう 一つ の 大切 な 目標 が 、 学習 を通じて 常に 開放 的 な コミュニケーション が 行わ れる 、 オープン マインド な 風土 の 醸成 です 。");
		out.println("入念 に 計画 さ れ た 本学 独自 の 教育 プログラム （ プロジェクト 学習 、 コミュニケーション 教育 、 ポートフォリオ … ） こそ が 、 この オープン マインド の 揺るぎない 基盤 と なり 、 オープン スペース に 有機 的 な 活力 を 吹き込ん で き まし た 。");
		out.println("オープン スペース と オープン マインド ―― 言い換えれ ば 、 ハード と ソフト が 分かち がたく 融合 し た 「 学び と 成長 の ため の 場 」 が 、 ここ に は あり ます 。");

		out.close();
		return file;
	}

	/**
	 * 動作確認用のmainメソッド
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			File text1 = generateArrayText1();
			File text2 = generateArrayText2();
			// テキストデータ中の語ごとの出現回数を集計する
			Unigram d1 = new Unigram(text1);
			Unigram d2 = new Unigram(new FileReader(text2));

			// addメソッドを使ってtext1とtext2の結果を合わせたUnigramを作成
			Unigram d3 = new Unigram(new FileReader(text1));
			d3.add(d2);

			// 各テキストデータの総語数
			System.out.println("## Total frequency of words");
			System.out.println("## text1: " + d1.getTotalCount());
			System.out.println("## text2: " + d2.getTotalCount());
			System.out.println("## text3: " + d3.getTotalCount());
			// 各テキストデータにおける語の種類数(異なり数,集合の濃度)
			System.out.println("## Cardinality");
			System.out.println("## text1: " + d1.cardinality());
			System.out.println("## text2: " + d2.cardinality());
			System.out.println("## text3: " + d3.cardinality());

			// 3つの Unigram オブジェクトに格納されている語の出現頻度を表形式で出力する
			ArrayList<Unigram> list = new ArrayList<Unigram>();
			list.add(d1);
			list.add(d2);
			list.add(d3);

			// ファイル出力を実装する前は以下で確認
			Unigram.printWordTable(list);

			// ファイル出力を実装したのちは以下で確認
			Unigram.outputWordTable(list, System.out);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
