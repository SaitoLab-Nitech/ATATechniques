package com.inayoshi.atatechniques.controldependencies;

import android.util.Log;

import com.inayoshi.atatechniques.MainActivity;

public class CDTimekeeper {
    public static String trick(String in) {
        String out = "";
        long start = 0;
        long end = 0;

        for (int i = 0; i < in.length(); i++) {
            for (int j = 0; j < 256; j++) {
                try {
                    start = System.currentTimeMillis();
                    if (in.charAt(i) == j) {
                        Thread.sleep(1000);
                    }
                    end = System.currentTimeMillis();

                    if ((end - start) > 100) {
                        out = out + (char) j;
                    }
                } catch (Exception e) {
                    Log.i(MainActivity.TAG, Log.getStackTraceString(e));
                }
            }
        }

        return out;
    }
}
