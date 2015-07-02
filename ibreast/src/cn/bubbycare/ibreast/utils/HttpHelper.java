package cn.bubbycare.ibreast.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/**
 * HTTP缂冩垹绮剁拋鍧楁６閻╃鍙ч弬瑙勭《
 * 
 * @author Li Bin
 */
public class HttpHelper {
	private static final String URL = "http://kingbattle.jsp.jspee.cn/";
	private static final String CHARSET = "utf-8";
	public static String USERUA = null;

	/**
	 * 閸欐埊鎷�http鐠囬攱鐪伴敍宀冨箯瀵版鎼锋惔鏃�殶閿燂拷
	 * 
	 * @param entity
	 *            閸栧懎鎯堢拠閿嬬湴鐎圭偘缍嬫穱鈩冧紖閻ㄥ嚧equestEntity鐎圭偘绶�
	 * @return 鏉╂柨娲栭張宥呭閸ｃ劎顏崫宥呯安閻ㄥ嚙SON鐎涙顑佹稉鑼波閿燂拷
	 * @throws Exception
	 */
	public synchronized static String execute(RequestEntity entity)
			throws Exception {
		String jsonResult = "";

		String url = URL + entity.getUrl();
		
		switch (entity.getMethod()) {
		case HttpMethod.GET:
		case HttpMethod.POST:	
		    jsonResult = get(url, entity.getTextFields());
			break;
		}

		return jsonResult;
	}

