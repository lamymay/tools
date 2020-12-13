package com.arc.tool.utils;

import android.graphics.*;
import android.util.Patterns;
import android.webkit.URLUtil;

public class UrlUtil     {


    public static boolean isUri(String uri) {
        return Patterns.WEB_URL.matcher(uri).matches() || URLUtil.isValidUrl(uri);
    }

    private Paint mPaint = new Paint();



    private Bitmap getCircleBitmap(Bitmap bitmap) {

        Bitmap circleBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(circleBitmap);

        mPaint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        int radius = bitmap.getWidth() / 2;
        canvas.drawCircle(radius, radius, radius, mPaint);
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, 0, 0, mPaint);
        return circleBitmap;
    }


}

