package com.wd.doctor.activity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.wd.doctor.IDCard.AuthService;
import com.wd.doctor.IDCard.Idcard;
import com.wd.doctor.MyView.MyTitleView;
import com.wd.doctor.R;
import com.wd.doctor.base.BaseActivity;
import com.wd.doctor.net.App;
import com.wd.doctor.net.NetManager;
import com.wd.doctor.util.SpCacheUtil;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

/**
 * @author 吴健
 * Pseudonym:䦦鬰
 * @description:待实现功能
 * @date :2020/5/25 14:49
 * @classname :
 * //绑定身份证
 */
public class BangingIdcardActivity extends BaseActivity {
    private int MAX_SIZE = 769;
    private int flag=0;
    private MyTitleView titleView;
    private ImageView cameraIccard;
    private ImageView cameraRecitecard;
    private Button btnNext;
    private ImageView imgIDCard;
    private android.widget.TextView text;
    private ImageView imgCardPerson;
    private androidx.constraintlayout.widget.ConstraintLayout card1;
    private ImageView imgCardCH;
    private androidx.constraintlayout.widget.ConstraintLayout card2;
    private ImageView cameraCardP;
    private ImageView cameraCardCH;
    private ImageView imgIDCardCH;
    private TextView text2;

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
        //点击
        cameraCardP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag=0;
                initPopWindow(v);
                //一次
                //AuthService.getAuth();
            }
        });
        cameraCardCH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag=1;
                initPopWindow(v);
            }
        });
        //  XXx
        imgCardPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cameraCardP.setVisibility(VISIBLE);
                imgCardPerson.setVisibility(GONE);
                text.setVisibility(VISIBLE);
                imgIDCard.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.mipmap.id_card_front));
            }
        });
        imgCardCH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cameraCardCH.setVisibility(VISIBLE);
                imgCardCH.setVisibility(GONE);
                text2.setVisibility(VISIBLE);
                imgIDCardCH.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.mipmap.id_card_back));
            }
        });
    }

    @Override
    public int initLayoutId() {
        return R.layout.activity_banging_idcard;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
    private void initPopWindow(View v) {
        View view = LayoutInflater.from(BangingIdcardActivity.this).inflate(R.layout.item_popcard, null, false);
        Button btn_start = view.findViewById(R.id.btn_start);
        Button btn_cancle = view.findViewById(R.id.btn_cancle);
        //1.构造一个PopupWindow，参数依次是加载的View，宽高
        final PopupWindow popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setAnimationStyle(R.anim.anim_pop);//设置加载动画
        //点击非PopupWindow区域，PopupWindow会消失的
        popupWindow.setTouchable(true);
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
                // 这里如果返回true的话，touch事件将被拦截
                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
            }
        });
        //要为popWindow设置一个背景才有效
        popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
        //设置popupWindow显示的位置，参数依次是参照View，x轴的偏移量，y轴的偏移量
        View inflate = LayoutInflater.from(BangingIdcardActivity.this).inflate(R.layout.item_popcard, null);
        popupWindow.showAtLocation(inflate, Gravity.BOTTOM, 0,0);
        //点击事件
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //打开相册，换头像,添加评论图片
                openGallery(v);
                popupWindow.dismiss();
            }
        });
        //取消
        btn_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
    }
    // 打开相册
    public void openGallery(View view) {
        Intent intent =new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");

        // 开启一个带有返回值的Activity，请求码为PHOTO_REQUEST_GALLERY
        startActivityForResult(intent,0);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 从相册返回的数据
        if(requestCode ==0) {
            if(data !=null) {
                Uri uri = data.getData();
                //图片  圆
                /*CircleCrop circleCrop = new CircleCrop();
                RequestOptions requestOptions = RequestOptions.bitmapTransform(circleCrop);*/
            //    Glide.with(App.context).load(uri).into(imgSetUpHeadWy);
            /*    NetManager netManager = NetManager.Companion.getNetManager();
                netManager.getPhoto(uri,imgIDCard);*/

                //uri转换成file
                String[] arr = {MediaStore.Images.Media.DATA};
                Cursor cursor = managedQuery(uri, arr, null, null, null);
                int img_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                cursor.moveToFirst();
                String img_path = cursor.getString(img_index);
                File file = new File(img_path);
                String path = file.getAbsolutePath();
                File file1 = new File( path );
                //   识别身份证信息
                Idcard.idcard(path);
                Log.d("===", "onActivityResult: "+path);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = false;
                try{
                    InputStream inputStream = getContentResolver().openInputStream(uri);
                    BitmapFactory.decodeStream(inputStream,null,options);
                    inputStream.close();
                    int height = options.outHeight;
                    int width = options.outWidth;
                    int sampleSize = 1;
                    int max = Math.max(height,width);
                    if (max>MAX_SIZE){
                        int nw = width/2;
                        int nh = height/2;
                        while ((nw/sampleSize)> MAX_SIZE || (nh / sampleSize)>MAX_SIZE){
                            sampleSize *=2;
                        }
                    }
                    options.inSampleSize = sampleSize;
                    options.inJustDecodeBounds = false;
                    Bitmap bitmap = BitmapFactory.decodeStream( getContentResolver().openInputStream( uri ), null, options );
                    //设置
                    if(flag==0){
                        imgIDCard.setImageBitmap(bitmap);
                        cameraCardP.setVisibility(GONE);
                        imgCardPerson.setVisibility(VISIBLE);
                        text.setVisibility(GONE);
                    }else{
                        imgIDCardCH.setImageBitmap(bitmap);
                        cameraCardCH.setVisibility(GONE);
                        imgCardCH.setVisibility(VISIBLE);
                        text2.setVisibility(GONE);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
                /*RequestBody requestBody = RequestBody.create( MediaType.parse( "multipart/form-data"), file );
                MultipartBody.Part image = MultipartBody.Part.createFormData("image", file.getName(), requestBody);
                //头像  请求接口
                presenter.getModifyHeadPic(image);*/
            }
        }

    private void initView() {
        titleView = (MyTitleView) findViewById(R.id.title_view);
        btnNext = (Button) findViewById(R.id.btn_next);
        imgIDCard = (ImageView) findViewById(R.id.imgIDCard);
        text = (TextView) findViewById(R.id.text);
        imgCardPerson = (ImageView) findViewById(R.id.imgCardPerson);
        card1 = (ConstraintLayout) findViewById(R.id.card1);
        imgCardCH = (ImageView) findViewById(R.id.imgCardCH);
        card2 = (ConstraintLayout) findViewById(R.id.card2);
        cameraCardP = (ImageView) findViewById(R.id.cameraCardP);
        cameraCardCH = (ImageView) findViewById(R.id.cameraCardCH);
        imgIDCardCH = (ImageView) findViewById(R.id.imgIDCardCH);
        text2 = (TextView) findViewById(R.id.text2);
    }

    @NotNull
    @Override
    public String getLoggerTag() {
        return null;
    }
}
