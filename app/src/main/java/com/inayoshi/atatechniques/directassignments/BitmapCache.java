package com.inayoshi.atatechniques.directassignments;

import android.graphics.Bitmap;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.ContentFrameLayout;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import com.inayoshi.atatechniques.MainActivity;

public class BitmapCache {
    public static String trick(String in, File filesDir, TextView textView, ContentFrameLayout contentFrameLayout) {
        String out = "";
        String filepath = filesDir.getAbsolutePath()+"/secret.png";
        File file = new File(filepath);
        byte[] pngBytes = new byte[4200];

        textView.setText(in);

        saveCapture(contentFrameLayout, file);

        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            int readBytes = bufferedInputStream.read(pngBytes, 0, 4200);
            Log.i(MainActivity.TAG, "Number of bytes read:" + readBytes);
            out = Base64.encodeToString(pngBytes, Base64.DEFAULT);
        } catch (Exception e) {
            Log.i(MainActivity.TAG, Log.getStackTraceString(e));
        }

        return out;
    }
    public static void saveCapture(View view, File file) {
        Bitmap capture = getViewCapture(view);
        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(file, false);
            capture.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            Log.i(MainActivity.TAG, Log.getStackTraceString(e));
        }
    }
    public static Bitmap getViewCapture(View view) {
        view.setDrawingCacheEnabled(true);
        view.measure(View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.buildDrawingCache(true);

        Bitmap cache = Bitmap.createBitmap(view.getDrawingCache());

        if (cache == null) {
            return null;
        }
        Bitmap screenShot = Bitmap.createBitmap(cache);
        view.setDrawingCacheEnabled(false);
        return screenShot;
    }

}