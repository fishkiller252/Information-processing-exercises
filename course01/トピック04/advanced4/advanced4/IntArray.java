package advanced4;

/**
 * @author 学籍番号 氏名
 */
public class IntArray {
	/**
	 * 仮想配列の添え字を格納するための配列
	 */
	private int[] indexArray;

	/**
	 * 仮想配列の値を格納するための配列
	 */
	private int[] valueArray;

	/**
	 * コンストラクタ
	 */
	public IntArray() {
		// indexArrayとvalueArrayを初期化し、indexArrayにはすべて -1 を代入
		indexArray = new int[200];
		valueArray = new int[200];
		for (int i = 0; i < indexArray.length; i++) indexArray[i] = -1;
	}

	/**
	 * 仮想配列への要素代入
	 * @param index 代入箇所の添え字
	 * @param value 代入する値
	 */
	public void set(int index, int value) {
		
		/* indexArrayを線形探索 */
		for (int i = 0; i < indexArray.length; i++) {
			
			/* indexが同じだった場合に更新する */
			if (indexArray[i] == index) {
				valueArray[i] = value;
				return;
			}
			
			/* indexArrayの最後に到達したらそこに代入する */
			if (indexArray[i] == -1) {
				indexArray[i] = index;
				valueArray[i] = value;
				return;
			}
		}
	}

	/**
	 * 仮想配列からの要素取り出し
	 * @param index 取り出す箇所の添え字
	 * @return 取り出した値
	 */
	public int get(int index) {
		
		/* indexArrayを線形探索 */
		for (int i = 0; i < indexArray.length; i++) {
			
			/* 同じindexが見つかった場合にvalueを返す */
			if (indexArray[i] == index) {
				return valueArray[i];
			}
		}
		
		/* indexが見つからなかった場合に0を返す */
		return 0;
	}

	/**
	 * 仮想配列に格納されている要素の添え字の最大値+1を返す
	 * @return 添え字の最大値+1
	 */
	public int getLength() {
		int max = -1;
		
		/* 最大値を探すよ */
		for (int i : indexArray) {
			max = Math.max(max, i);
		}
		
		return max + 1;
	}
}
