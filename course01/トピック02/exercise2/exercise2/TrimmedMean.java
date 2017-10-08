package exercise2;

/**
 * 
 * @author 学籍番号 氏名
 *
 */
public class TrimmedMean {

	public static double calcTrimmedMean(double[] data) {
		double max = data[0];
		double min = data[0];
		double sum = 0;
		
		for (double num : data) {
			max = Math.max(num, max);
			min = Math.min(num, min);
		}
		
		for (double num : data) {
			if (num == max) continue;
			if (num == min) continue;
			sum += num;
		}
		
		return sum / (data.length - 2);
	}
	
	public static void main(String[] args) {
		double numbers[] = { -100.0, 3.0, 4.0, 5.0, 500.0 };
		
		System.out.println("Trimmed mean = " + calcTrimmedMean(numbers));
	}
}
