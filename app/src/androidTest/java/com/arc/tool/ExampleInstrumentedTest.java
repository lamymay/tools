package com.arc.tool;

import android.content.Context;
import android.util.Patterns;
import android.webkit.URLUtil;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.arc.tool", appContext.getPackageName());

        System.out.println(isUri("www.baidu.com"));
        System.out.println(isUri("http://www.baidu.com"));
        System.out.println(isUri("youtube.coxm"));
        System.out.println(isUri("122.51.110.127/file"));
        System.out.println(isUri(""));
        //        if (Patterns.WEB_URL.matcher(uri).matches() || URLUtil.isValidUrl(uri)) {
        //            Intent intent = new Intent(MainActivity.this, OutputImage.class);
        //            intent.putExtra("webUrl", query);
        //            startActivity(intent);
        //        Android 开发过程中遇到一个检测用户输入是否是合法Uri的需求，这里记录一下方法
        //        主要是用到了Android里面的Patterns包和URLUtil包，比较简单

    }


    /**
     * 用以上方法就能检测出一般的uri输入，比如下面这样的
     *
     * @param uri uriString
     * @return boolean
     */
    private static boolean isUri(String uri) {
        return Patterns.WEB_URL.matcher(uri).matches() || URLUtil.isValidUrl(uri);
    }
}
