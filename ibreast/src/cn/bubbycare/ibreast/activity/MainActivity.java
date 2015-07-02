package cn.bubbycare.ibreast.activity;

import java.util.HashMap;
import java.util.Random;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import cn.bubbycare.ibreast.R;
import cn.bubbycare.ibreast.data.Constants;
import cn.bubbycare.ibreast.interfaces.IActivity;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.RegisterPage;
import com.umeng.socialize.controller.UMServiceFactory;
import com.umeng.socialize.controller.UMSocialService;

public class MainActivity extends BaseActivity implements IActivity, OnClickListener {

    private static String APPKEY = "8839ed2ba098";
    private static String APPSECRET = "315a824f2eed0bc6366478248320816a";
    private static final String[] AVATARS = { "http://tupian.qqjay.com/u/2011/0729/e755c434c91fed9f6f73152731788cb3.jpg",
            "http://99touxiang.com/public/upload/nvsheng/125/27-011820_433.jpg", "http://img1.touxiang.cn/uploads/allimg/111029/2330264224-36.png",
            "http://img1.2345.com/duoteimg/qqTxImg/2012/04/09/13339485237265.jpg",
            "http://diy.qqjay.com/u/files/2012/0523/f466c38e1c6c99ee2d6cd7746207a97a.jpg", "http://img1.touxiang.cn/uploads/20121224/24-054837_708.jpg",
            "http://img1.touxiang.cn/uploads/20121212/12-060125_658.jpg", "http://img1.touxiang.cn/uploads/20130608/08-054059_703.jpg",
            "http://diy.qqjay.com/u2/2013/0422/fadc08459b1ef5fc1ea6b5b8d22e44b4.jpg", "http://img1.2345.com/duoteimg/qqTxImg/2012/04/09/13339510584349.jpg",
            "http://img1.touxiang.cn/uploads/20130515/15-080722_514.jpg", "http://diy.qqjay.com/u2/2013/0401/4355c29b30d295b26da6f242a65bcaad.jpg" };

    private UMSocialService mController = UMServiceFactory.getUMSocialService(Constants.DESCRIPTOR);

    Button btnLogin;
    Button btnRegister;
    ImageButton imgBtnQQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_layout);
        SMSSDK.initSDK(this, APPKEY, APPSECRET);
        initView();
        initValue();
        initEvent();
//        addQQQZonePlatform();
    }
    
