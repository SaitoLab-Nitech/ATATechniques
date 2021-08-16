package com.inayoshi.atatechniques.memoryoperations;

import android.text.TextUtils;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Collections;
import com.inayoshi.atatechniques.MainActivity;

public class FileLength {
    public static String trick(String in, File filesDir) {
        String out = "";
        String filename = "secret.txt";

        for (int i = 0; i < in.length(); i++) {
            String string = TextUtils.join("", Collections.nCopies(in.charAt(i), "A"));

            try {
                File file = new File(filesDir, filename);

                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(string.getBytes());

                file = null;

                file = new File(filesDir, filename);

                out += (char) file.length();
                file.delete();
            } catch (Exception e) {
                Log.i(MainActivity.TAG, Log.getStackTraceString(e));
            }
        }
        return out;
    }
}
