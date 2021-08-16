package com.inayoshi.atatechniques.timingchannels;

import android.util.Log;
import java.io.File;
import com.inayoshi.atatechniques.MainActivity;

public class TCFileShellHybrid {
    public static String trick(String in, File filesDir) {
        String out = "";
        long start;
        long end;
        String[] sleep_command;
        Runtime runtime = Runtime.getRuntime();

        try {
            for (int i = 0; i < in.length(); i++) {
                File file = new File(filesDir, in.substring(i, i+1));
                file.createNewFile();

                sleep_command = new String[]{"/system/bin/sh", "-c", "sleep $(ls "+filesDir.getAbsolutePath()+")"};

                start = System.currentTimeMillis();
                Process p = runtime.exec(sleep_command);
                p.waitFor();
                end = System.currentTimeMillis();

                out = out + ((end - start)/1000);
                file.delete();
            }
        } catch (Exception e) {
            Log.i(MainActivity.TAG, Log.getStackTraceString(e));
        }

        return out;
    }
}