//    /**
//     * @功能描述 : 添加QQ平台支持 QQ分享的内容， 包含四种类型， 即单纯的文字、图片、音乐、视频. 参数说明 : title, summary,
//     *       image url中必须至少设置一个, targetUrl必须设置,网页地址必须以"http://"开头 . title :
//     *       要分享标题 summary : 要分享的文字概述 image url : 图片地址 [以上三个参数至少填写一个] targetUrl
//     *       : 用户点击该分享时跳转到的目标地址 [必填] ( 若不填写则默认设置为友盟主页 )
//     * @return
//     */
//    private void addQQQZonePlatform() {
//     // 添加腾讯微博SSO授权
//        mController.getConfig().setSsoHandler(new TencentWBSsoHandler());
//        
//        String appId = "100424468";
//        String appKey = "c7394704798a158208a74ab60104f0ba";
//        // 添加QQ支持, 并且设置QQ分享内容的target url
//        UMQQSsoHandler qqSsoHandler = new UMQQSsoHandler(MainActivity.this,
//                appId, appKey);
//        qqSsoHandler.setTargetUrl("http://www.umeng.com");
//        qqSsoHandler.addToSocialSDK();
//
//        // 添加QZone平台
//        QZoneSsoHandler qZoneSsoHandler = new QZoneSsoHandler(
//                MainActivity.this, appId, appKey);
//        qZoneSsoHandler.addToSocialSDK();
//    }
//
//
//    /**
//     * 授权。如果授权成功，则获取用户信息
//     * @param platform
//     */
//    private void login(final SHARE_MEDIA platform) {
//        mController.doOauthVerify(MainActivity.this, platform, new UMAuthListener() {
//
//            @Override
//            public void onStart(SHARE_MEDIA platform) {
//                Toast.makeText(MainActivity.this, "授权开始", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onError(SocializeException e, SHARE_MEDIA platform) {
//                Toast.makeText(MainActivity.this, "授权失败", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onComplete(Bundle value, SHARE_MEDIA platform) {
//                // 获取uid
//                String uid = value.getString("uid");
//                if (!TextUtils.isEmpty(uid)) {
//                    // uid不为空，获取用户信息
//                    getUserInfo(platform);
//                } else {
//                    Toast.makeText(MainActivity.this, "授权失败...", Toast.LENGTH_LONG).show();
//                }
//            }
//
//            @Override
//            public void onCancel(SHARE_MEDIA platform) {
//                Toast.makeText(MainActivity.this, "授权取消", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
//    /**
//     * 获取用户信息
//     * 
//     * @param platform
//     */
//    private void getUserInfo(SHARE_MEDIA platform) {
//        mController.getPlatformInfo(MainActivity.this, platform, new UMDataListener() {
//
//            @Override
//            public void onStart() {
//
//            }
//
//            @Override
//            public void onComplete(int status, Map<String, Object> info) {
//                // String showText = "";
//                // if (status == StatusCode.ST_CODE_SUCCESSED) {
//                // showText = "用户名：" +
//                // info.get("screen_name").toString();
//                // Log.d("#########", "##########" + info.toString());
//                // } else {
//                // showText = "获取用户信息失败";
//                // }
//
//                if (info != null) {
//                    Toast.makeText(MainActivity.this, info.toString(), Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//    }
//
//    /**
//     * 注销本次登陆
//     * 
//     * @param platform
//     */
//    private void logout(final SHARE_MEDIA platform) {
//        mController.deleteOauth(MainActivity.this, platform, new SocializeClientListener() {
//
//            @Override
//            public void onStart() {
//
//            }
//
//            @Override
//            public void onComplete(int status, SocializeEntity entity) {
//                String showText = "解除" + platform.toString() + "平台授权成功";
//                if (status != StatusCode.ST_CODE_SUCCESSED) {
//                    showText = "解除" + platform.toString() + "平台授权失败[" + status + "]";
//                }
//                Toast.makeText(MainActivity.this, showText, Toast.LENGTH_SHORT).show();
//            }
//        });
//    }

    @Override
    public void initView() {
        // TODO Auto-generated method stub
        btnLogin = (Button) this.findViewById(R.id.activity_main_btn_login);
        btnRegister = (Button) this.findViewById(R.id.activity_main_btn_register);
        imgBtnQQ = (ImageButton)this.findViewById(R.id.activity_main_login_qq);
    }

    @Override
    public void initValue() {
        // TODO Auto-generated method stub

    }

    @Override
    public void initEvent() {
        // TODO Auto-generated method stub
        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
        imgBtnQQ.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
        case R.id.activity_main_btn_login:

            break;
        case R.id.activity_main_btn_register:
            register();
            break;
        case R.id.activity_main_login_qq:
//            login(SHARE_MEDIA.QQ);
            break;
        default:
            break;
        }
    }

    private void register() {
        try {
            // 打开注册页面
            RegisterPage registerPage = new RegisterPage();
            registerPage.setRegisterCallback(new EventHandler() {
                public void afterEvent(int event, int result, Object data) {
                    // 解析注册结果
                    if (result == SMSSDK.RESULT_COMPLETE) {
                        @SuppressWarnings("unchecked")
                        HashMap<String, Object> phoneMap = (HashMap<String, Object>) data;
                        String country = (String) phoneMap.get("country");
                        String phone = (String) phoneMap.get("phone");
                        // 提交用户信息
                        registerUser(country, phone);

                        Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                        startActivity(intent);
                    } else {

                    }
                }
            });
            registerPage.show(MainActivity.this);
        } catch (Exception e) {
            // TODO: handle exception
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
}
