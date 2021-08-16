package com.inayoshi.atatechniques.memoryoperations;

import android.graphics.Bitmap;

public class BitmapPixel {
    public static String trick(String in) {
        String out = "";
        int y;
        Bitmap bitmap = Bitmap.createBitmap(500, 500, Bitmap.Config.ARGB_8888);

        for (int i = 0; i < in.length(); i++) {
            y = in.charAt(i) ^ 0xFFFF0000;
            bitmap.setPixel(10, 10, y);

            out = out + (char) (bitmap.getPixel(10, 10) ^ 0xFFFF0000);
        }

        return out;
    }
}
