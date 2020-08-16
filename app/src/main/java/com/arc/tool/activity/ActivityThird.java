package com.arc.tool.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.arc.tool.R;

/**
 * 活动1
 *
 * @author 叶超
 * @since 2020/2/9 12:22
 */
public class ActivityThird extends Activity implements View.OnClickListener {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        findViewById(R.id.btn3_1).setOnClickListener(this);
        imageView = findViewById(R.id.activity3_imageView1);

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btn3_1) {
            int level = imageView.getDrawable().getLevel();
            level += 1000;
            if (level > 10000) {
                level = 1000;
            }
            imageView.getDrawable().setLevel(level);
        }

    }

}


