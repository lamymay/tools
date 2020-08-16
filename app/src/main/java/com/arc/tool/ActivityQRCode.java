package com.arc.tool;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.arc.tool.code.CreateCode;
import com.arc.tool.code.ScanQRImage;

/**
 * 活动1
 *
 * @author 叶超
 * @since 2020/08/16 21:48
 */
public class ActivityQRCode extends AppCompatActivity {

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
                //输入框
                AutoCompleteTextView input = (AutoCompleteTextView) findViewById(R.id.qrInput1);
                String inputString = input.getText().toString();
                System.out.println(input);
                System.out.println(inputString);

                //输出图片
                ImageView imageView = findViewById(R.id.qrOutputImage);
                new ScanQRImage().scanQRImage(  getApplicationContext());
            }
        });

    }


}


