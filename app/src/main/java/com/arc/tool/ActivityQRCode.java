package com.arc.tool;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.arc.tool.code.CreateCode;

/**
 * 活动1
 *
 * @author 叶超
 * @since 2020/08/16 21:48
 */
public class ActivityQRCode extends AppCompatActivity {

//    /**/
//     * 测试代码
//     */
//    private CreateCode createCodeTool = new CreateCode();


    private EditText editText;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);


        editText = (EditText)findViewById(R.id.qr_input_1);
        textView = (TextView)findViewById(R.id.outputText);

//设置EditText按键bai输入时的事件
        editText.setOnKeyListener(new EditText.OnKeyListener(){
            @Override
            public boolean onKey(View arg0, int arg1, KeyEvent arg2) {
// TODO Auto-generated method stub
                textView.setText(editText.getText());//获取edittext的内容
                return false;
            }
        });


        //通过R.layout.文件名称来关联这个
        //点击事件
        //Button qr_btn_create_img = (Button) findViewById(R.id.qr_btn_create_img);
        EditText clickEvent = (EditText) findViewById(R.id.qr_input_1);

        clickEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //输出图片
                ImageView imageView = findViewById(R.id.outputImage);
                //输入框
                EditText input = (EditText) findViewById(R.id.qr_input_1);

                String inputString = input.getText().toString();
                System.out.println(input);
                System.out.println(inputString);
                new CreateCode().createQR(inputString, imageView, getApplicationContext());
            }
        });

    }





}


