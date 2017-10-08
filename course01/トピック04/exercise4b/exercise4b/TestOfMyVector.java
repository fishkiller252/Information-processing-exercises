package exercise4b;

/**
 * @author 学籍番号 氏名
 */
public class TestOfMyVector {

	// ランダム値生成用の補助関数
	private static double randomValue() {
		return ((int)(Math.random() * 1000))/100.0;
	}

	/**
	 * MyVectorクラスのテストを行う
	 * @param args
	 */
	public static void main(String[] args) {
		// テストデータ1
		MyVector v1 = new MyVector(new double[]{2.0, -3.0, 1.0, -2.5, 5.0});

		// TODO: 各メソッドを実装次第、それぞれコメントを外して動作確認する
		// コンストラクタ、length、get
		System.out.print("v1 is (");
		for (int i = 0; i < v1.length(); i++) {
			System.out.print(" ");
			System.out.print(v1.get(i));
		}
		System.out.println(")");

		// norm
		System.out.println("norm of v1 is " + v1.norm());

		// set、get
		for (int i = 0; i < v1.length()/2; i++) {
			int loc = (int)(Math.random() * v1.length());
			double val = randomValue();
			v1.set(loc, val);
			System.out.println("v1.set(" + loc + "," + val + ")");
		}
		System.out.print("modified v1 is (");
		for (int i = 0; i < v1.length(); i++) {
			System.out.print(" ");
			System.out.print(v1.get(i));
		}
		System.out.println(")");

		// テストデータ2
		MyVector v2 = new MyVector(new double[]{2.5, 1.5, -1.0});
		System.out.print("v2 is (");
		for (int i = 0; i < v2.length(); i++) {
			System.out.print(" ");
			System.out.print(v2.get(i));
		}
		System.out.println(")");

		// テストデータ3
		double[] values = null;
		values = new double[v2.length()];
		for (int i = 0; i < values.length; i++) values[i] = randomValue();
		MyVector v3 = new MyVector(values);
		System.out.print("v3 is (");
		for (int i = 0; i < v3.length(); i++) {
			System.out.print(" ");
			System.out.print(v3.get(i));
		}
		System.out.println(")");

		// inner product
		System.out.println("v2 * v3 is " + v2.innerProduct(v3));
		System.out.println("v3 * v2 is " + v3.innerProduct(v2));

		// scalar multiply
		double multi = randomValue();
		v1.scalarMulti(multi);
		System.out.print("v1 * " + multi + " is (");
		for (int i = 0; i < v1.length(); i++) {
			System.out.print(" ");
			System.out.print(v1.get(i));
		}
		System.out.println(")");
		System.out.println("norm of (v1 * " + multi + ") is " + v1.norm());

		// テストデータ4
		values = new double[]{
				25.74754357215461, 38.00690463586847, 15.341394982204193, 10.580359162145678, 26.448379912576875, 
				29.70408726084678, 4.678803265793508, 8.086037348417332, 37.298729200872245, 35.31223017596028, 
				37.85703633408194, 25.51608120382125, 38.06489196096582, 10.241328038882457, 1.3617635624439361, 
				33.34450479464345, 12.87167432776327, 28.817272598217897, 28.248553945290723, 18.627377700578254, 
				34.22487983908782, 34.54497358516865, 34.15636983053088, 19.659664290114414, 36.2495793079037, 
				29.66333764093313, 26.282283005857767, 25.69918286638702, 31.78480139941101, 39.60739324924073, 
				6.615376028616967, 27.620253438373805, 28.54674762560527, 28.339880027974715, 11.45216136805625, 
				30.926933245958935, 20.47257677968262, 27.780453560012297, 30.023697307293787, 25.660865145197267, 
				19.818294578494893, 35.06955374680437, 25.311720605284815, 28.181383926273032, 23.349586720111343, 
				36.93399518059209, 15.732005593693387, 14.124248652583258, 37.23508023356469, 4.811652522782583, 
				22.75029670136194, 39.99077893715, 20.69600927715293, 37.520916833147886, 38.08724720953196, 
				16.84342008025686, 13.15805456745031, 5.84725576659684, 24.991998719590235, 29.156488128716738, 
				28.199829786720347, 30.87582873381701, 19.107611049003484, 38.37651365092978, 30.47191493818529, 
				28.842246791815647, 19.264890344873496, 33.30246837698371, 15.199684207245886, 23.836308439017984, 
				6.355721831546752, 21.098549713191186, 33.239975932602604, 37.92413479566805, 37.023624890061754, 
				25.09766523005676, 30.14912270697109, 27.151456682837484, 31.576421583200336, 36.61975423183504, 
				37.52104476157347, 38.74488869515565, 38.15081650502385, 38.377139028333, 38.20636596170853, 
				12.8653954467012, 18.704266892877676, 23.023779012143077, 35.40334447478091, 39.18567085045247, 
				22.981836306091818, 32.52951890206801, 36.898888872159816, 31.868404415659093, 38.20190571162648, 
				36.526330229027934, 16.928413983595746, 7.999799997499937, 11.571966125080042, 26.274276393461342, 
				5.683379276451643, 26.640300298607748, 31.525837022987986, 20.857152250487122, 36.63873360256874, 
				16.998823488700623, 37.84391100296057, 31.347829270939958, 37.485143723880796, 39.10146800313257, 
				26.111361511801714, 9.966824970872118, 32.110060728687515, 30.437240347968476, 15.824992890993665, 
				30.25235197468124, 39.60175753675587, 28.98222903780867, 15.394908249158226, 39.39299430101754, 
				30.465377069716368, 25.17049065870588, 26.477371470748373, 7.472081370006618, 38.0924559460269, 
				19.5223359258056, 18.368407660981394, 28.76700888170336, 27.410071141826684, 32.570194964107905, 
				21.027410682249965, 26.015749076280695, 23.161208949448216, 37.92723559659997, 11.770879321444088, 
				28.899273347266018, 30.077845667534103, 18.977671089994153, 16.25211370868417, 22.301928167761638, 
				39.78208642090055, 33.81973388422801, 37.46142549343257, 31.01341645159398, 23.91765874829725, 
				37.152313521502265, 38.50801475017896, 27.99659979354636, 27.080974871669593, 26.927368976563606, 
				36.45654948016885, 33.93108309500302, 18.451016232175398, 39.75651896230353, 37.69494395804297, 
				23.204861559595653, 14.134723202100563, 11.896621369111482, 36.783387554710075, 13.659516828936521, 
				33.68807504147425, 29.907537511470245, 29.290216796739486, 26.620503376157256, 33.07124430679922, 
				18.258849909016725, 20.445674359140124, 17.547649415235078, 35.29960906299105, 13.189450329714276, 
				30.521834807232676, 33.86542779886296, 39.9330439611107, 33.44753503623249, 27.913322983836945, 
				17.263788691941294, 5.633613405266642, 6.808817812219681, 31.14944622300692, 25.564193709170645, 
				20.765741017358373, 27.71229330098828, 20.8, 34.135869697431175, 35.685403178330496, 
				28.53612447407671, 33.745565634613385, 35.12070614324262, 35.47276138109352, 22.07619532437598, 
				32.38098207281552, 30.92134537823346, 39.61781417493903, 35.081140232324266, 37.12096981491728, 
				27.08561241692825
		};
		MyVector longVector = new MyVector(values);
		longVector.scalarMulti(2.5);
		System.out.println(longVector.norm());
	}
}
