package com.wd.doctor.activity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.wd.doctor.MyView.MyTitleView;
import com.wd.doctor.R;
import com.wd.doctor.base.BaseActivity;

import org.jetbrains.annotations.NotNull;

/**
 * @author 吴健
 * Pseudonym:䦦鬰
 * @description:待实现功能
 * @date :2020/5/25 14:51
 * @classname :
 * //绑定银行卡
 */
public class BangdingBackcardActivity extends BaseActivity {
    private MyTitleView titleView;
    private ImageView cameraBackcard;
    private Button btnNext;

   /* @Nullable
    @Override
    protected TransitionMode getOverridePendingTransitionMode() {
        return TransitionMode.RIGHT;
    }
*/
    @Override
    protected void initListener() {
        initView();
        titleView.getBack().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        titleView.getTitle().setText("绑定身份证");
    }

    @Override
    public int initLayoutId() {
        return R.layout.activity_bangding_backcard;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    private void initView() {
        titleView = (MyTitleView) findViewById(R.id.title_view);
        cameraBackcard = (ImageView) findViewById(R.id.camera_backcard);
        btnNext = (Button) findViewById(R.id.btn_next);
    }

    @NotNull
    @Override
    public String getLoggerTag() {
        return null;
    }
}
