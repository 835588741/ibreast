package cn.bubbycare.ibreast.dialog;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import cn.bubbycare.ibreast.R;

public class ToastUtil
{
//	enum TYPE
//	{
//		ERROR,WARN,INFO
//	}
	/**错误样式**/
	public static final int ERROR = 1;
	/**警告样式**/
	public static final int WARN  = 2;
	/**普通信息样式**/
	public static final int INFO  = 3;
	/**加载样式**/
	public static final int LOAD  = 4;
	/**成功提示样式**/
	public static final int SUCC  = 5;
	
	/**
	 * Toast显示
	 * @param context
	 * @param str	显示的字符串
	 * @param typeOfToastShow	Toast类型 ---> ERROR、WARN、INFO、LOAD
	 */
	public static void show(Context context,String str,int typeOfToastShow)
	{
		Toast toast = new Toast(context);
		View view = getView(typeOfToastShow, context , str);
		toast.setView(view);
		toast.setGravity(Gravity.BOTTOM, 0, 100);
		toast.setDuration(Toast.LENGTH_SHORT);
		toast.show();
	}
	
	/**获取视图*/
	private static View getView(int type,Context context,String str)
	{
		View view = null;
		ImageView img = null;
		TextView txt = null;
		switch(type)
		{
			case ERROR:
				view = View.inflate(context, R.layout.cmp_rich_toast, null);
				img = (ImageView)view.findViewById(R.id.toast_img);
				txt = (TextView)view.findViewById(R.id.toast_txt);
				txt.setText(str);
				img.setBackgroundResource(R.drawable.toast_error);
				break;
			case WARN :
				view = View.inflate(context, R.layout.cmp_rich_toast, null);
				img = (ImageView)view.findViewById(R.id.toast_img);
				txt = (TextView)view.findViewById(R.id.toast_txt);
				txt.setText(str);
				img.setBackgroundResource(R.drawable.toast_warn);
				break;
			case LOAD :
				view = View.inflate(context, R.layout.cmp_rich_toast, null);
				img = (ImageView)view.findViewById(R.id.toast_img);
				txt = (TextView)view.findViewById(R.id.toast_txt);
				txt.setText(str);
				img.setBackgroundResource(R.drawable.toast_load);
				break;
			case SUCC :
				view = View.inflate(context, R.layout.cmp_rich_toast, null);
				img = (ImageView)view.findViewById(R.id.toast_img);
				txt = (TextView)view.findViewById(R.id.toast_txt);
				txt.setText(str);
				img.setBackgroundResource(R.drawable.toast_success);
				break;
			default :
				view = View.inflate(context, R.layout.cmp_rich_toast, null);
				img = (ImageView)view.findViewById(R.id.toast_img);
				txt = (TextView)view.findViewById(R.id.toast_txt);
				txt.setText(str);
				img.setBackgroundResource(R.drawable.toast_info);
		}
		return view;
	}

	/**
	 * 可以控制显示时间的Toast
	 * @param context
	 * @param str 显示的字符串
	 * @param typeOfToastShow	Toast类型 ---> ERROR、WARN、INFO、LOAD
	 * @param showTime		显示时间
	 */
	public static void show(Context context,String str,int typeOfToastShow,int showTime)
	{
		Toast toast = new Toast(context);
		View view = getView(typeOfToastShow, context , str);
		toast.setView(view);
		toast.setGravity(Gravity.BOTTOM, 0, 100);
		toast.setDuration(showTime);
		toast.show();
	}
	
	/**
	 * 显示出用以提示错误信息吐司
	 * @param context
	 */
	public static void showErrorToast(Context context,String mess)
	{
		show(context, mess, ERROR);
	}
	
	/**
	 * 显示出用以提示错误信息吐司，通用消息 ”数据异常“
	 * @param context
	 */
	public static void showErrorToastDataError(Context context)
	{
		show(context, "数据异常", ERROR);
	}
	
	
	/**
	 * 显示出用以提示普通（正确）消息的吐司
	 * @param context
	 */
	public static void showInfoToast(Context context,String mess)
	{
		show(context, mess, INFO);
	}
	
	/**
	 * 显示出用以提示警告级别消息的吐司
	 * @param context
	 */
	public static void showWarnToast(Context context,String mess)
	{
		show(context, mess, WARN);
	}
	
	/**
	 * 显示出用以提示警告信息吐司，通用消息 ”数据异常“
	 * @param context
	 */
	public static void showWarnToastDataWarn(Context context)
	{
		show(context, "数据异常", ERROR);
	}
	
	/**
	 * 显示出用以提示成功消息的吐司
	 * @param context
	 */
	public static void showSuccToast(Context context,String mess)
	{
		show(context, mess, SUCC);
	}
	
	/**
	 * 显示出用以提示正在加载消息的吐司
	 * @param context
	 */
	public static void showLoadToast(Context context,String mess)
	{
		show(context, mess, WARN);
	}
}