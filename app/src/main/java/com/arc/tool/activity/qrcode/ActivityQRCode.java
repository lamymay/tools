package com.arc.tool.activity.qrcode;

import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.arc.tool.R;
import com.arc.tool.utils.CreateCode;

/**
 * 活动1
 *
 * @author 叶超
 * @since 2020/08/16 21:48
 */
public class ActivityQRCode extends AppCompatActivity {

    /**
     * 标志位
     */
    public final static int REQUEST_CODE = 1;

    //  private EditText editText;
    //    private AutoCompleteTextView textView;

    //输出图片
    //    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);

        //        imageView = findViewById(R.id.outputImage);


        //通过R.layout.文件名称来关联这个
        //点击事件
        Button clickEvent = (Button) findViewById(R.id.qrBtnCreateImg);
        Button qrBtnScanImageButton = (Button) findViewById(R.id.qrBtnScanImage);
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
                new CreateCode().createQR(inputString, imageView, getApplicationContext());
            }
        });

        //点击 启动相机识别二维码
        qrBtnScanImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = "点击 启动相机识别二维码";
                Toast.makeText(ActivityQRCode.this, message, Toast.LENGTH_SHORT).show();

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

            }
        });

    }


    //git@github.com:yipianfengye/android-zxingLibrary.git
}


