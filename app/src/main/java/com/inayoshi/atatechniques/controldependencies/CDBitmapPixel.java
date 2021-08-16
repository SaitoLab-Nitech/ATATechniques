package com.inayoshi.atatechniques.controldependencies;

import android.graphics.Bitmap;

public class CDBitmapPixel {
    public static String trick(String in) {
        String out = "";
        int color;
        Bitmap bitmap = Bitmap.createBitmap(500, 500, Bitmap.Config.ARGB_8888);

        for (int i = 0; i < in.length(); i++) {
            for (int j = 0; j < 256; j++) {
                bitmap.setPixel(10, 10, 0xFFFF0000);

                if (in.charAt(i) == j) {
                    bitmap.setPixel(10, 10, 1 ^ 0xFFFF0000);
                }

                color = bitmap.getPixel(10, 10) ^ 0xFFFF0000;
                if (color == 1) {
                    out = out + (char) j;
                }
            }
        }

        return out;
    }
}
