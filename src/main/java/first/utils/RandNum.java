package first.utils;

import java.util.Random;

public class RandNum {

	/**
	 * @生成一个6位的随机码
	 */
	public static String createRandNum() {
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i <= 5; i++) {
			String s = random.nextInt(10) + "";
			sb.append(s);
		}
		return sb.toString();
	}
}
