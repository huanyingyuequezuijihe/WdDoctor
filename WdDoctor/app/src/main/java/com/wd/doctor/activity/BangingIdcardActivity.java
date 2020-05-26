package com.wd.doctor.activity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.wd.doctor.MyView.MytTitleView;
import com.wd.doctor.R;
import com.wd.doctor.base.BaseActivity;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author 吴健
 * Pseudonym:䦦鬰
 * @description:待实现功能
 * @date :2020/5/25 14:49
 * @classname :
 * //绑定身份证
 */
public class BangingIdcardActivity extends BaseActivity {
    private MytTitleView titleView;
    private ImageView cameraIccard;
    private ImageView cameraRecitecard;
    private Button btnNext;

  /*  @Nullable
    @Override
    protected TransitionMode getOverridePendingTransitionMode() {
        return TransitionMode.FADE;
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
        return R.layout.activity_banging_idcard;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    private void initView() {
        titleView = (MytTitleView) findViewById(R.id.title_view);
        cameraIccard = (ImageView) findViewById(R.id.camera_iccard);
        cameraRecitecard = (ImageView) findViewById(R.id.camera_recitecard);
        btnNext = (Button) findViewById(R.id.btn_next);
    }

    @NotNull
    @Override
    public String getLoggerTag() {
        return null;
    }
}
