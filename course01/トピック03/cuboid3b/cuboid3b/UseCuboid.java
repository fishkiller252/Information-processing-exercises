package cuboid3b;


/**
 * 
 * @author 学籍番号 氏名
 *
 */
public class UseCuboid {
	
	/**
	 * 指定された複数の頂点のうち、異なるどの2頂点を対角として使えば体積が最小の直方体となるかを求め、その体積を返す
	 * @param points 複数の頂点を示すPoint型の配列
	 * @return points中の2点から作られる最小直方体の体積 (pointsの頂点の個数が2個未満の場合は0.0を返す)
	 */
	public static double minVolume(Point[] points) {
		if (points.length < 2) {
			return 0.0;
		}
		
		double minVolume = Double.MAX_VALUE;

		for (Point point1 : points) {
			for (Point point2 : points) {
				double volume = Cuboid.volume(point1, point2);
				
				if (point1.equals(point2)) {
					continue;
				}
				
				minVolume = Math.min(volume, minVolume);
			}
		}
		
		return minVolume;
	}

	/**
	 * 指定された複数の頂点のうち、異なるどの2頂点を対角として使えば対角線が最短の直方体となるか求め、その対角線の長さを返す
	 * @param points 複数の頂点を示すPoint型の配列
	 * @return points中の2点から作られる対角線最短の直方体の対角線長 (pointsの頂点の個数が2個未満の場合は0.0を返す)
	 */
	public static double minDiagonal(Point[] points) {
		if (points.length < 2) {
			return 0.0;
		}
		
	    double minDiagonal = Double.MAX_VALUE;
	    
	    for (Point point1 : points) {
	    	for (Point point2 : points) {
	    		double diagonal = Point.distance(point1, point2);
	    		
	    		if (point1.equals(point2)) {
					continue;
				}
	    		
	    		minDiagonal = Math.min(diagonal, minDiagonal);
	    	}
	    }

	    return minDiagonal;
	}
	
	/**
	 * 指定された複数の頂点のうち、異なるどの2頂点を対角として使えば体積が最小の直方体となるか求め、その2点を返す
	 * @param points 複数の頂点を示すPoint型の配列
	 * @return points中の頂点のうち体積最小の直方体を作る2点 (pointsの頂点の個数が2個未満の場合はnullを返す)
	 */
	public static Point[] minVolumePoints(Point[] points) {
		if (points.length < 2) {
			return null;
		}
		
		Point[] minPoints = new Point[2];
		double minVolume = Double.MAX_VALUE;
		
		
		for (Point point1 : points) {
			for (Point point2 : points) {
				if (point1.equals(point2)) {
					continue;
				}
				
				double volume = Cuboid.volume(point1, point2);
				double min = Math.min(minVolume, volume);
				
//				System.out.println("volume: " + volume);
//				System.out.println("min: " + min);
				
				if (min == volume) {
					minVolume = min;
					minPoints[0] = point2;
					minPoints[1] = point1;
				}
			}
		}
		
	    return minPoints;
	}

	/**
	 * 指定された複数の頂点のうち、異なるどの2頂点を対角として使えば対角線が最短の直方体となるか求め、その2点を返す
	 * @param points 複数の頂点を示すPoint型の配列
	 * @return points中の頂点のうち対角線最短の直方体を作る2点 (pointsの頂点の個数が2個未満の場合はnullを返す)
	 */
	public static Point[] minDiagonalPoints(Point[] points) {
		if (points.length < 2) {
			return null;
		}
		
		Point[] minPoints = new Point[2];
		double minDiagonal = UseCuboid.minDiagonal(points);
		
		for (Point point1 : points) {
			for (Point point2 : points) {
				if (point1.equals(point2)) {
					continue;
				}
				
				if (minDiagonal == Point.distance(point1, point2)) {
					minPoints[0] = point2;
					minPoints[1] = point1;
				}
			}
		}
		
	    return minPoints;
	}
	
	public static void main(String[] args) {
//		// 10個の頂点を用意(サンプル)
//		Point[] pps = new Point[]{
//	        new Point(6.1,8.1,2.1), new Point(0.2,3.2,6.2), new Point(8.3,6.3,7.3),
//	        new Point(1.4,9.4,8.4), new Point(5.5,7.5,9.5), new Point(0.6,5.6,5.6),
//	        new Point(1.7,2.7,2.7), new Point(7.8,0.8,5.8), new Point(0.9,2.9,9.9),
//	        new Point(1.0,9.0,2.0)};
//
//		// 10個の頂点のうちの2点で作られる直方体の最小体積を表示
//		double minVolume = minVolume(pps);
//		System.out.println(minVolume);
//
//		// 10個の頂点のうちの2点で作られる直方体の最短の対角線を表示
//		double minDiagonal = minDiagonal(pps);
//		System.out.println(minDiagonal);
//		
//		/* 課題2-2の確認用処理 */
//        // 10個の頂点のうちの体積最小の直方体を形作る2点を表示
//        Point[] pv = minVolumePoints(pps);
//        if (pv == null) {
//            System.out.println("no min volume points");
//        } else {
//            for (int i = 0; i < 2; i++) {
//            	System.out.print("(" + pv[i].x + "," + pv[i].y + "," + pv[i].z + ")");
//            }
//            System.out.println("");
//        }
//
//        // 10個の頂点のうちの対角線最短の直方体を形作る2点を表示
//        Point[] pd = minDiagonalPoints(pps);
//        if (pd == null) {
//            System.out.println("no max diagonal points");
//        } else {
//            for (int i = 0; i < 2; i++) System.out.print("(" + pd[i].x + "," + pd[i].y + "," + pd[i].z + ")");
//            System.out.println("");
//        }
//        
        Point[] test = new Point[] {
        	new Point(35.878, 99.208, 65.361), new Point(30.298, 62.676, 52.963),
        	new Point(37.796, 65.031, 91.44), new Point(60.032, 26.511, 43.19)
        };
        
//        System.out.println("volume: " + UseCuboid.minVolume(test));
        UseCuboid.minVolumePoints(test);
	}
}
