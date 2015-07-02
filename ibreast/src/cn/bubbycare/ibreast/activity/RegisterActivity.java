/**
 * FileName:RegisterActivity.java
 * Author  : xsy
 * Decode  : UTF-8
 * Create Time: 2015 1:18:18 PM
 * Description:
 */
package cn.bubbycare.ibreast.activity;

import java.util.Random;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import cn.bubbycare.ibreast.R;
import cn.bubbycare.ibreast.interfaces.IActivity;
import cn.bubbycare.ibreast.view.CustomTitleBar;
import cn.smssdk.SMSSDK;


public class RegisterActivity extends Activity implements IActivity, OnClickListener{
    private static String APPKEY = "8839ed2ba098";
    private static String APPSECRET = "315a824f2eed0bc6366478248320816a";
    private static final String[] AVATARS = {
        "http://tupian.qqjay.com/u/2011/0729/e755c434c91fed9f6f73152731788cb3.jpg",
        "http://99touxiang.com/public/upload/nvsheng/125/27-011820_433.jpg",
        "http://img1.touxiang.cn/uploads/allimg/111029/2330264224-36.png",
        "http://img1.2345.com/duoteimg/qqTxImg/2012/04/09/13339485237265.jpg",
        "http://diy.qqjay.com/u/files/2012/0523/f466c38e1c6c99ee2d6cd7746207a97a.jpg",
        "http://img1.touxiang.cn/uploads/20121224/24-054837_708.jpg",
        "http://img1.touxiang.cn/uploads/20121212/12-060125_658.jpg",
        "http://img1.touxiang.cn/uploads/20130608/08-054059_703.jpg",
        "http://diy.qqjay.com/u2/2013/0422/fadc08459b1ef5fc1ea6b5b8d22e44b4.jpg",
        "http://img1.2345.com/duoteimg/qqTxImg/2012/04/09/13339510584349.jpg",
        "http://img1.touxiang.cn/uploads/20130515/15-080722_514.jpg",
        "http://diy.qqjay.com/u2/2013/0401/4355c29b30d295b26da6f242a65bcaad.jpg"
    };
    CustomTitleBar titleBar ;
    private boolean ready;
    private Button btnGetVerNum;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_layout);
        initView();
        initView();
        initEvent();
        SMSSDK.initSDK(this, APPKEY, APPSECRET);
    }
    
    
    
    public void onClick(View v) {
        switch (v.getId()) {
        case R.id.activity_register_btn_verification:
            
            break;

        default:
            break;
        }
    }
    
    
    // 提交用户信息
    private void registerUser(String country, String phone) {
        Random rnd = new Random();
        int id = Math.abs(rnd.nextInt());
        String uid = String.valueOf(id);
        String nickName = "SmsSDK_User_" + uid;
        String avatar = AVATARS[id % 12];
        SMSSDK.submitUserInfo(uid, nickName, avatar, country, phone);
    }
    
    protected void onDestroy() {
//        if (ready) {
            // 销毁回调监听接口
            SMSSDK.unregisterAllEventHandler();
//        }
        super.onDestroy();
    }
    
    @Override
    public void initView() {
        // TODO Auto-generated method stub
        titleBar = (CustomTitleBar)this.findViewById(R.id.titlebar);
        btnGetVerNum = (Button)this.findViewById(R.id.activity_register_btn_verification);
//        titleBar.setBackGroundColorForView(android.R.color.holo_blue_light);
    }

    @Override
    public void initValue() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void initEvent() {
        // TODO Auto-generated method stub
        btnGetVerNum.setOnClickListener(this);
    }
}
