package com.arc.tool.activity.qrcode;

import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.arc.tool.R;
import com.arc.tool.utils.OutputImage;

/**
 * 活动1
 *
 * @author may
 * @since 2020/08/16 21:48
 */
public class ActivityQRCode extends AppCompatActivity {

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
                String message = "假装在识别二维码";
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


}


