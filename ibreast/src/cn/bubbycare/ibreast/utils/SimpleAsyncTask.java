/**
 * 文件名：SimpleAsyncTask.java 2015-4-28 下午11:17:32
 * @author Administrator 	许仕永
 */
package cn.bubbycare.ibreast.utils;

import cn.bubbycare.ibreast.dialog.CustomProgressDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

/**Description : 简易异步类
 * Create time : 2015-4-28 下午11:17:32
 * Project name: 王者之证
 * File name   : SimpleAsyncTask.java
 * Encoded     : UTF-8
 * @author     许仕永
 * @JKD        JDK 1.6.0_21 
 * @version    v1.0.0
 */
@SuppressWarnings("rawtypes")
public class SimpleAsyncTask extends AsyncTask
{
	private ProgressDialog dialog;
	private Context context;
	private String message = "正在提交数据";
	private int textSize = 19;
	
	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public int getTextSize()
	{
		return textSize;
	}

	public void setTextSize(int textSize)
	{
		this.textSize = textSize;
	}

	public SimpleAsyncTask(Context context)
	{
		// TODO Auto-generated constructor stub
		this.context = context;
	}

	@Override
	protected Object doInBackground(Object... params)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void onPostExecute(Object result)
	{
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		dialog.dismiss();
		dialog = null;
	}

	@Override
	protected void onPreExecute()
	{
		// TODO Auto-generated method stub
		super.onPreExecute();
		if(dialog == null)
			dialog = CustomProgressDialog.getProgressDiaolgNoTitle(context, message, textSize);
	}

	
}
