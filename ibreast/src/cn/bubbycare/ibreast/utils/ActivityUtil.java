/**
 * 文件名：ActivityUtil.java 2015-5-2 下午9:45:35
 * @author Administrator 	许仕永
 */
package cn.bubbycare.ibreast.utils;

import android.app.Activity;
import android.content.Intent;
import cn.bubbycare.ibreast.R;

/**Description : Activity常用工具类
 * Create time : 2015-5-2 下午9:45:35
 * Project name: King
 * File name   : ActivityUtil.java
 * Encoded     : UTF-8
 * @author     许仕永
 * @JKD        JDK 1.6.0_21 
 * @version    v1.0.0
 */
public class ActivityUtil
{
    /**跳转到目标Activity并填充补间动画*/
    public static void goToNewActivityWithComplement(Activity activity, Class targeClass)
	{
    	Intent intent = new Intent(activity, targeClass);
		activity.overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
		activity.startActivity(intent);
	}
    
    /**跳转到目标Activity*/
    public static void goToNewActivity(Activity activity, Class targeClass)
	{
    	Intent intent = new Intent(activity, targeClass);
//		activity.overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
		activity.startActivity(intent);
	}
}
