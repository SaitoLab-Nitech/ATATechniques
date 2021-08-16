package com.inayoshi.atatechniques.directassignments;

import android.util.Log;

import java.io.File;
import com.inayoshi.atatechniques.MainActivity;

public class FileLastModified {
    public static String trick(String in, File filesDir) {
        String out = "";

        String filename = "secret.txt";
        long time = 1310198774000L;
        int multiplier = 1000;
        int diff;
        long lastModified;

        try {
            File file = new File(filesDir, filename);
            file.createNewFile();

            for (int i = 0; i < in.length(); i++) {
                lastModified = time + (long) ((int)in.charAt(i) * multiplier);
                file.setLastModified(lastModified);

                file = null;

                file = new File(filesDir, filename);

                diff = (int) (file.lastModified() - time);
                out = out + (char) (diff / multiplier);
            }
        } catch (Exception e) {
            Log.i(MainActivity.TAG, Log.getStackTraceString(e));
        }

        return out;
    }

}
