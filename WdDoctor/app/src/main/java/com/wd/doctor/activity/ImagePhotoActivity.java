package com.wd.doctor.activity;

import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.wd.doctor.R;
import com.wd.doctor.adapter.wy.RecyclerViewImageAdapter;
import com.wd.doctor.base.BaseActivity;
import com.wd.doctor.bean.wy.FindSystemImagePicBean;
import com.wd.doctor.mvp.wy.presenterImpl.FindSystemImagePicPresenterImpl;
import com.wd.doctor.mvp.wy.view.FindSystemImagePicView;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/31 15:43
 * @classname :ImagePhotoActivity
 */
public class ImagePhotoActivity extends BaseActivity implements FindSystemImagePicView {
    private com.wd.doctor.MyView.MyTitleView myTitleGift;
    private androidx.recyclerview.widget.RecyclerView recyclerImageHead;
    private FindSystemImagePicPresenterImpl presenter;
    private RecyclerViewImageAdapter adapter;
    private android.widget.ImageView imgBackPic;

    @Override
    public int initLayoutId() {
        return R.layout.activity_image_photo;
    }
    private void initView() {
        recyclerImageHead = (RecyclerView) findViewById(R.id.recyclerImageHead);
        imgBackPic = (ImageView) findViewById(R.id.imgBackPic);
    }
    @Override
    protected void initListener() {
        super.initListener();
        initView();
        imgBackPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //presenter
        presenter = new FindSystemImagePicPresenterImpl(this);
        //adapter
        adapter = new RecyclerViewImageAdapter();
    }

    @Override
    protected void initData() {
        super.initData();
        initView();
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, OrientationHelper.HORIZONTAL);
        recyclerImageHead.setLayoutManager(staggeredGridLayoutManager);
        //请求
        presenter.onFindSystemImagePicSuccess();
    }

    @NotNull
    @Override
    public String getLoggerTag() {
        return null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.destroyView();
    }

    @Override
    public void onFindSystemImagePicError(@Nullable String message) {
    }
    @Override
    public void onFindSystemImagePicSuccess(@Nullable FindSystemImagePicBean reponse) {
        //成功
        List<FindSystemImagePicBean.Result> result = reponse.getResult();
        recyclerImageHead.setAdapter(adapter);
        adapter.updateData(result);
    }
}
