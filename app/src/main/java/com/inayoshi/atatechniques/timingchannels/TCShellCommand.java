package com.inayoshi.atatechniques.timingchannels;

import android.util.Log;
import com.inayoshi.atatechniques.MainActivity;

public class TCShellCommand {
    public static String trick(String in) {
        String out = "";
        long start;
        long end;
        String[] sleep_command;
        Runtime runtime = Runtime.getRuntime();

        try {
            for (int i = 0; i < in.length(); i++) {
                sleep_command = new String[]{"sleep", String.valueOf(in.charAt(i))};

                start = System.currentTimeMillis();
                Process p = runtime.exec(sleep_command);
                p.waitFor();
                end = System.currentTimeMillis();

                out = out + ((end - start)/1000);
            }
        } catch (Exception e) {
            Log.i(MainActivity.TAG, Log.getStackTraceString(e));
        }

        return out;
    }
}
