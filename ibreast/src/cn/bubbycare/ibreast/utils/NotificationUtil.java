/**
 * 文件名：NotificationUtil.java 2015-1-14 下午3:51:14
 * @author Administrator 	许仕永
 */
package cn.bubbycare.ibreast.utils;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import cn.bubbycare.ibreast.R;

/**Description : 状态栏通知工具类
 * Create time : 2015-1-14 下午3:51:14
 * Project name: yihuan
 * File name   : NotificationUtil.java
 * Encoded     : UTF-8
 * @author     许仕永
 * @JKD        JDK 1.6.0_21 
 * @version    v1.0.0
 */
public class NotificationUtil
{
	// 声明通知管理器
	 private NotificationManager notificationManager = null;
	 // 声明Notification对象
	 private Notification notification = null;
	 public static NotificationUtil instance = null;
	 private PendingIntent pendingIntent = null;
	 private Context context;
	 
	 private int notificationSoundResource = 0 ;
	 private int notificationShowImage = 0;
	 
	 /**
	  * 单实例模式返回对象
	  * @param context
	  * @return
	  */
	 public static NotificationUtil getInstance(Context context)
	 {
		 if(instance == null)
			 instance = new NotificationUtil(context);
		 return instance;
	 }
	 
	 /**
	  * 自定义通知音效
	  * @param sound 音效资源id
	  */
	 public void setNotificationSoundResource(int sound)
	 {
		 this.notificationSoundResource = sound;
	 }
	 
	 /**
	  * 自定义通知显示的小图标
	  * @param image
	  */
	 public void setNotificationShowImage(int image)
	 {
		 this.notificationShowImage = image;
	 }
	 
	 private NotificationUtil(Context context)
	 {
		 this.context = context;
		 // 初始化NotificationManager对象
		 notificationManager = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
		  // 构造Notification对象
		 notification = new Notification();
		 
//		 Intent intent = new Intent(context, Shouye.class);
//		 
//		  // 主要设置点击通知的时显示内容的类
//		 pendingIntent = PendingIntent.getActivity(context, 0,
//		    intent, 0);
	 }

	 
	 /**
	  * 以产生通知
	  * @param notifica 通知内容
	  */
	 public void showNotifica(String notifica)
	 {
		 if(notifica == null)
			 notifica = "通知内容为空！";
		 
		 	if(notificationShowImage == 0)
		 	{
		 		// 设置通知在状态栏显示的图标
		 		notification.icon = R.drawable.ic_launcher;
		 	}
		 	else
		 	{
		 		notification.icon = notificationShowImage;
		 	}
		    // 当我们点击通知时显示的内容
		    notification.tickerText = notifica;
		    if(notificationSoundResource == 0)
		    {
		    	// 通知时发出的声音
		    	notification.defaults = Notification.DEFAULT_SOUND;
		    }
		    else
		    {
		    	notification.defaults = notificationSoundResource;
		    }
		    // 设置同时显示的参数
		    notification.setLatestEventInfo(context,
		      context.getString(R.string.app_name), notifica, pendingIntent);
		    // 可以理解为执行这个通知
		    notificationManager.notify(0, notification);
	 }
	 
	 
}
