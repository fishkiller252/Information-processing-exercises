package advanced7b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author 学籍番号 氏名
 */

public class RpnCalc2 {
	
	private RStack stk;
	
	/**
	 * Constructor
	 */
	public RpnCalc2 () {
		stk = new RStack();
	}
	
	public String calculate (String s){
		double x, y;	// working var
		
		// interpret s
		if (s.equals("+") && stk.available()) {
			// get two arguments
			y = stk.pop();
			x = stk.pop();
			stk.push(x + y);
		} else
		if (s.equals("-") && stk.available()) {
			// get two arguments
			y = stk.pop();
			x = stk.pop();
			stk.push(x - y);
		} else
		if (s.equals("*") && stk.available()) {
			// get two arguments
			y = stk.pop();
			x = stk.pop();
			stk.push(x * y);
		} else
		if (s.equals("/") && stk.available()) {
			// get two arguments
			y = stk.pop();
			x = stk.pop();
			stk.push(x / y);
		} else
		if (s.matches ("([0-9]|\\.)+")) {
			stk.push(Double.parseDouble(s));
		}
		
		// display
		return stk.toString();
	}
	public static void main(String[] args) {
		RpnCalc2 rpncalc = new RpnCalc2();
		
		String s;
		try {
			System.out.println("start");
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			do {
				System.out.print(":");
				s = in.readLine();
				System.out.print( rpncalc.calculate(s) );
			} while (!s.equals("quit"));
			in.close();
			System.out.println();
			System.out.println("end");
		} catch (IOException e) {
		}
	}
}
