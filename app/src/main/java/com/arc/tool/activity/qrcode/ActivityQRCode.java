package com.arc.tool.activity.qrcode;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.arc.tool.R;
import com.arc.tool.utils.OutputImage;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

/**
 * 活动1
 *
 * @author may
 * @since 2020/08/16 21:48
 */
public class ActivityQRCode extends AppCompatActivity {

    /**
     * 标志位
     */
    public final static int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //通过R.layout.文件名称来关联一个布局文件
        setContentView(R.layout.activity_qr);

        //点击事件
        Button clickEvent = (Button) findViewById(R.id.qrBtnCreateImg);
        clickEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //输入框
                AutoCompleteTextView input = (AutoCompleteTextView) findViewById(R.id.qrInput1);
                String inputString = input.getText().toString();
                System.out.println(input);
                System.out.println(inputString);

                //输出图片
                ImageView imageView = findViewById(R.id.qrOutputImage);
                new OutputImage().createQR(inputString, imageView, getApplicationContext());
            }
        });

        //点击 启动相机识别二维码
        Button qrBtnScanImageButton = (Button) findViewById(R.id.qrBtnScanImage);
        qrBtnScanImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //scan(ActivityQRCode.this);
                String message = "识别二维码";
                Toast.makeText(ActivityQRCode.this, message, Toast.LENGTH_SHORT).show();

                ZXingLibrary.initDisplayOpinion(ActivityQRCode.this);
                Intent intent = new Intent(ActivityQRCode.this, CaptureActivity.class);
                startActivityForResult(intent, REQUEST_CODE);

            }
        });

    }

//    private void scan(ActivityQRCode activityQRCode) {
//
//    }


    /**
     * 处理二维码扫描结果
     * Dispatch incoming result to the correct fragment.
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            //处理扫描结果（在界面上显示）
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    Toast.makeText(this, "解析结果:" + result, Toast.LENGTH_LONG).show();
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(ActivityQRCode.this, "解析二维码失败", Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}


//                //输入框
//                AutoCompleteTextView input = (AutoCompleteTextView) findViewById(R.id.qrInput1);
//                String inputString = input.getText().toString();
//                System.out.println(input);
//                System.out.println(inputString);
//
//                //输出图片
//                ImageView imageView = findViewById(R.id.qrOutputImage);
//                //   new ScanQRImage().scanQRImage(  getApplicationContext());
//
//                Intent intent = new Intent(this, CaptureActivity.class);
//                startActivityForResult(intent, 0x10);
