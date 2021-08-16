package com.inayoshi.atatechniques.timingchannels;

import android.util.Log;
import com.inayoshi.atatechniques.MainActivity;

public class Timekeeper {
    public static String trick(String in) {
        String out = "";
        long start;
        long end;

        try {
            for (int i = 0; i < in.length(); i++) {
                start = System.currentTimeMillis();
                Thread.sleep(100 * in.charAt(i));
                end = System.currentTimeMillis();

                out = out + (char) ((end - start) / 100);
            }
        } catch (Exception e) {
            Log.i(MainActivity.TAG, Log.getStackTraceString(e));
        }

        return out;
    }
}
