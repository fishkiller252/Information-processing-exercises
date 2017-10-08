package exercise4b;

/**
 * @author 学籍番号 氏名
 */
public class MyVector {

	/**
	 * n次元ベクトルを格納するdouble配列
	 */
	private double[] x = null;

    /**
     * コンストラクタ
     * @param x 格納するn次元ベクトルを表すdouble配列
     */
    public MyVector(double[] x) {
    	this.x = x.clone();
    }

    // 以下に各メソッドを実装する

    /**
     * ベクトルの次数(要素数)を返す
     * @return ベクトルの次数
     */
    // TODO: メソッドlengthを作成する
    public int length() {
    	return x.length;
    }
    
    
    /**
     * ベクトルの成分を設定する(範囲外のiが指定された場合の考慮不要)
     * @param loc 設定する場所(0～x.length-1)
     * @param val 設定する値（配列ではなく，doubleの数値）
     */
    // TODO: メソッドsetを作成する
    public void set(int loc, double val) {
    	x[loc] = val;
    }
    
    
    /**
     * ベクトルの成分を取り出す(範囲外のiが指定された場合の考慮不要)
     * @param loc 取り出す成分の場所(0..x.length-1)
     * @return 取り出した成分
     */
    // TODO: メソッドgetを作成する
    public double get(int loc) {
    	return x[loc];
    }
    
    
    /**
     * ベクトルのノルムを計算する
     * @return ノルム
     */
    // TODO: メソッドnormを作成する
    public double norm() {
    	double sum = 0;
    	for (double num : x) {
    		sum += num * num;
    	}
    	return Math.sqrt(sum);
    }
    
    
    /**
     * 内積を計算する
     * @param v 計算に用いるベクトル
     * @return 内積
     */
    // TODO: メソッドinnerProductを作成する
    public double innerProduct(MyVector v) {
    	double sum = 0;
    	for (double xnum : x) {
    		for (double vnum : v.x) {
    			sum += xnum * vnum;
    		}
    	}
    	return sum;
    }
    
    
    /**
     * スカラ倍する
     * @param k 実数
     */
    // TODO: メソッドscalarMultiを作成する
    public void scalarMulti(double k) {
    	for (int i = 0; i < x.length; i++) {
    		set(i, get(i) * k);
    	}
    }
    
    
}
