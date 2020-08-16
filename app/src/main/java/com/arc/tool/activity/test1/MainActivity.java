package com.arc.tool.activity.test1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.arc.tool.R;

/**
 * 要运行，需要有有一个 Activity
 * 1、成为Activity类则需要继承Activity
 * 2、新建一个布局 src/main/res/layout/activity_main.xml
 * 问题：
 * @author may
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        //A to B  ,B is this START
//        int v1 = getIntent().getIntExtra("key1", 0);//接收int类型的数字，如果为null需要给默认值，基本数据类型注意给出默认值
//        String v2 = getIntent().getStringExtra("key2");//接收String数据
//        Toast.makeText(this, "接收到的参数" + v1 + v2, Toast.LENGTH_SHORT).show();//Toast 用于弹出提示
//        //A to B  ,B is this  END

        Intent intent = new Intent();//在这个地方返回数据
        intent.putExtra("bKey1", 4444);
        intent.putExtra("bKey2", "返回值是 String 啦啦啦");
        setResult(Activity.RESULT_OK, intent);//返回成功并带上数据
        finish(); //结束当前页面
    }
}
