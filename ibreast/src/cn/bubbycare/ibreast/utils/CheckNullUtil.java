/**
 * 文件名：CheckNullUtil.java 2015-4-28 下午11:41:07
 * @author Administrator 	许仕永
 */
package cn.bubbycare.ibreast.utils;

import android.R.bool;
import android.widget.EditText;

/**Description : 检查是否空指针的工具类
 * Create time : 2015-4-28 下午11:41:07
 * Project name: 王者之证
 * File name   : CheckNullUtil.java
 * Encoded     : UTF-8
 * @author     许仕永
 * @JKD        JDK 1.6.0_21 
 * @version    v1.0.0
 */
public class CheckNullUtil
{
	/**
	 * 传入1个或多个EditText对象，判断是否其中有一个的getText值为null或空值
	 * @param editTexts
	 * @return 结果  ： false 全不为空   | true 有某个为空，（也可能有多个）
	 */
	public static boolean isNull(EditText...editTexts)
	{
		boolean isNull = false;
		String string = null;
		
		for ( int i = 0; i < editTexts.length; i++ )
		{
			string = editTexts[i].getText().toString();
			if(string == null || "".equals(string.trim()))
			{
				isNull = true;
				return isNull;
			}
		}
		
		return false;
	}
	
	/**
	 * 传入单个EditText对象，判断getText值为null或空值
	 * @param editText
	 * @return 结果  ： false 不为空   | true 为空
	 */
	public static boolean isNull(EditText editText)
	{
		boolean isNull = false;
		String string = null;
		
		string = editText.getText().toString();
		
		if(string == null || "".equals(string.trim()))
		{
			isNull = true;
			return isNull;
		}
		
		return false;
	}
}
