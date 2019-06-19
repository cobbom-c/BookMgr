package top.ourck.util;

public class StringUtil {

	/**
	 * 用于将""字符串转换为null返回。<br>
	 * 若传入参数不为空，返回其本身。<br>
	 * HINT 这玩意的一个用途，是用来将POST上来的HTTP表单里边的""变成null。
	 * @param str 参数
	 * @return 结果
	 */
	public static String asNull(String str) {
		return str == null ? str :
			(str.equals("") ? null : str);
	}
	
	/**
	 * 判断一个字符串是否为空。
	 * @param str
	 * @param str 参数
	 * @return 结果
	 */
	public static boolean isNull(String str) {
		return str == null;
	}
}
