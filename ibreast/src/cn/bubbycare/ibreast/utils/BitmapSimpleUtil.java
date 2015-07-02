package cn.bubbycare.ibreast.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.Bitmap.Config;

public class BitmapSimpleUtil
{
    /**
     * 反转
     * @param a
     * @param width
     * @param height
     * @param type 1垂直反转  2水平反转
     * @return
     */
    public static Bitmap convert(Bitmap a, int width, int height,int type) {

        int w = a.getWidth();
        int h = a.getHeight();

        Bitmap newb = Bitmap.createBitmap(w, h, Config.ARGB_8888);// 创建一个新的和SRC长度宽度一样的位图
        Canvas cv = new Canvas(newb);
        Matrix m = new Matrix();

        if(type == 1)
            m.postScale(1, -1); // 镜像垂直翻转
        else
            m.postScale(-1, 1); // 镜像水平翻转
            
        m.postRotate(-90); // 旋转-90度

        Bitmap new2 = Bitmap.createBitmap(a, 0, 0, w, h, m, true);

        cv.drawBitmap(new2, new Rect(0, 0, new2.getWidth(), new2.getHeight()),
                new Rect(0, 0, w, h), null);

        return newb;

    }

    /**
     * 反转
     * @param a
     * @param width
     * @param height
     * @param type 1垂直反转  2水平反转
     * @return
     */
    public static Bitmap convert2(Bitmap a, int width, int height,int type) {

        int w = a.getWidth();
        int h = a.getHeight();

        Bitmap newb = Bitmap.createBitmap(w, h, Config.ARGB_8888);// 创建一个新的和SRC长度宽度一样的位图
        Canvas cv = new Canvas(newb);
        Matrix m = new Matrix();

        if(type == 1)
            m.postScale(1, -1); // 镜像垂直翻转
        else
            m.postScale(-1, 1); // 镜像水平翻转
            
//        m.postRotate(-90); // 旋转-90度

        Bitmap new2 = Bitmap.createBitmap(a, 0, 0, w, h, m, true);

        cv.drawBitmap(new2, new Rect(0, 0, new2.getWidth(), new2.getHeight()),
                new Rect(0, 0, w, h), null);

        return newb;

    }
}
