package com.arc.tool.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Patterns;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.Toast;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.util.HashMap;
import java.util.Map;

/**
 * 文本转二维码并输出
 * implementation 'com.google.zxing:core:3.3.0'
 * 类库的源码 git@github.com:yipianfengye/android-zxingLibrary.git
 *
 * @author may
 * @date 2020/08/16
 */
public class OutputImage {

    /**
     * 点击后执行的函数
     */
    public void createQR(String inputString, ImageView imageView, Context applicationContext) {

        //格式化下字符串,推测是网址的自动加上http
        inputString = formatInputString(inputString);
        //输入框
        Bitmap bitmap = createQRImage(inputString, 500, 500);
        imageView.setImageBitmap(bitmap);
        //imageView.setTooltipText("");
        //提示被点击了
        Toast toast = Toast.makeText(applicationContext, "二维码中文本是" + inputString, Toast.LENGTH_SHORT);
        toast.show();

    }

    private String formatInputString(String inputString) {
        if (inputString == null) {
            return null;
        }
        if (inputString.endsWith(".com") && !inputString.startsWith("http")) {
            return "http://" + inputString;
        }
        if (inputString.endsWith(".cn") && !inputString.startsWith("http")) {
            return "http://" + inputString;
        }
        if (inputString.contains("/") && !inputString.startsWith("http")) {
            return "http://" + inputString;
        }

        return inputString;
    }




    /**
     * 生成二维码Bitmap
     *
     * @param content   内容
     * @param widthPix  图片宽度
     * @param heightPix 图片高度
     * @return 生成二维码及保存文件是否成功
     */
    public static Bitmap createQRImage(String content, int widthPix, int heightPix) {

        Bitmap bitmap = null;
        try {
            if (content == null || "".equals(content)) {
                return bitmap;
            }
            //配置参数
            Map<EncodeHintType, Object> hints = new HashMap<>();
            hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
            //容错级别
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
            //设置空白边距的宽度
            hints.put(EncodeHintType.MARGIN, 2); //default is 4

            // 图像数据转换，使用了矩阵转换
            BitMatrix bitMatrix = null;
            try {
                bitMatrix = new QRCodeWriter().encode(content, BarcodeFormat.QR_CODE, widthPix, heightPix, hints);
            } catch (WriterException e) {
                e.printStackTrace();
            }
            int[] pixels = new int[widthPix * heightPix];
            // 下面这里按照二维码的算法，逐个生成二维码的图片，
            // 两个for循环是图片横列扫描的结果
            for (int y = 0; y < heightPix; y++) {
                for (int x = 0; x < widthPix; x++) {
                    if (bitMatrix.get(x, y)) {
                        pixels[y * widthPix + x] = 0xff000000;
                    } else {
                        pixels[y * widthPix + x] = 0xffffffff;
                    }
                }
            }

            // 生成二维码图片的格式，使用ARGB_8888
            bitmap = Bitmap.createBitmap(widthPix, heightPix, Bitmap.Config.ARGB_8888);
            bitmap.setPixels(pixels, 0, widthPix, 0, 0, widthPix, heightPix);

            //必须使用compress方法将bitmap保存到文件中再进行读取。直接返回的bitmap是没有任何压缩的，内存消耗巨大！
//            boolean compress = bitmap.compress(Bitmap.CompressFormat.JPEG, 100, new FileOutputStream(filePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }


}

