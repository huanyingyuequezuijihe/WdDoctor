package com.wd.doctor.mvp.wy.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.wd.doctor.R;

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/26 19:20
 * @classname :MyToggleButtonView
 * 开关 滑块
 */
public class MyToggleButtonView extends View {

    public MyToggleButtonView(Context context) {
        super(context);
    }

    public MyToggleButtonView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyToggleButtonView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    private boolean isLeft=true;//划块是不是在左边
    private Bitmap bitmapBg;
    private Bitmap bitmapSlide;

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //设置toggleButton大小为背景图片的大小
        setMeasuredDimension(bitmapBg.getWidth(),bitmapBg.getHeight());
    }

    //代码块，在构造方法之前执行
    {

        //获取项目的资源文件
        Resources resources = getResources();
        //获取背景图片
        bitmapBg = BitmapFactory.decodeResource(resources, R.mipmap.button_background_bllue);
        //获取上面的划块
        bitmapSlide = BitmapFactory.decodeResource(resources, R.mipmap.button);

        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //取反
                isLeft=!isLeft;
                //刷新界面
                invalidate();
            }
        });
    }
    //
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画笔
        Paint paint = new Paint();
        canvas.drawBitmap(bitmapBg,0,0,paint);
        if(isLeft){
            canvas.drawBitmap(bitmapSlide,0,0,paint);
        }else{
            //背景的宽
            int bgWidth = bitmapBg.getWidth();
            //滑块的宽
            int slideWidth = bitmapSlide.getWidth();
            //左
            int left = bgWidth - slideWidth;
            canvas.drawBitmap(bitmapSlide,left,0,paint);
        }
    }
}
