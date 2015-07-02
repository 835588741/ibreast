/**
 * 文件名：HttpUtil.java 2014-12-23 下午4:42:06
 * @author Administrator 	许仕永
 */
package cn.bubbycare.ibreast.utils;

import java.util.Map;

/**
 * 地区id和state都因为展示需要在本地写死 实际运营需要更改 Description : 网络请求工具 Create time : 2014-12-23
 * 下午4:42:06 Project name: yihuan File name : HttpUtil.java Encoded : UTF-8
 * 
 * @author 许仕永
 * @JKD JDK 1.6.0_21
 * @version v1.0.0
 */
public class HttpUtil
{
	/**
	 * 判断传入的String是否是网址格式
	 * @param url
	 * @return true是网址格式 | false不是网址格式
	 */
	public static boolean isValidHttpUrl(String url)
	{
		String tempString = url.substring(0, 7);
		if(!"http://".equals(tempString))
		{
			return false;
		}
		return true;
	}
	

	/**
	 * 普通请求
	 * @param url
	 * @param map
	 * @return
	 */
	public static String post(String url, Map<String, Object> map)
	{
		// 构造一个请求实体类来封装 url、请求的方法、map参数
		RequestEntity entity = new RequestEntity(url, HttpMethod.POST, map);
		String resultJson = null;
		try
		{
			resultJson = HttpHelper.execute(entity);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return resultJson;
	}
}
