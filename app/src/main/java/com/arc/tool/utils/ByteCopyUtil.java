package com.arc.tool.utils;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 字节拷贝
 *
 * @author may
 */
public class ByteCopyUtil {
    /**
     * 标志位
     */
    public final static int REQUEST_CODE = 1;

    //  private EditText editText;
    //    private AutoCompleteTextView textView;

    //输出图片
    //    ImageView imageView;

    //        imageView = findViewById(R.id.outputImage);


    private byte[] toByteArray(InputStream in) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024 * 4];
        int n = 0;
        while ((n = in.read(buffer)) != -1) {
            out.write(buffer, 0, n);
        }
        return out.toByteArray();
    }

    private byte[] InputStream2ByteArray(String filePath) throws IOException {
        InputStream in = new FileInputStream(filePath);
        byte[] data = toByteArray(in);
        in.close();
        return data;
    }
}
