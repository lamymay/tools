package com.arc.tool.activity.qrcode;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.arc.tool.R;
import com.arc.tool.utils.CheckPermissionUtils;
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
public class QRMainActivity extends AppCompatActivity {

    /**
     * 标志位
     */
    public final static int REQUEST_CODE = 1;

    TextView qrScanShowTextView;

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //通过R.layout.文件名称来关联一个布局文件
        setContentView(R.layout.activity_qr);
//        System.out.println("1测试判断是否是链接,预期true,实际="+isUri("http://www.baidu.com"));//true
//        System.out.println("2测试判断是否是链接,预期true,实际="+isUri("https://www.baidu.com"));//true
//        System.out.println("3测试判断是否是链接,预期true,实际="+isUri("www.baidu.com"));
//        System.out.println("4测试判断是否是链接,预期true,实际="+isUri("baidu.com"));
//        System.out.println("5测试判断是否是链接,预期true,实际="+isUri("baidu.edu"));
//        System.out.println("6测试判断是否是链接,预期true,实际="+isUri("122.51.110.127/file"));
//        System.out.println("7测试判断是否是链接,预期 false,实际="+isUri(""));//false


        // 1 检查相机权限
        CheckPermissionUtils.getCameraPermission(QRMainActivity.this);

        qrScanShowTextView = (TextView) findViewById(R.id.qrScanShowText);
//
//        if (qrScanShowTextView != null) {
//            qrScanShowTextView.setText("123");


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
                imageView = findViewById(R.id.qrOutputImage);
                new OutputImage().createQR(inputString, imageView, getApplicationContext());
            }
        });

        //点击 启动相机识别二维码
        Button qrBtnScanImageButton = (Button) findViewById(R.id.qrBtnScanImage);
        qrBtnScanImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //  2扫码
                scan(QRMainActivity.this);
                //处理返回结果

            }
        });

    }




    private void scan(QRMainActivity context) {


        // String message = "识别二维码" + context;
//        Toast.makeText(ActivityQRCode.this, message, Toast.LENGTH_SHORT).show();
//
        ZXingLibrary.initDisplayOpinion(QRMainActivity.this);
        Intent intent = new Intent(QRMainActivity.this, CaptureActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }


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

                    qrScanShowTextView.setText(result);
                    //  Uri uri = Uri.parse(result);
//                    Intent webBrowserIntent = new Intent(Intent.ACTION_VIEW, uri);
//                    startActivity(webBrowserIntent);


                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(QRMainActivity.this, "解析二维码失败", Toast.LENGTH_LONG).show();
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
