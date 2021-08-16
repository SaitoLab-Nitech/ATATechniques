package com.inayoshi.atatechniques.controldependencies;

import android.util.Log;

import java.io.File;
import com.inayoshi.atatechniques.MainActivity;

public class CDFileLastModified {
    public static String trick(String in, File filesDir) {
        String out = "";

        String filename = "secret.txt";
        long time = 1310198774000L;
        File file = new File(filesDir, filename);

        for (int i = 0; i < in.length(); i++) {
            for (int j = 0; j < 256; j++) {
                try {
                    file.createNewFile();
                    file.setLastModified(time);

                    if (in.charAt(i) == j) {
                        file.setLastModified(time + 1000);
                    }

                    if (file.lastModified() != time) {
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
