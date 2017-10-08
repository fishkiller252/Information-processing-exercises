package unigram;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author b1013236 齊藤正宏
 */
public class Unigram {

	// メンバ変数 (新たに増やしてはならない)
	private HashMap<String, Integer> frequency;
	private int totalCount;

	/**
	 * 引数なしコンストラクタ
	 */
	// TODO: メンバ変数を初期化するよう実装
	public Unigram() {
		this.frequency = new HashMap<String, Integer>();
		this.totalCount = 0;
	}

	/**
	 * コンストラクタ
	 * ArrayListで与えられたテキストデータの各要素(各行)を
	 * processSingleSentenceメソッドに渡して処理させる。
	 * 例えば、
	 * 	This exercise is to learn how to use HashSet and HashMap classes .
	 * 	Coding skills are essential for engineers .
	 * というデータが与えられた場合、processSingleSentenceメソッドを2回呼び出す。
	 * @param ary 読み込み対象のテキストデータ
	 */
	public Unigram(ArrayList<String> ary){
		this(); // 引数なしコンストラクタを呼ぶ(ここは変更不要)

		// TODO: processSingleSentenceメソッドを呼び出して各要素を処理させる。
		for (String str : ary) {
			processSingleSentence(str);
		}
	}
	
	public Unigram(File file) throws IOException {
		this(new InputStreamReader(new FileInputStream(file)));
	}
	
	public Unigram(InputStreamReader reader) throws IOException {
		this();
		
		BufferedReader in = new BufferedReader(reader);
		ArrayList<String> ret = new ArrayList<String>();
		String s;

		while ((s = in.readLine()) != null) {
			ret.add(s);
		}
		
		in.close();
		
		for (String str : ret) {
			processSingleSentence(str);
		}
	}

	/**
	 * 与えられた文字列中の各語を frequency に登録し、処理した語数を totalCount に加算する。
	 * 例えば、コンストラクタの上で示している例の場合、
	 * 2回のループの各回で、13個の文字列要素、7個の文字列要素を処理することになる。
	 * @param s 処理対象の文字列
	 */
	private void processSingleSentence(String s) {
		// TODO: 1. 与えられた文字列をスペースで区切って文字列クラスの配列に格納する。
		String[] words = s.split(" ");

		// TODO: 2. 配列中の各語を frequency に登録する。
		// すでに登録されている場合と、初出の語の場合では処理が異なるが、
		// 下記の getFrequency メソッドを用いると簡単に記述できる。
		int count = 0;
		for (String word : words) {
			int num = getFrequency(word);
			frequency.put(word, ++num);
			count++;
		}

		// TODO: 3. 処理した語数を totalCount に加算する。
		totalCount += count;
	}

	/**
	 * 処理したテキストデータの総語数を返す
	 * @return 処理したテキストデータの総語数
	 */
	// TODO: getTotalCountメソッドを実装する
	public int getTotalCount() {
		return totalCount;
	}

	/**
	 * 処理したテキストデータにおける語の種類数(異なり数,集合の濃度)を返す
	 * @return 処理したテキストデータにおける語の種類数(異なり数,集合の濃度)
	 */
	// TODO: cardinalityメソッドを実装する
	public int cardinality() {
		return frequency.size();
	}

	/**
	 * 指定された語の出現回数(一度も出現していなければ0)を返す。
	 * @param w 検索する語
	 * @return wの出現回数
	 */
	public int getFrequency(String w) {
		if (frequency.containsKey(w)) return frequency.get(w);
		return 0;
	}

	/**
	 * 登録済の語の昇順で、その語と出現回数を印字する。
	 * (デバッグに活用せよ)
	 */
	public String toString() {
		String[] words = frequency.keySet().toArray(new String[0]);
		Arrays.sort(words);
		StringBuffer sb = new StringBuffer();
		for (String w : words) {
			sb.append(w);
			sb.append("¥t");
			sb.append(frequency.get(w));
		}
		return sb.toString();
	}

	/**
	 * 複数の Unigram オブジェクトに登録されているすべての語を、
	 * 表形式で出力するstaticメソッド
	 * @param ary 印字対象の複数の Unigram オブジェクトを格納した ArrayList
	 */
	public static void printWordTable(ArrayList<Unigram> ary) {
		// TODO: 1. 与えられた ArrayList のすべての Unigram のキーの集合を作る
		// ヒント: HashSet を用いる。
		Set<String> set = new HashSet<String>();
		for (Unigram uni : ary) {
			set.addAll(uni.frequency.keySet());
		}

		// TODO: 2. キーの集合をソートする
		String[] strings = new String[set.size()];
		set.toArray(strings);
		Arrays.sort(strings);


		// TODO: 3. 各キーについて、ArrayListの各 Unigram における頻度を並べて出力する
		for (String word : strings) {
			System.out.print(word);
			for (Unigram uni : ary) {
				System.out.print("\t" + uni.getFrequency(word));
			}
			System.out.println("");
		}
	}
	
	/**
	 * 格納されている単語頻度情報に、
	 * 引数で指定されたUnigramインスタンスに含まれる単語頻度を加算する。
	 * @param u 加算するUnigramインスタンス
	 */
	public void add(Unigram u) {
		for (String key : u.frequency.keySet()) {
			/* お互いの語数の合計を求める */
			int value = getFrequency(key)+ u.getFrequency(key);
			frequency.put(key, value);
		}
		/* 語の数も合計を求める */
		totalCount += u.getTotalCount();
	}
	
	/**
	 * 複数の Unigram オブジェクトに登録されている全ての語を、
	 * 表形式で output へ出力する static メソッド
	 * @param ary 印字対象の複数の Unigram オブジェクトを格納した ArrayList
	 * @param output 出力対象の OutputStream
	 * @throws IOException
	 */
	public static void outputWordTable(ArrayList<Unigram> ary,
			OutputStream output) throws IOException {
		
		/* 出現する語のセットを作る */
		Set<String> set = new HashSet<String>();
		for (Unigram uni : ary) {
			set.addAll(uni.frequency.keySet());
		}

		/* 語のセットを配列にしソートする */
		String[] strings = new String[set.size()];
		set.toArray(strings);
		Arrays.sort(strings);

		/* 書き出し用のインスタンスを生成する */
		PrintWriter writer = new PrintWriter(output);

		/* 各語の出現頻度を各Unigram毎に表示する */
		for (String word : strings) {
			writer.print(word);
			for (Unigram uni : ary) {
				writer.print("\t" + uni.getFrequency(word));
			}
			writer.println();
		}
		writer.flush();
		writer.close();
	}
	
	public static void main(String[] args) {
	    OutputStream output = System.out;
	    ArrayList<Unigram> inputs = new ArrayList<Unigram>();
	    for (int i = 0; i < args.length; i++) {
	        if ("-o".equals(args[i])) {
	            if (i + 1 < args.length) {
	                try {
	                    output = new FileOutputStream(args[++ i]);
	                } catch (Exception e) {
	                    output = System.out; // エラーがあれば標準出力
	                }
	            }
	        } else {
	            try {
	                inputs.add(new Unigram(new File(args[i])));
	            } catch (IOException e) {
	                e.printStackTrace(); // エラーのあったファイルは無視
	            }
	        }
	    }
	    if (inputs == null || inputs.size() == 0) {
	        System.out.println("Unigram -o output input1, input2, ...");
	    } else {
	        try {
	            outputWordTable(inputs, output);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	public HashMap<String, Integer> getFrequencies() {
		return frequency;
	}
}