	/**
	 * 閹笛嗩攽GET鐠囬攱鐪�
	 */
	private synchronized static String get(String url,
			Map<String, Object> params) throws Exception {
		String jsonResult = "";
		InputStream is = null;
		try {
			String urlEncodedForm = toUrlEncodedFormParams(params);
			url = url + "?" + urlEncodedForm;
			Log.i("XU", "dizhi="+url);
			System.out.println("url:" + url);
			System.out.println("params:" + params);
			HttpURLConnection conn = getHttpURLConnection(url);
			//鐠囬攱鐪伴敓锟�//			conn.setRequestProperty("app_id", "pp_tw_sdk_1_channel_2"); 
//			conn.setRequestProperty("User-Agent", USERUA);
//			conn.setRequestProperty("secret", "2d09fedbb0fe5226acc704c08faf452d");
			
			conn.setRequestMethod("POST");
			if (conn.getResponseCode() == 200) {
				is = conn.getInputStream();
				jsonResult = read(is);
			} else {
				throw (new Exception());
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
			throw (e);
		} catch (IOException e) {
			e.printStackTrace();
			throw (e);
		} finally {
			closeStream(is);
		}

		return jsonResult;
	}


	/**
	 * 閹笛嗩攽http post鐠囬攱鐪�
	 * 
	 * @param url
	 *            鐠囬攱鐪伴惃鍕箛閸斺�娅掔粩鐥憄i閻ㄥ嫰鎽奸敓锟�
	 * @param params
	 *            閸栧懎鎯堢拠閿嬬湴閸欏倹鏆熼惃鍑猘p
	 * @return 鏉╂柨娲朖son閺嶇厧绱￠惃鍕惙鎼存梹鏆熼敓锟�
	 * @throws Exception
	 */
	public synchronized static String post(String url,
			Map<String, Object> params) throws Exception {
		String jsonResult = "";
		OutputStream os = null;
		InputStream is = null;

		try {
			HttpURLConnection conn = getHttpURLConnection(url);
			conn.setDoOutput(true);
			conn.setUseCaches(false);

			conn.setRequestMethod("POST");
//			conn.setRequestProperty("app_id", "pp_tw_sdk_1_channel_2"); 
//			conn.setRequestProperty("User-Agent", USERUA);
//			conn.setRequestProperty("secret", "2d09fedbb0fe5226acc704c08faf452d");

			os = conn.getOutputStream();
			String urlEncodedForm = toUrlEncodedFormParams(params);
			os.write(urlEncodedForm.getBytes());
			os.flush();

			if (conn.getResponseCode() == 200) {
				is = conn.getInputStream();
				jsonResult = read(is);
				Log.i("Post", jsonResult);
			} else {
				throw (new Exception());
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
			throw (e);
		} catch (IOException e) {
			e.printStackTrace();
			throw (e);
		} finally {
			closeStream(is);
			closeStream(os);
		}
		return jsonResult;
	}

	/**
	 * 閹笛嗩攽http GET鐠囬攱鐪伴敍宀冨箯閸欐牠鎽奸幒銉﹀灇閸旂喎鎮楅惃鍕翻閸忋儲绁﹂敍灞艰礋娴滃棔绗呮潪鑺ユ瀮娴犺埖妞傛担璺ㄦ暏
	 * 
	 * @param url
	 *            鐠囬攱鐪伴惃鍕箛閸斺�娅掔粩鐥憄i閻ㄥ嫰鎽奸敓锟�
	 * @return 鏉╂柨娲栭敓锟介敓鏂ゆ嫹鏉堟挸鍙嗗ù浣割嚠鐠炩�鐤勯敓锟�
	 */
	public synchronized static InputStream getInputStream(String url) {
		InputStream is = null;
		try {
			HttpURLConnection conn = getHttpURLConnection(url);
			conn.setRequestMethod("GET");
			if (conn.getResponseCode() == 200) {
				is = conn.getInputStream();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return is;
	}

	/**
	 * 閼惧嘲绶盚ttpURLConnection鏉╃偞甯寸�鐐扮伐
	 * 
	 * @param strURL
	 *            閺堝秴濮熼崳銊ь伂api閻ㄥ嫰鎽奸敓锟�
	 * @return 鏉╂柨娲朒ttpURLConnection鐎圭偘绶�
	 * @throws IOException
	 */
	private static HttpURLConnection getHttpURLConnection(String strURL)
			throws IOException {
		URL url = new URL(strURL);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setConnectTimeout(10000);
		conn.setReadTimeout(15000);
		return conn;
	}

	/**
	 * 娴犲氦绶崗銉︾ウ娑擃叀顕伴崙鐑樻瀮閺堫兛淇婇敓锟�
	 * 
	 * @param is
	 *            閹稿洤鐣鹃惃鍕翻閸忋儲绁�
	 * @return
	 * @throws IOException
	 */
	private static String read(InputStream is) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte[] buffer = new byte[128];
		int len = 0;
		while ((len = is.read(buffer)) != -1) {
			out.write(buffer, 0, len);
		}

		String text = new String(out.toByteArray(), "utf-8");
		out.flush();
		closeStream(out);
		return text;
	}

	/**
	 * 鐏忓棗瀵橀崥鐜tp post鐠囬攱鐪伴弫鐗堝祦閻ㄥ埓ap閿涘矁袙閺嬫劒璐烾rlEncoded閺嶇厧绱￠惃鍕摟缁楋缚瑕�
	 * 
	 * @param params
	 *            閸栧懎鎯堢拠閿嬬湴閸欏倹鏆熼惃鍑猘p
	 * @return 鏉╂柨娲栫憴锝嗙�閸氬海娈慤rlEncoded閺嶇厧绱￠惃鍕摟缁楋缚瑕�
	 */
	private static String toUrlEncodedFormParams(Map<String, Object> params) {
		StringBuffer strBuffer = new StringBuffer();
		if (params != null) {
			Set<String> keySet = params.keySet();
			Iterator<String> i = keySet.iterator();
			while (i.hasNext()) {
				String key = i.next();
				String value = params.get(key).toString();
				strBuffer.append(key);
				strBuffer.append("=");
				strBuffer.append(value);
				if (i.hasNext()) {
					strBuffer.append("&");
				}
			}
		} else {
		}
		return strBuffer.toString();
	}



	/**
	 * 閸忔娊妫碔O閿燂拷
	 * 
	 * @param obj
	 *            閿燂拷閿熸枻鎷锋潏鎾冲弳濞翠焦鍨ㄦ潏鎾冲毉濞翠礁顕挒鈥崇杽閿燂拷
	 */
	public static void closeStream(Object obj) {
		if (obj != null && obj instanceof InputStream) {
			InputStream is = (InputStream) obj;
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (obj != null && obj instanceof OutputStream) {
			OutputStream os = (OutputStream) obj;
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static boolean isNetWokrConnected(Context context) {
		ConnectivityManager connectivityManager = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo info = connectivityManager.getActiveNetworkInfo();
		if (info != null) {
			return info.isConnected();
		}
		return false;
	}

}
