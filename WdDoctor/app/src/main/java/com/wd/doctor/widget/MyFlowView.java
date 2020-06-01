package com.wd.doctor.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.wd.doctor.net.App;

import java.util.ArrayList;

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/31 15:08
 * @classname :MyFlowView
 */
public class MyFlowView extends ViewGroup {
    private  int screashWidth=0;
    private  int screashHeight=0;
    private  addText addText;
    public ArrayList<String> src=new ArrayList<>();
    public MyFlowView(Context context) {
        super(context);
        setDW(context);
    }

    public MyFlowView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setDW(context);
    }

    public MyFlowView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setDW(context);
    }
    public void setDW(Context context){
        screashWidth= context.getResources().getDisplayMetrics().widthPixels;
        screashHeight= context.getResources().getDisplayMetrics().heightPixels;
    }
    public void addView(String text){
        if(!src.contains(text)) {
            TextView textView = new TextView(getContext());
            textView.setText(text);
            textView.setTextSize(12);
            textView.setPadding(20, 20, 20, 20);
            addView(textView);
            src.add(text);
            textView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (addText != null) {
                        addText.onAddtext(textView.getText().toString());
                    }
                }
            });
        }else {
            Toast.makeText(App.Companion.getContext(),"数据不可以重复",Toast.LENGTH_LONG).show();
        }

    }
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount=  getChildCount();
        int left=0;
        int right=0;
        int buttom=0;
        int top=0;
        int space=20;
        for (int i = 0; i < childCount; i++) {
            View childAt=getChildAt(i);
            childAt.measure(0,0);
            int width=childAt.getMeasuredWidth();
            int height=childAt.getMeasuredHeight();
            left=right+space;
            right=left+width;
            if (right>screashWidth){
                left=space;
                right=left+width;
                top=buttom+space;
            }
            buttom=top+height;
            childAt.layout(left,top,right,buttom);
        }
    }

    public void setAddText(MyFlowView.addText addText) {
        this.addText = addText;
    }

    public interface addText{
        void  onAddtext(String tag);
    }
}
