package com.inayoshi.atatechniques.directassignments;

import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import com.inayoshi.atatechniques.MainActivity;

public class FileShellHybrid {
    public static String trick(String in, File filesDir) {
        String out = "";
        String filename = "secret.txt";
        File file = new File(filesDir, filename);
        String filepath = file.getAbsolutePath();

        String[] cmd = new String[]{"cat", filepath};
        Runtime runtime = Runtime.getRuntime();

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(in.getBytes());

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(runtime.exec(cmd).getInputStream()));
            out = bufferedReader.readLine();
        } catch (Exception e) {
            Log.i(MainActivity.TAG, Log.getStackTraceString(e));
        }

        return out;
    }
}
