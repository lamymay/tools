package com.arc.tool.activity.test2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;
import com.arc.tool.R;
import com.arc.tool.activity.test1.ActivityFirst;
import com.arc.tool.activity.test1.MainActivity;

/**
 * 活动1
 *
 * @author 叶超
 * @since 2020/08/17 00:40
 */
public class CaptureActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //绑定视图
        setContentView(R.layout.activity_first);
        new Handler().postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        //用Intent 实现跳转 ，作用： 从一个（this）活动跳转到另一个活动，第一个参数是当前类.this,第二个参数是要跳转的那个类.class
                        Intent intent = new Intent(ActivityFirst.this, MainActivity.class);

                        //从一个a activity 跳转 b activity 并携带参数
                        intent.putExtra("key1", 123456);
                        intent.putExtra("key2", "String type");
                        startActivityForResult(intent, 0x10);  //此行代码表示跳转后，想要拿到返回值
                        startActivity(intent);
                    }
                }, 2000);
    }

    /**
     * 用这个函数来接收返回值
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //注意是两个code 别判断错了
/*        if (requestCode == 0x10) {  // 这个地方填的是我上面填的值  0x10
            if (resultCode == Activity.RESULT_OK) {
                // B  to A ,A is this
                // 注意是 data 中get
                int val1FromB = data.getIntExtra("bKey1", 0); //基本数据类型注意给出默认值}
                String val2FromB = data.getStringExtra("bKey2");
                Toast.makeText(this, "接收到的参数" + val1FromB + val2FromB, Toast.LENGTH_SHORT).show();
            }
        }*/

        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("image/*");
        startActivityForResult(intent, REQUEST_IMAGE);

        /**
         * 处理二维码扫描结果
         */
        if (requestCode == 0x10) {
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
                    Toast.makeText(MainActivity.this, "解析二维码失败", Toast.LENGTH_LONG).show();
                }
            }
        }

    }
}


