package cn.bubbycare.ibreast;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;
import cn.bubbycare.ibreast.activity.MainActivity;
import cn.bubbycare.ibreast.fragment.FragmentPage1;
import cn.bubbycare.ibreast.fragment.FragmentPage2;
import cn.bubbycare.ibreast.fragment.FragmentPage3;
import cn.bubbycare.ibreast.fragment.FragmentPage4;
import cn.bubbycare.ibreast.fragment.FragmentPage5;

/**
 * @author yangyu 功能描述：自定义TabHost
 *youmeng 5594bcfb67e58e4031002ce3
 */
public class MainTabActivity extends FragmentActivity {
    // 定义FragmentTabHost对象
    private FragmentTabHost mTabHost;
    // 定义一个布局查找器
    private LayoutInflater layoutInflater;
    // 存放Fragment界面的数组
    private Class fragmentArray[] = { FragmentPage1.class, FragmentPage2.class, FragmentPage3.class, FragmentPage4.class, FragmentPage5.class };
    // 定义数组来存放按钮图片
    private int mImageViewArray[] = { R.drawable.tab_home_btn, R.drawable.tab_message_btn, R.drawable.tab_selfinfo_btn, R.drawable.tab_square_btn,
            R.drawable.tab_more_btn };
    // Tab选项卡的文字
    private String[] mTextviewArray;// = { getString(R.string.frament_first), getString(R.string.frament_second), getString(R.string.frament_thirst), getString(R.string.frament_four), getString(R.string.frament_five) };

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_tab_layout);
        initValue();
        initView();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    

    private void initValue() {
        // TODO Auto-generated method stub
        mTextviewArray = getResources().getStringArray(R.array.tab_item_text);
    }

    /**
     * 初始化组件
     */
    private void initView() {
        // 实例化布局对象
        layoutInflater = LayoutInflater.from(this);

        // 实例化TabHost对象，得到TabHost
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        // 得到fragment的个数
        int count = fragmentArray.length;

        for (int i = 0; i < count; i++) {
            // 为每一个Tab按钮设置图标、文字和内容
            TabSpec tabSpec = mTabHost.newTabSpec(mTextviewArray[i]).setIndicator(getTabItemView(i));
            // 将Tab按钮添加进Tab选项卡中
            mTabHost.addTab(tabSpec, fragmentArray[i], null);
            // 设置Tab按钮的背景
            mTabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.selector_tab_background);
        }
    }

    /**
     * 给Tab按钮设置图标和文字
     */
    private View getTabItemView(int index) {
        View view = layoutInflater.inflate(R.layout.tab_item_view, null);

        ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
        imageView.setImageResource(mImageViewArray[index]);

        TextView textView = (TextView) view.findViewById(R.id.textview);
        textView.setText(mTextviewArray[index]);

        return view;
    }
}