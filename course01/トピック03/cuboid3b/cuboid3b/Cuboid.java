package cuboid3b;

/**
 * 
 * @author 学籍番号 氏名
 *
 */
public class Cuboid {
	
	/**
	 * 指定された2頂点を対角とする直方体の3辺の長さを求め、double型の配列で返す
	 * @param p1 直方体の頂点
	 * @param p2 p1と対角になる直方体の頂点
	 * @return 直方体の3辺の長さを含む配列（順に，x, y, z軸に沿った辺）
	 */
	public static double[] edgeLength(Point p1, Point p2) {
		double[] edge = new double[3];
		
		final int X = 0;
		final int Y = 1;
		final int Z = 2;

		edge[X] = Math.abs(p1.x - p2.x);
		edge[Y] = Math.abs(p1.y - p2.y);
		edge[Z] = Math.abs(p1.z - p2.z);
		
		return edge;
	}
	
	/**
	 * 指定された2頂点を対角とする直方体の表面積を求めて返す
	 * @param p1 直方体の頂点
	 * @param p2 p1と対角になる直方体の頂点
	 * @return 直方体の両側面と底面の表面積（配列）
	 */
	public static double[] surfaceArea(Point p1, Point p2) {
	    double[] area = new double [3];
	    
		final int YZ = 0;
		final int XZ = 1;
		final int XY = 2;
		
		double[] edge = Cuboid.edgeLength(p1, p2);
		double x = edge[0];
		double y = edge[1];
		double z = edge[2];
		
		area[YZ] = y * z;
		area[XZ] = x * z;
		area[XY] = x * y;

	    return area;
	}

	/**
	 * 指定された2頂点を対角とする直方体の体積を求めて返す
	 * @param p1 直方体の頂点
	 * @param p2 p1と対角になる直方体の頂点
	 * @return 直方体の体積
	 */
	public static double volume(Point p1, Point p2) {
		double[] edge = Cuboid.edgeLength(p1, p2);
		double x = edge[0];
		double y = edge[1];
		double z = edge[2];
		
		return x * y * z;
	}
	
	/**
	 * メインメソッド
	 * @param args
	 */
	public static void main(String[] args) {
		// 直方体の対角の2頂点(サンプル)
		Point p1 = new Point(-1.0, -1.0, -1.0);
		Point p2 = new Point( 2.0, 10.0, -5.0);

		// 3辺の長さを求めて表示
		double[] edge = edgeLength(p1, p2);
		System.out.println(edge[0] + ":" + edge[1] + ":" + edge[2]);

		// 表面積を表示
		double[] area = surfaceArea(p1, p2);
		System.out.println(area[0] + ":" + area[1] + ":" + area[2]);

		// 体積を表示
		double volume = volume(p1, p2);
		System.out.println(volume);
	}
}
