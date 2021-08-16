/*
    Test suite with anti-taint-analysis techniques.
    Copyright (C) 2021  Nagoya Institute of Technology, Hiroki Inayoshi

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.
*/

package com.inayoshi.atatechniques.controldependencies;

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


public class CDBitmapCache {
    public static String trick(String in, File filesDir, TextView textView, ContentFrameLayout contentFrameLayout) {
        String out = "";
        String filepath = filesDir.getAbsolutePath()+"/secret.png";
        File file = new File(filepath);

        for (int i = 0; i < in.length(); i++) {
            for (int j = 0; j < 10; j++) {
                textView.setText("0");

                if (Integer.valueOf(in.substring(i, i+1)) == j) {
                    textView.setText("1");
                }

                saveCapture(contentFrameLayout, file);

                try {
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                    byte[] pngBytes = new byte[610];
                    int readBytes = bufferedInputStream.read(pngBytes, 0, 610);
                    Log.i(MainActivity.TAG, "Number of bytes read:" + readBytes);
                    out = out + Base64.encodeToString(pngBytes, Base64.DEFAULT);
                } catch (Exception e) {
                    Log.i(MainActivity.TAG, Log.getStackTraceString(e));
                }
            }
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
