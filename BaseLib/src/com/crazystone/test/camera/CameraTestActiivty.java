package com.crazystone.test.camera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.crazystone.quickdev.annotation.SetContentView;
import com.crazystone.quickdev.annotation.ViewInject;
import com.crazystone.test.R;
import com.crazystone.utils.BaseActivity;
import com.crazystone.utils.StorageUtils;
import com.crazystone.utils.common.L;
import com.crazystone.utils.common.UIUtils;

import java.io.File;
import java.util.Random;

/**
 * Created by crazystone on 2016/3/8.
 */
@SetContentView(R.layout.activity_camera)
public class CameraTestActiivty extends BaseActivity {

    public static final int IMAGE_REQUEST_CODE = 0X100;
    @ViewInject(R.id.camera_btn)
    private Button mBtn_take_photo;
    @ViewInject(R.id.img_photo)
    private ImageView mImg_show_photo;
    private Uri photoUri;//photo uri
    private File photoFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        $(mBtn_take_photo);

    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        if (view.getId() == R.id.camera_btn) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//            photoUri=getOutputUri();
            photoFile=getOutputFile();
            intent.putExtra(MediaStore.EXTRA_OUTPUT,photoFile );
            startActivityForResult(intent, IMAGE_REQUEST_CODE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == IMAGE_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Bitmap map=BitmapFactory.decodeFile(StorageUtils.imgPath);
                mImg_show_photo.setImageBitmap(map);
//                Uri uri = null;
//                if (data != null) {
//                    uri = data.getData();
//                    L.d("photo path:" + uri.getPath());
//                    mImg_show_photo.setImageURI(uri);
//                    UIUtils.shortToast(this, "photo path:" + uri.getPath());
//                } else {
//                    UIUtils.shortToast(this, "uri is null");
//                }
            } else if (resultCode == RESULT_CANCELED) {
                UIUtils.shortToast(this, "cancel");
            } else {
                UIUtils.shortToast(this, "else");
            }
        }
    }

    public Uri getOutputUri() {
        File file = StorageUtils.getExternalFile(getRandomName());
        Uri uri = Uri.fromFile(file);
        return uri;
    }

    public File getOutputFile(){
        return StorageUtils.getExternalFile(getRandomName());
    }

    public static String getRandomName() {
        return new Random().nextInt() + ".jpg";
    }
}
